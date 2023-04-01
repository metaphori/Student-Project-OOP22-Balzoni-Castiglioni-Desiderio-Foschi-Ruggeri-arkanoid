package it.unibo.game.app.model.leaderb;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.io.Serializable;

import it.unibo.game.Pair;

/**
 * class that save and load information of the leaderboard in a file.
 */
public class LeaderBoardImpl implements Serializable, LeaderBoard {

  private final File file = new File("src/main/Filee.txt");
  private static final int MAX = 5;

  /**
   * {@inheritDoc}
   */
  @Override
  public void updatePoints(final String name, final String passWord, final Integer points,
      final Integer levelId) {
    final List<User> players = playersFromFile();
    final Optional<User> user = checkUser(name, passWord, players);
    if (user.isPresent()) {
      user.get().update(points, levelId);
    } else {
      User usr = new User(name, passWord, points, levelId);
      players.add(usr);
    }
    players.sort((x, y) -> y.getPoints().compareTo(x.getPoints()));
    writeOnFile(players);
  }

  /**
   * 
   * @param usr      name of usr
   * @param passWord of usr
   * @param users    list that contains all players
   * @return an optional that contains the User if is present
   */
  private Optional<User> checkUser(final String usr, final String passWord,
      final List<User> users) {
    return users.stream()
        .filter(x -> x.getName().equals(usr) && x.getPassWord().equals(passWord))
        .findFirst();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Optional<Integer> getPoints(final String usr, final String pass) {
    return playersFromFile().stream()
        .filter(x -> x.getName().equals(usr) && x.getPassWord().equals(pass))
        .map(x -> x.getPoints()).findFirst();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Pair<String, Integer>> getBestFive() {
    List<User> players = playersFromFile();
    if (players.size() > MAX) {
      players = players.subList(0, MAX);
    }
    return players.stream().map(x -> new Pair<>(x.getName(), x.getPoints()))
        .collect(Collectors.toList());
  }

  /**
   * method to get the list of all players froma a file.
   * 
   * @return the list of players
   * @throws IOException
   * @throws FileNotFoundException
   * @throws ClassNotFoundException
   */
  private List<User> playersFromFile() {
    if (this.file.length() > 0) {
      try (ObjectInputStream oos = new ObjectInputStream(
          new BufferedInputStream(new FileInputStream(file.getPath())))) {
        return (List<User>) oos.readObject();
      } catch (FileNotFoundException ex) {
        ex.toString();
      } catch (IOException ex) {
        ex.toString();
      } catch (ClassNotFoundException ex) {
        ex.toString();
      }
    }
    return new ArrayList<>();
  }

  /**
   * method to write the list of players in the file.
   * 
   * @param users the list of players
   */
  private void writeOnFile(final List<User> users) {
    try (ObjectOutputStream oos = new ObjectOutputStream(
        new BufferedOutputStream(new FileOutputStream(file.getPath())))) {
      oos.writeObject(users);
    } catch (FileNotFoundException ex) {
      ex.toString();
    } catch (IOException ex) {
      ex.toString();
    }
  }

  static class User implements java.io.Serializable {
    private final String name;
    private final String password;
    private final Map<Integer, Integer> points = new HashMap<>();

    User(final String name, final String password, final int points, final int levelId) {
      this.name = name;
      this.password = password;
      this.points.put(levelId, points);
    }

    public String getName() {
      return this.name;
    }

    public String getPassWord() {
      return this.password;
    }

    public Integer getPoints() {
      return this.points.entrySet().stream().mapToInt(x -> x.getValue()).sum();
    }

    public void update(final int points, final int levelId) {
      this.points.merge(levelId, points, (x, y) -> y);
    }
  }
}
