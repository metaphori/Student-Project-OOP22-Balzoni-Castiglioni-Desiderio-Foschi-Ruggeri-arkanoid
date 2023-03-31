package it.unibo.game.app.model;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import it.unibo.game.Pair;
import it.unibo.game.app.api.Brick;
import it.unibo.game.app.api.BrickType;
import it.unibo.game.app.api.Level;
import it.unibo.game.app.model.ball.Ball;
import it.unibo.game.app.model.brick.NormalBrick;
import it.unibo.game.app.model.dynamic.SpeedImpl;

public class Surprise {

	private final static int NUM_TOT_SURSPRISE = 12;
	private final static int EXTRA_LIFE = 1;
	private final static int EXPLOSIVE_BOMB = 2;
	private final static int DELETE_RANDOM_BRICKS = 3;
	private final static int REDUCE_SIZE_PAD = 4;
	private final static int ENLARGE_SIZE_PAD = 5;
	private final static int INCREASE_BALL_SPEED = 6;
	private final static int DECREASE_BALL_SPEED = 7;
	private final static int CHANGE_OBSTACLES = 8;
	private final static int INCREASE_SCORE = 9;
	private final static int ADD_BALLS = 10;
	private final static int CHANGE_ROW = 11;
	private final static int CHANGE_HARD = 12;

	private final static int NUM_BALLS = 3;

	private Map<Integer, Runnable> mappa;
	private Random random = new Random();
	private Level level;

	public Surprise(Level level) {
		this.level = level;

		mappa = new HashMap<>(Map.ofEntries(Map.entry(EXTRA_LIFE, () -> this.extraLife()),
				Map.entry(EXPLOSIVE_BOMB, () -> this.explosiveBomb()),
				Map.entry(DELETE_RANDOM_BRICKS, () -> this.deleteRandomBricks()),
				Map.entry(REDUCE_SIZE_PAD, () -> this.reduceSizePad()),
				Map.entry(ENLARGE_SIZE_PAD, () -> this.enlargeSizePad()),
				Map.entry(INCREASE_BALL_SPEED, () -> this.increaseBallSpeed()),
				Map.entry(DECREASE_BALL_SPEED, () -> this.decreaseBallSpeed()),
				Map.entry(CHANGE_OBSTACLES, () -> this.changeObstacles()),
				Map.entry(INCREASE_SCORE, () -> this.increaseScore()),
				Map.entry(ADD_BALLS, () -> this.addBalls()),
				Map.entry(CHANGE_ROW, () -> this.addHardRow()),
				Map.entry(CHANGE_HARD, () -> this.changeHard())));
	}

	// simone
	private void extraLife() {
		this.level.increaseLife();

	}

	// simone
	private void explosiveBomb() {
		Brick lastBrick = this.level.getLastSurpriseBrick();
		int index = this.level.getIndex();

		if (this.isIndexPositive(index - 1) && this.isThereLeftBrick(index - 1, lastBrick)
				&& !this.isObstacle(index - 1)) {
			this.deleteBrick(index - 1);
			if (this.isIndexNotTheLast(index - 1)
					&& this.isThereRightBrick(index - 1, lastBrick)
					&& !this.isObstacle(index - 1)) {
				this.deleteBrick(index - 1);
			}
		}
		if (this.isIndexNotTheLast(index) && this.isThereRightBrick(index, lastBrick)
				&& !this.isObstacle(index - 1)) {
			this.deleteBrick(index);
		}
	}

	private boolean isThereLeftBrick(int index, Brick lastBrick) {
		return (this.level.getRound().getBrick().get(index).getPos().getY() == lastBrick
				.getPos().getY()
				&& (lastBrick.getPos().getX() - lastBrick.getBrickW())
						- this.level.getRound().getBrick().get(index).getPos().getX() < 0.1);
	}

	private boolean isThereRightBrick(int index, Brick lastBrick) {
		return (this.level.getRound().getBrick().get(index).getPos().getY() == lastBrick
				.getPos().getY()
				&& (this.level.getRound().getBrick().get(index).getPos().getX()
						- lastBrick.getBrickW()) - lastBrick.getPos().getX() < 0.1);
	}

