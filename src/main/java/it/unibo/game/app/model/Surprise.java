package it.unibo.game.app.model;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.game.Pair;
import it.unibo.game.app.api.Brick;
import it.unibo.game.app.api.BrickType;
import it.unibo.game.app.api.Level;
import it.unibo.game.app.api.MovingObject;
import it.unibo.game.app.model.ball.Ball;
import it.unibo.game.app.model.brick.NormalBrick;
import it.unibo.game.app.model.dynamic.SpeedImpl;

/**
 * class that contains methods for bonuses or maluses.
 */
public class Surprise {

  private static final int NUM_TOT_SURSPRISE = 12;
  private static final int EXTRA_LIFE = 1;
  private static final int EXPLOSIVE_BOMB = 2;
  private static final int DELETE_RANDOM_BRICKS = 3;
  private static final int REDUCE_SIZE_PAD = 4;
  private static final int ENLARGE_SIZE_PAD = 5;
  private static final int INCREASE_BALL_SPEED = 6;
  private static final int DECREASE_BALL_SPEED = 7;
  private static final int CHANGE_OBSTACLES = 8;
  private static final int INCREASE_SCORE = 9;
  private static final int ADD_BALLS = 10;
  private static final int CHANGE_ROW = 11;
  private static final int CHANGE_HARD = 12;
  private static final int NUM_BALLS = 1;
  private static final int PERCENTUAL = 50;
  private static final int BONUS_DURATION = 10000;
  private static final int FIX_START_Y = 5;

  private Map<Integer, Runnable> map = new HashMap<>();
  private Random random = new Random();
  private Level level;
  private boolean padModified = false;

  /**
   * costructor of this class.
   * 
   * @param level current level
   */
  @SuppressFBWarnings("EI_EXPOSE_REP2")
  public Surprise(final Level level) {
    this.level = level;
  }

  /**
   * method that adds a life. Simone Ruggeri
   */
  private void extraLife() {
    System.out.println("extraLife");
    this.level.increaseLife();

  }

  /**
   * explosive bomb method that eliminates the two blocks next to it. Simone
   * Ruggeri
   */
  private void explosiveBomb() {
    System.out.println("explosiveBomb");
    Brick lastBrick = this.level.getLastSurpriseBrick();
    int index = this.level.getIndexLastSurprise();

    if (this.isIndexPositive(index - 1) && this.isThereLeftBrick(index - 1, lastBrick)
        && !this.isObstacle(index - 1) && !this.isSursprise(index - 1)) {
      this.deleteBrick(index - 1);
      if (this.isIndexNotTheLast(index - 1)
          && this.isThereRightBrick(index - 1, lastBrick) && !this.isObstacle(index - 1)
          && !this.isSursprise(index - 1)) {
        this.deleteBrick(index - 1);
      }
    }
    if (this.isIndexPositive(index - 1) && this.isIndexNotTheLast(index)
        && this.isThereRightBrick(index, lastBrick) && !this.isObstacle(index - 1)
        && !this.isSursprise(index - 1)) {
      this.deleteBrick(index);
    }

  }

  /**
   * method that checks if there is a brick to the left of the bomb.
   * 
   * @param index
   * @param lastBrick
   * @return
   */
  private boolean isThereLeftBrick(int index, Brick lastBrick) {
    return (this.level.getRound().getBrick().get(index).getPos().getY() == lastBrick
        .getPos().getY()
        && (lastBrick.getPos().getX() - lastBrick.getBrickW())
            - this.level.getRound().getBrick().get(index).getPos().getX() < 0.1);
  }

  /**
   * method that checks if there is a brick to the right of the bomb.
   * 
   * @param index
   * @param lastBrick
   * @return
   */
  private boolean isThereRightBrick(int index, Brick lastBrick) {
    return (this.level.getRound().getBrick().get(index).getPos().getY() == lastBrick
        .getPos().getY()
        && (this.level.getRound().getBrick().get(index).getPos().getX()
            - lastBrick.getBrickW()) - lastBrick.getPos().getX() < 0.1);
  }

  /**
   * method that checks if the brick is an obstacle.
   * 
   * @param index
   * @return true if it is an obstacle.
   */
  private boolean isObstacle(int index) {
    return this.level.getRound().getBrick().get(index).getType()
        .equals(BrickType.OBSTACLE);
  }

  /**
   * method that checks if the brick is a Surprise.
   * 
   * @param index
   * @return true if it is a surprise.
   */
  private boolean isSursprise(int index) {
    return this.level.getRound().getBrick().get(index).getType()
        .equals(BrickType.SURPRISE);
  }

  /**
   * method that removes a brick.
   * 
   * @param index
   */
  private void deleteBrick(int index) {
    this.level.getRound().getBrick().remove(index);
  }

  /**
   * method that checks if the index is positive.
   * 
   * @param index
   * @return true if index is greater equals than zero
   */
  private boolean isIndexPositive(int index) {
    return index >= 0;
  }

  /**
   * method that checks if the index is less than the size of the list.
   * 
   * @param index
   * @return true if index minor than the size of the list
   */
  private boolean isIndexNotTheLast(int index) {
    return index < this.level.getRound().getBrick().size();
  }

  /**
   * method that randomly deletes bricks. Edoardo Desiderio
   */
  private void deleteRandomBricks() {
    System.out.println("deleteRandomBricks");
    var i = random.nextInt(1, level.getRound().getBrick().size() / 2) + 1;
    while (i > 0) {
      level.getRound().remove(random.nextInt(level.getRound().getBrick().size()));
      // System.out.println("bricks to delate: " + i);
      i--;
    }

  }

