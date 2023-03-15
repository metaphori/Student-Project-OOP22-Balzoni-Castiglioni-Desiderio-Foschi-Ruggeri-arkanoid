package it.unibo.game.app.model;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import it.unibo.game.Pair;

public class LeaderBoardImpl implements java.io.Serializable, LeaderBoard {

    private String fileName;
    private Set<String> usersRegistered = new HashSet<>();

    public LeaderBoardImpl(final String fileName){
        this.fileName=fileName;
    }

    public boolean isPresent(String usr){
        return usersRegistered.contains(usr);
    }

    public void updatePoints(String name, Integer points, Integer levelId, Integer roundId){
        List<User> players = playersFromFile();
        if(!usersRegistered.contains(name)) {
            User usr = new User(name);
            usr.addRound(levelId, roundId);
            usr.setPoints(points);
            players.add(usr);
        } else {
            User usr = players.stream().filter(x->x.getName().equals(name)).findFirst().get();
            if(!usr.alreadyDone(levelId, roundId)) {
                players.remove(usr);
                usr.addRound(levelId, roundId);
                usr.setPoints(points);
                players.add(usr);
            }
        }
        usersRegistered.add(name);
        players.sort((x,y)->y.getPoints().compareTo(x.getPoints()));
        writeOnFile(players);
    }

    public Integer getPosition(String name){
        List<User> players = playersFromFile();
        User usr = players.stream().filter(x->x.getName().equals(name)).findFirst().get();
        return players.indexOf(usr) + 1;
    }

    public List<Pair<String,Integer>> getBestFive(){
        return playersFromFile().subList(0, 5).stream().map(x->new Pair<>(x.getName(),x.getPoints())).collect(Collectors.toList());
    }

    private List<User> playersFromFile(){
        if(usersRegistered.isEmpty()) return new ArrayList<>();
        else {
            try(ObjectInputStream oos = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))){
                return (List<User>) oos.readObject();
            } catch(Exception ex){};
            return new ArrayList<>();
        }
    }

    private void writeOnFile(List<User> users){
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))){
            oos.writeObject(users);
        } catch(Exception ex){};
    }

    class User implements java.io.Serializable {
        private String name;
        private int points=0;
        private Set<Pair<Integer,Integer>> levelsDone = new HashSet<>();

        public User(final String name){
            this.name = name;
        }

        public String getName(){
            return this.name;
        }
    
        public Integer getPoints(){
            return this.points;
        }
    
        public void addRound(final Integer levelId, final Integer roundId){
            this.levelsDone.add(new Pair<>(levelId,roundId));
        }

        public boolean alreadyDone(final Integer levelId, final Integer roundId) {
            return this.levelsDone.contains(new Pair<>(levelId,roundId));
        }
    
        public Set<Pair<Integer,Integer>> getLevels(){
            return Collections.unmodifiableSet(this.levelsDone);
        }
    
        public void setPoints(int num){
            this.points = this.points+num;
        }
    }
}