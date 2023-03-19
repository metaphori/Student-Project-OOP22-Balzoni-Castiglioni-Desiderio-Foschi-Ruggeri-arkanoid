package it.unibo.game.app.controller;

import java.util.LinkedList;

import it.unibo.game.app.api.AppController;

public class GameEngine {
    
    private long period = 20;
    //private LinkedList<WorldEvent> event;
    private AppController controller;
    private boolean thread = false;

    public GameEngine(AppController contr) {
        //event = new LinkedList<>();
        this.controller = contr;
    }

    public void mainLoop() {
        long previousCycleStartTime = System.currentTimeMillis();
        while(this.thread) {
            long currentCycleStartTime = System.currentTimeMillis();
			long elapsed = currentCycleStartTime - previousCycleStartTime;

            this.render();
            this.waitForNextFrame(currentCycleStartTime);
            previousCycleStartTime = currentCycleStartTime;
        }
    }

    protected void waitForNextFrame(long cycleStartTime){
		long dt = System.currentTimeMillis() - cycleStartTime;
		if (dt < period){
			try {
				Thread.sleep(period - dt);
			} catch (Exception ex){}
		}
	}

    protected void render() {
        this.controller.rPaint();
    }

    public void pause() {
        this.thread = false;
    }
    public void resume() {
        this.thread = true;
    }
    
}
