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
import it.unibo.game.app.model.brick.NormalBrick;

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

    private Map<Integer,Void> mappa;
    private Random random = new Random();
    private Level level;

    public Surprise(Level level) {
        this.level = level;
        
       /* mappa = new HashMap<>(Map.ofEntries(
            Map.entry(EXTRA_LIFE, this.extraLife()),
            Map.entry(EXPLOSIVE_BOMB, this.explosiveBomb()),
            Map.entry(DELETE_RANDOM_BRICKS, this.deleteRandomBricks()),
            Map.entry(REDUCE_SIZE_PAD, this.reduceSizePad()),
            Map.entry(ENLARGE_SIZE_PAD, this.enlargeSizePad()),
            Map.entry(INCREASE_BALL_SPEED, this.increaseBallSpeed()),
            Map.entry(DECREASE_BALL_SPEED, this.decreaseBallSpeed()),
            Map.entry(CHANGE_OBSTACLES, this.changeObstacles()),
            Map.entry(INCREASE_SCORE, this.increaseScore()),
            Map.entry(ADD_BALLS, this.addBalls()),
            Map.entry(CHANGE_ROW, this.changeRow()),
            Map.entry(CHANGE_HARD, this.changeHard())
            )
        );*/
    }

    //simone
    private Void extraLife() {
        this.level.increaseLife();
        return null;        
    }

    //simone
    private Void explosiveBomb() {
        return null;
    }

    //edoardo
    private Void deleteRandomBricks() {
        return null;
    }

    //edoardo
    private Void reduceSizePad() {
        return null;
    }

    //edoardo
    private Void enlargeSizePad() {
        return null;
    }

    //virginia
    private Void increaseBallSpeed() {
        return null;
    }

    //virginia
    private Void decreaseBallSpeed() {
        return null;
    }

    //virginia
    private Void changeObstacles() {
        this.level.getRound().getBrick().replaceAll(x->{
            if(x.getType().equals(BrickType.OBSTACLE)) {
                Brick brick = new NormalBrick(BrickType.NORMAL, x.getBrickW(), x.getBrickH(), 1);
                return brick;
            }
            else {
                return x;
            }
        });
        return null;
    }

    //margherita
    private Void increaseScore() {
        Timer time = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
              this.level.getScore.enableBonus(true);
            }
            
        }; 
        time.schedule(task,10000);
        this.level.getScore().enableBonus(false);

        return null;
    }

    //margherita
    private Void addBalls() {
        return null;
    }

    //chiara
    private Void changeRow() {
        double lastY = this.level.getRound().getBrick().get(this.level.getRound().getBrick().size() - 1).getPos().getY();
        double brickH = this.level.getRound().getBrick().get(this.level.getRound().getBrick().size() - 1).getBrickH();
        double brickW = this.level.getRound().getBrick().get(this.level.getRound().getBrick().size() - 1).getBrickW();
        double start = (brickW / 2) - 5;
        double stop = (SizeCalculation.getWorldSize().getY()) -(3 * (brickW / 2));
        for (double x = start; x <= stop; x = x + brickW) {
            NormalBrick brick = new NormalBrick(BrickType.NORMAL, brickW, brickH,2);
                brick.setPos(new Pair<>(x, lastY + brickH));
                this.level.getRound().getBrick().add(brick);
        }
        return null;
    }
    //chiara
    private Void changeHard() {
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
                    if(indx != -1) {
                       level.getRound().getBrick().get(indx).increaseRes(brick.getRes().get()); 
                    }
                }
            }
            
        };
        timer.schedule(task, 10000);

        return null;
    }

    //simone
    public void chooseSurprise() {
        final int method = random.nextInt(NUM_TOT_SURSPRISE) + 1;
        this.mappa.get(method);
    }
    
    /*Metodo per testare i vari bonus richiamandoli direttamente, non in modo random*/
    public void bonus() {
        this.changeHard();
    }
    
}
