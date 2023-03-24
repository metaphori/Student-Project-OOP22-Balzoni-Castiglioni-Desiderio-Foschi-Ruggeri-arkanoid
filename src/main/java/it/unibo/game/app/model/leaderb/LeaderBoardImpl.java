package it.unibo.game.app.model.leaderb;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import it.unibo.game.Pair;

public class LeaderBoardImpl implements java.io.Serializable, LeaderBoard {

    private File file = new File("src/main/Filee.txt");

    public boolean isPresent(String usr){
        return playersFromFile().stream()
                            .anyMatch(x->x.getName().equals(usr));
    }

    public void updatePoints(String name, Integer points, Integer levelId, Integer roundId){
        List<User> players = playersFromFile();
        if(!players.stream().anyMatch(x->x.getName().equals(name))) {
            players.add(new User(name, points, levelId, roundId));
        } else {
            User usr = players.stream().filter(x->x.getName().equals(name)).findFirst().get();
            if(!usr.alreadyDone(levelId, roundId)) {
                players.remove(usr);
                usr.update(points, levelId, roundId);
                players.add(usr);
            }
        }
        players.sort((x,y)->y.getPoints().compareTo(x.getPoints()));
        writeOnFile(players);
    }

    public Integer getPosition(String name){
        List<User> players = playersFromFile();
        User usr = players.stream().filter(x->x.getName().equals(name)).findFirst().get();
        return players.indexOf(usr) + 1;
    }

    public List<Pair<String,Integer>> getBestFive(){
        List<User> players = playersFromFile();
        if(players.size()<5) {
            return players.stream().map(x->new Pair<>(x.getName(),x.getPoints())).collect(Collectors.toList());
        }
        else {
            return playersFromFile().subList(0, 5).stream().map(x->new Pair<>(x.getName(),x.getPoints())).collect(Collectors.toList());
        }
    }

    private List<User> playersFromFile(){
        if(this.file.length()>0) {
            try(ObjectInputStream oos = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file.getPath())))){
                return (List<User>) oos.readObject();
            } catch(Exception ex){};
        }
        return new ArrayList<>();
    }

    private void writeOnFile(List<User> users){
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file.getPath())))){
            oos.writeObject(users);
        } catch(Exception ex){};
    }

    class User implements java.io.Serializable {
        private String name;
        private int points=0;
        private Set<Pair<Integer,Integer>> levelsDone = new HashSet<>();

        public User(final String name, final int points, final int levelId, final int roundId){
            this.name = name;
            this.points=points;
            this.levelsDone.add(new Pair<>(levelId,roundId));
        }

        public String getName(){
            return this.name;
        }
    
        public Integer getPoints(){
            return this.points;
        }

        public boolean alreadyDone(final Integer levelId, final Integer roundId) {
            return this.levelsDone.contains(new Pair<>(levelId,roundId));
        }
    
        public Set<Pair<Integer,Integer>> getLevels(){
            return Collections.unmodifiableSet(this.levelsDone);
        }

        public void update(int num, int levelId, int roundId){
            this.levelsDone.add(new Pair<>(levelId,roundId));
            this.points = this.points+num;
        }
    }
}