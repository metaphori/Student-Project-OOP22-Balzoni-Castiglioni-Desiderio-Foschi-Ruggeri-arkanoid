package it.unibo.game.app.model.leaderb;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import it.unibo.game.Pair;

public class LeaderBoardImpl implements java.io.Serializable, LeaderBoard {

    private File file = new File("src/main/Filee.txt");

    public void updatePoints(String name, String passWord, Integer points, Integer levelId){
        List<User> players = playersFromFile();
        if(this.isPresent(name,passWord,players)) {
            players.stream()
                    .filter(x->x.getName().equals(name) && x.getPassWord().equals(passWord))
                    .forEach(x->x.update(points,levelId));
        } else {
            User usr = new User(name, passWord, points, levelId);
            players.add(usr);
        }
        players.sort((x,y)->y.getPoints().compareTo(x.getPoints()));
        writeOnFile(players);
    }

    
    private boolean isPresent(String usr, String passWord,List<User> users){
        return users.stream()
                    .anyMatch(x->x.getName().equals(usr) && x.getPassWord().equals(passWord));
    }

    public List<Pair<String,Integer>> getBestFive(){
        List<User> players = playersFromFile();
        if(players.size()>5) {
            players=players.subList(0, 5);
        }
        return players.stream().map(x->new Pair<>(x.getName(),x.getPoints())).collect(Collectors.toList());
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
        private String password;
        enum Level{
            FIRST,
            SECOND,
            THIRD;
        }
        private Map<Level,Integer> points = new HashMap<>(Map.of(Level.FIRST,0,
                                                                    Level.SECOND,0,
                                                                    Level.THIRD,0));

        public User(final String name, final String password, final int points, final int levelId){
            this.name = name;
            this.password=password;
            this.update(points, levelId);
        }

        private Level getLev(int id){
            if(id==1) return Level.FIRST;
            else if(id==2) return Level.SECOND;
            else return Level.THIRD;
        }

        public String getName(){
            return this.name;
        }

        public String getPassWord(){
            return this.password;
        }
    
        public Integer getPoints(){
            return this.points.entrySet().stream().mapToInt(x->x.getValue()).sum();
        }

        public void update(int points, int levelId){
            this.points.merge(getLev(levelId), points, (x,y)->y);
        }
    }
}