	private boolean isObstacle(int index) {
		return this.level.getRound().getBrick().get(index).getType()
				.equals(BrickType.OBSTACLE);
	}

	private void deleteBrick(int index) {
		this.level.getRound().getBrick().remove(index);
	}

	private boolean isIndexPositive(int index) {
		return index >= 0;
	}

	private boolean isIndexNotTheLast(int index) {
		return index < this.level.getRound().getBrick().size();
	}

	// edoardo
	private void deleteRandomBricks() {
		Random brickToRm = new Random();
		Random trash = new Random();
		var i = brickToRm.nextInt(level.getRound().getBrick().size() / 2);
		while (i > 0) {
			level.getRound().getBrick()
					.remove(trash.nextInt(level.getRound().getBrick().size()));
			System.out.println("bricks to delate: " + i);
			i--;
		}
	}

	// edoardo
	private void reduceSizePad() {
		System.out.println();
	}

	// edoardo
	private void enlargeSizePad() {
		System.out.println();
	}

	// virginia
	private void increaseBallSpeed() {
		this.level.getRound().getBall().getSpeed().sum(new SpeedImpl(0.5, 0.5));
	}

	// virginia
	private void decreaseBallSpeed() {
		this.level.getRound().getBall().getSpeed().sum(new SpeedImpl(-0.5, -0.5));
	}

	// virginia
	private void changeObstacles() {
		this.level.getRound().getBrick().replaceAll(x -> {
			if (x.getType().equals(BrickType.OBSTACLE)) {
				Brick brick = new NormalBrick(BrickType.NORMAL,
						new DimensionImpl(x.getBrickH(), x.getBrickW()), x.getPos(), 1);
				return brick;
			} else {
				return x;
			}
		});
		System.out.println();
	}

	// margherita
	private void increaseScore() {
		Timer time = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				level.getScore().enableBonus(true);
			}

		};
		time.schedule(task, 10000);
		this.level.getScore().enableBonus(false);

	}

	// margherita
	private void addBalls() {
		// List<Ball> extraBalls = new ArrayList<>();
		// for (int i = 0; i < NUM_BALLS; i++) {
		// extraBalls.add(new Ball());
		// extraBalls.get(i).setPos(this.level.getRound().getBallInitialPosition());

		// }
		// this.level.getRound().addBalls(extraBalls);

	}

	// chiara
	private void addHardRow() {
		double lastY = this.level.getRound().getBrick()
				.get(this.level.getRound().getBrick().size() - 1).getPos().getY();
		double brickH = this.level.getRound().getBrick()
				.get(this.level.getRound().getBrick().size() - 1).getBrickH();
		double brickW = this.level.getRound().getBrick()
				.get(this.level.getRound().getBrick().size() - 1).getBrickW();
		double start = (brickW / 2) - 5;
		double stop = (SizeCalculation.getWorldSize().getY()) - (3 * (brickW / 2));
		for (double x = start; x <= stop; x = x + brickW) {
			NormalBrick brick = new NormalBrick(BrickType.NORMAL,
					new DimensionImpl(brickH, brickW), new Pair<>(x, lastY + brickH), 2);
			this.level.getRound().getBrick().add(brick);
		}
		System.out.println();
	}

	// chiara
	private void changeHard() {
		List<Brick> hard = new ArrayList<>();
		Timer timer = new Timer();
		for (Brick brick : this.level.getRound().getBrick()) {
			if (brick.getRes().isPresent() && brick.getRes().get() == 2) {

				hard.add(brick);
				brick.decreaseRes(brick.getRes().get());
			}
		}
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				for (Brick brick : hard) {
					int indx = level.getRound().getBrick().indexOf(brick);
					if (indx != -1) {
						level.getRound().getBrick().get(indx).increaseRes(brick.getRes().get());
					}
				}
			}

		};
		timer.schedule(task, 10000);
	}

	// simone
	public void chooseSurprise() {
		final int method = random.nextInt(NUM_TOT_SURSPRISE) + 1;
		this.mappa.get(method).run();
		// this.deleteRandomBricks();
	}

	/*
	 * Metodo per testare i vari bonus richiamandoli direttamente, non in modo
	 * random
	 */
	public void bonus() {
		this.decreaseBallSpeed();
	}

}
