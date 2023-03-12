package it.unibo.game.app.controller;

import java.util.LinkedList;

public class GameEngine {
    
    private long period = 20;
    //private LinkedList<WorldEvent> event;

    public GameEngine() {
        //event = new LinkedList<>();
    }

    public void mainLoop() {
        long previousCycleStartTime = System.currentTimeMillis();
        while(true) {
            long currentCycleStartTime = System.currentTimeMillis();
			long elapsed = currentCycleStartTime - previousCycleStartTime;


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
}
