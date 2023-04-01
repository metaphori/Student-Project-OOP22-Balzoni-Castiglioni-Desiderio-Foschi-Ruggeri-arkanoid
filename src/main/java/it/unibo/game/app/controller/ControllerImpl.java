package it.unibo.game.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import java.util.stream.Collectors;
import it.unibo.game.Pair;
import it.unibo.game.app.api.AppController;
import it.unibo.game.app.api.Model;
import it.unibo.game.app.api.MovingObject;
import it.unibo.game.app.model.ModelImpl;
import it.unibo.game.app.model.SizeCalculation;
import it.unibo.game.app.model.ball.Ball;
import it.unibo.game.app.view.jswing.api.UIController;
import it.unibo.game.app.view.jswing.implementation.UIControllerImpl;

public class ControllerImpl implements AppController {

	private UIController uiContr;
	private Model model;
	private GameEngine gameEngine;

	@Override
	public void play() {
		this.gameEngine.resume();
	}

	@Override
	public void onPause() {
		this.gameEngine.pause();
	}

	@Override
	public void quit() {
		System.exit(0);
	}

	@Override
	public void setView() {
		this.uiContr = new UIControllerImpl();
		this.uiContr.set(this);
	}

	@Override
	public void setModel() {
		this.model = new ModelImpl();
		this.model.setController(this);
	}

	@Override
	public void chooseLevel(int numLevel) {
		this.model.chooseLevel(numLevel);
	}

	@Override
	public Pair<Double, Double> getWorldDimension() {
		return SizeCalculation.getWorldSize();
	}

	/*-------------------------------------------------------------------- */
	/* metodi da utili alla gui */
	@Override
	public Map<Pair<Double, Double>, Optional<Integer>> getBrickList() {
		return this.model.getBrickList().entrySet().stream()
				.collect(Collectors.toMap(
						m -> new Pair<>(m.getKey().getX() * this.delta().getX(), m.getKey().getY() * this.delta().getY()),
						m -> m.getValue()));
	}

	@Override
	public Pair<Double, Double> getBrickDimension() {
		/*
		 * nel model le dimensioni sono invertite qundi mi adatto a quello che mi viene
		 * dato
		 */
		return new Pair<Double, Double>(this.model.getBrickDimension().getX() * this.delta().getY(),
				this.model.getBrickDimension().getY() * this.delta().getX());
	}

	@Override
	public List<Pair<Double, Double>> getBall() {
		List<Pair<Double, Double>> list = new ArrayList<>(); 
		this.model.getBall().stream().forEach(x -> {
			list.add(new Pair<Double, Double>(x.getX() * this.delta().getX(), x.getY() * this.delta().getY()));
		});
		return list;
	}

	@Override
	public Pair<Double, Double> getPad() {
		return new Pair<Double, Double>(this.model.getPad().getX() * this.delta().getX(),
				this.model.getPad().getY() * this.delta().getY());
	}

	@Override
	public Double getPadWight() {
		return this.model.getPadWight() * this.delta().getX();
	}

	@Override
	public Double getPadHeight() {
		return this.model.getPadHeight() * this.delta().getY();
	}

	public void updatePoints(String name, String passWord) {
		this.model.updatePoints(name, passWord);
	}

	@Override
	public Double getRBall() {
		var dt = this.delta().getX() < this.delta().getY() ? this.delta().getX() : this.delta().getY();
		return this.model.getRBall() * dt;
	}

	private List<Pair<Double, Double>> getPairList(List<MovingObject> b) {
		return b.stream()
				.map(ball -> new Pair<>(ball.getPos().getX() * this.delta().getX(), ball.getPos().getY() * delta().getX()))
				.collect(Collectors.toList());
	}

	public List<Pair<Double, Double>> getSurprise() {
		return getPairList(this.model.getSurprise());
	}

	private Pair<Double, Double> delta() {
		return new Pair<Double, Double>(uiContr.windowDim().getX() / this.getWorldDimension().getY(),
				uiContr.windowDim().getY() / this.getWorldDimension().getX());
	}

	/*-------------------------------------------- */
	@Override
	public void rPaint() {
		this.uiContr.rPaint();
	}

	@Override
	public void nextRound() {
		this.model.nextRound();
	}

	@Override
	public void changePadPos(Pair<Double, Double> pos) {
		this.model.setPadPos(pos);
	}

	@Override
	public Double getRow(Double x) {
		return this.model.getRow(x) * this.delta().getY();
	}

	@Override
	public void setGameEngine() {
		this.gameEngine = new GameEngine(this);
	}

	public void update(long dt) {
		this.model.update(dt);
	}

	public List<Pair<String, Integer>> getBestFive() {
		return this.model.getBestFive();
	}

	public int getScore() {
		return this.model.getScore();
	}

	@Override
	public void setGameOver() {
		this.uiContr.gameOver();
	}

	@Override
	public boolean updateLife() {
		return this.model.updateLife();
	}

	@Override
	public void restoreBall() {
		this.model.restoreInitialPosition();
	}

	/* movimento pad */
	private void movePad(Pair<Double, Double> p) {
		this.model.setPadPos(p);
	}

	@Override
	public void mvPadR() {
		movePad(new Pair<Double, Double>(this.model.getPad().getX() + 1 * 10, this.model.getPad().getY()));
	}

	@Override
	public void mvPadL() {
		movePad(new Pair<Double, Double>(this.model.getPad().getX() - 1 * 10, this.model.getPad().getY()));
	}

	@Override
	public boolean checkRound() {
		return this.model.checkRound();
	}

	@Override
	public void setVictory() {
		this.uiContr.victory();
	}

	@Override
	public int getLife() {
		return this.model.getLife();
	}

}
