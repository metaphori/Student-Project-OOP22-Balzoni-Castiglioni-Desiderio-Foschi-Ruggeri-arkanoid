package it.unibo.game.app.model.leaderb;
import it.unibo.game.Pair;
import java.util.*;

public interface LeaderBoard {

    boolean isPresent(String usr);

    void updatePoints(String name, Integer points, Integer levelId, Integer roundId);

    Integer getPosition(String name);

    List<Pair<String,Integer>> getBestFive();

}