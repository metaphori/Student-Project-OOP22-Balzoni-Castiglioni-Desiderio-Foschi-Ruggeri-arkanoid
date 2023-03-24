package it.unibo.game.app.controller;


import java.util.concurrent.TimeUnit;

import javax.swing.SwingWorker;

import it.unibo.game.app.api.AppController;

public class GameEngine {
    
    private long period = 30;
    private AppController controller;
    private boolean thread = false;

    public GameEngine(AppController contr) {
        this.controller = contr;
    }
    
    public void processInBackGround() {
        SwingWorker<Void, Void> worker = new SwingWorker<Void,Void>() {

			@Override
			protected Void doInBackground() throws Exception {
                long previousCycleStartTime = System.currentTimeMillis();
                while(thread) {
                    long currentCycleStartTime = System.currentTimeMillis();
                    long elapsed = currentCycleStartTime - previousCycleStartTime;
                    update(elapsed);
                    if (checkRound()) {
                        pause();
                        controller.nextRound();
                        render();
                        TimeUnit.SECONDS.sleep(3);
                        restart();
                    }
                    
                    if (updateLife()) {
                        pause();
                        controller.restoreBall();
                        render();
                        TimeUnit.SECONDS.sleep(1);
                        restart();
                    }
                    render();
                    waitForNextFrame(currentCycleStartTime);
                    previousCycleStartTime = currentCycleStartTime;
                }
				return null;
			}
            
        };
        worker.execute();
    }


    protected void waitForNextFrame(long cycleStartTime){
		long dt = System.currentTimeMillis() - cycleStartTime;
		if (dt < period){
			try {
				Thread.sleep(period - dt);
			} catch (Exception ex){}
		}
	}

    protected void restart() {
        this.thread = true;
    }

    protected void render() {
        this.controller.rPaint();
    }

    protected void update(long dt) {
        this.controller.update(dt);
    }

    public void pause() {
        this.thread = false;
    }
    public void resume() {
        this.thread = true;
        this.processInBackGround();
    }

    protected boolean checkRound() {
        return this.controller.checkRound();
    }

    protected boolean updateLife() {
       return this.controller.updateLife();
    }


    
}
