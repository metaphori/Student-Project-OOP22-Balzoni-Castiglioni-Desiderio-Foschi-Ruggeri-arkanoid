package it.unibo.game.app.model;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import it.unibo.game.Pair;
import it.unibo.game.app.api.AppController;
import it.unibo.game.app.api.Level;
import it.unibo.game.app.model.ball.Ball;
import it.unibo.game.app.model.dynamic.Move;
import it.unibo.game.app.model.leaderb.LeaderBoard;
import it.unibo.game.app.model.leaderb.LeaderBoardImpl;
import it.unibo.game.app.model.levels.*;
import it.unibo.game.app.model.round.GameOver;
import it.unibo.game.app.api.Model;
import it.unibo.game.app.api.MovingObject;

public class ModelImpl implements Model {

	private AppController control;
	private Level level;
	private Move move;
	private LeaderBoard board = new LeaderBoardImpl();
	private GameOver gameOver;

	@Override
	public void setController(AppController c) {
		this.control = c;
		// this.level = new FirstLevel(this.control.getWorldDimension()); In teora va lo
		// stesso
	}

	@Override
	public Map<Pair<Double, Double>, Optional<Integer>> getBrickList() {
		return this.level.getRound().getBrick().stream().collect(Collectors.toMap(b -> b.getPos(), b -> b.getRes()));
	}

	@Override
	public void chooseLevel(int numLevel) {
		switch (numLevel) {
		case 1:
			this.level = new FirstLevel();
			break;
		case 2:
			this.level = new SecondLevel();
			break;
		case 3:
			this.level = new ThirdLevel();
			break;
		}
		this.move = new Move(level);
		this.gameOver = new GameOver(level.getRound());
	}

	@Override
	public Pair<Double, Double> getBrickDimension() {
		return this.level.getRound().getSizeCalc().getBrickDim();
	}

	@Override
	public List<Pair<Double, Double>> getBall() {
		return this.level.getRound().getPosBall();
	}

	@Override
	public Pair<Double, Double> getPad() {
		return this.level.getRound().getPad().getPos();
	}

	@Override
	public void setPadPos(Pair<Double, Double> pos) {
		this.level.getRound().setPosPad(pos);
	}

	@Override
	public Double getPadWight() {
		return this.level.getRound().getPad().getDimension().getWidth();
	}

	public int getScore() {
		return this.move.getScore();
	}

	@Override
	public Double getPadHeight() {
		return this.level.getRound().getPad().getDimension().getHeight();
	}

	@Override
  public Double getRBall() {
    return this.level.getRound().getBalls().get(0).getDimension().getHeight();
  }
	@Override
	public Double getRow(Double x) {
		return this.level.getRound().getSizeCalc().getRowCordinate(x);
	}

	public void updatePoints(String name, String passWord) {
		this.board.updatePoints(name, passWord, this.getScore(), this.level.getId());
	}

	@Override
	public void nextRound() {
		if (this.level.getNumRoundPassed() <= 2) {
			if (this.level.getNumRoundPassed() == 1) {
				this.level.setSecondRound();
				this.move = new Move(level);
				this.gameOver = new GameOver(level.getRound());
			} else if (this.level.getNumRoundPassed() == 2) {
				this.level.setThirdRound();
				this.move = new Move(level);
				this.gameOver = new GameOver(level.getRound());
			}
		} else {
			this.control.setVictory();
		}
	}

	@Override
	public Pair<Double, Double> getWorldDim() {
		return SizeCalculation.getWorldSize();
	}

	public void update(long dt) {
		move.update(dt);
	}

	public List<Pair<String, Integer>> getBestFive() {
		return board.getBestFive();
	}

	public boolean checkRound() {
		if (gameOver.isRoundFinished()) {
			this.level.increaseRound();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateLife() {
		if (this.gameOver.hasMissedBall()) {
			this.level.decreaseLife();
			if (!this.level.isAlive()) {
				this.control.setGameOver();
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public void restoreInitialPosition() {
		this.level.getRound().restart();
	}

	public List<MovingObject> getSurprise() {
		return this.level.getRound().getSurprise();
	}

	@Override
	public int getLife() {
		return this.level.getLife();
	}
}