  /**
   * method that reduces the size of the pad for a certain time. Edoardo Desiderio
   */
  private void reduceSizePad() {
    System.out.println("reduceSizePad");
    if (!padModified) {
      padModified = true;
      var pad = level.getRound().getPad();
      pad.getDimension().setWidth((pad.getDimension().getWidth() * this.delta()));

      Timer tm = new Timer();
      TimerTask tmTask = new TimerTask() {

        @Override
        public void run() {
          pad.setDimension(SizeCalculation.getPadDim());
          padModified = false;
        }
      };
      tm.schedule(tmTask, BONUS_DURATION);
    }

  }

  private double delta() {
    return (100d - PERCENTUAL) / 100d;
  }

  /**
   * 
   * method that enlarge the size of the pad for a certain time. Edoardo Desiderio
   */
  private void enlargeSizePad() {
    System.out.println("enlargeSizePad");
    if (!padModified) {
      padModified = true;
      var pad = level.getRound().getPad();
      pad.getDimension().setWidth(pad.getDimension().getWidth() * (this.delta() + 1));
      var rightBorder = pad.getPos().getX() + pad.getDimension().getWidth();
      if (rightBorder > SizeCalculation.getWorldSize().getY()) {
        pad.setPos(new Pair<Double, Double>(
            pad.getPos().getX() - (rightBorder - SizeCalculation.getWorldSize().getY()),
            pad.getPos().getY()));
      }

      Timer tm = new Timer();
      TimerTask tmTask = new TimerTask() {

        @Override
        public void run() {
          padModified = false;
          pad.setDimension(SizeCalculation.getPadDim());
        }
      };
      tm.schedule(tmTask, BONUS_DURATION);
    }
  }

  /**
   * method that increases the speed of the ball. Virginia Foschi
   */
  private void increaseBallSpeed() {
    System.out.println("increaseBallSpeed");
    this.level.getRound().getBalls()
        .forEach(x -> x.getSpeed().sum(new SpeedImpl(0.5, 0.2)));

  }

  /**
   * method that decrease the speed of the ball. Virginia Foschi
   */
  private void decreaseBallSpeed() {
    System.out.println("decreaseBallSpeed");
    this.level.getRound().getBalls()
        .forEach(x -> x.getSpeed().sum(new SpeedImpl(-0.5, -0.2)));

  }

  /**
   * method that replaces obstacles with normal bricks. Virginia Foschi
   */
  private void changeObstacles() {
    System.out.println("changeObstacles");
    this.level.getRound().getBrick().replaceAll(x -> {
      if (x.getType().equals(BrickType.OBSTACLE)) {
        Brick brick = new NormalBrick(BrickType.NORMAL,
            new DimensionImpl(x.getBrickH(), x.getBrickW()), x.getPos(), 1);
        return brick;
      } else {
        return x;
      }
    });
  }

  /**
   * method that increases the score for each individual brick for a certain time.
   * Margherita Balzoni
   */
  private void increaseScore() {
    System.out.println("increaseScore");
    Timer time = new Timer();
    TimerTask task = new TimerTask() {

      @Override
      public void run() {
        level.getScore().enableBonus(true);
      }

    };
    time.schedule(task, BONUS_DURATION);
    this.level.getScore().enableBonus(false);
  }

  /**
   * method that increases the number of balls in play. Margherita Balzoni
   */
  private void addBalls() {
    System.out.println("addBalls");
    for (int i = 0; i < NUM_BALLS; i++) {
      MovingObject ball = new Ball(this.level.getRound().getSizeCalc().getBallDim());
      this.level.getRound().getExtraBalls().add(ball);
    }
  }

  /**
   * method that adds a row of hard bricks. Chiara Castiglioni
   */
  private void addHardRow() {
    System.out.println("addHardRow");
    double lastY = this.level.getRound().getBrick()
        .get(this.level.getRound().getBrick().size() - 1).getPos().getY();
    double brickH = this.level.getRound().getBrick()
        .get(this.level.getRound().getBrick().size() - 1).getBrickH();
    double brickW = this.level.getRound().getBrick()
        .get(this.level.getRound().getBrick().size() - 1).getBrickW();
    double start = (brickW / 2) - FIX_START_Y;
    double stop = (SizeCalculation.getWorldSize().getY()) - (3 * (brickW / 2));
    for (double x = start; x <= stop; x = x + brickW) {
      NormalBrick brick = new NormalBrick(BrickType.NORMAL,
          new DimensionImpl(brickH, brickW), new Pair<>(x, lastY + brickH), 2);
      this.level.getRound().getBrick().add(brick);
    }
  }

  /**
   * method that replaces hard bricks with normal ones for a certain time. Chiara
   * Castiglioni
   */
  private void changeHard() {
    System.out.println("changeHard");
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
    timer.schedule(task, BONUS_DURATION);
  }

  /**
   * method that sets up the map by numbering the methods.
   */
  public void setMap() {
    this.map = new HashMap<>(Map.ofEntries(Map.entry(EXTRA_LIFE, () -> this.extraLife()),
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

  /**
   * method that randomly chooses which bonus or malus to invoke.
   */
  public void chooseSurprise() {
    final int method = random.nextInt(NUM_TOT_SURSPRISE) + 1;
    this.map.get(method).run();
  }
}
