package it.unibo.game.app.model.leaderb;
import it.unibo.game.Pair;
import java.util.*;

public interface LeaderBoard {

    void updatePoints(String name, String passWord, Integer points, Integer levelId);

    List<Pair<String,Integer>> getBestFive();

}