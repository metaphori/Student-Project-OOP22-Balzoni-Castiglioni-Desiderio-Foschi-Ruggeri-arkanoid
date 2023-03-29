package it.unibo.game.app.api;

public interface Speed {

    double getX();

    double getY();

    Speed sum(Speed v);

    Speed mul(double num);

}