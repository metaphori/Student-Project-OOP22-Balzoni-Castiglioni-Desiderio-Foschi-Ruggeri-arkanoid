package it.unibo.game.app.model.leaderb;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import it.unibo.game.Pair;

/**
 * class that save and load information of teh leaderboard in a file.
 */
public class LeaderBoardImpl implements java.io.Serializable, LeaderBoard {

	private File file = new File("src/main/Filee.txt");
	private static final int MAX = 5;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updatePoints(final String name, final String passWord, final Integer points, final Integer levelId) {
		List<User> players = playersFromFile();
		Optional<User> user = isPresent(name, passWord, players);
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
	private Optional<User> isPresent(final String usr, final String passWord, final List<User> users) {
		return users.stream().filter(x -> x.getName().equals(usr) && x.getPassWord().equals(passWord)).findFirst();
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
		return players.stream().map(x -> new Pair<>(x.getName(), x.getPoints())).collect(Collectors.toList());
	}

	private List<User> playersFromFile() {
		if (this.file.length() > 0) {
			try (
					ObjectInputStream oos = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file.getPath())))) {
				return (List<User>) oos.readObject();
			} catch (Exception ex) {
			}
		}
		return new ArrayList<>();
	}

	private void writeOnFile(final List<User> users) {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(file.getPath())))) {
			oos.writeObject(users);
		} catch (Exception ex) {
		}
	}

	class User implements java.io.Serializable {
		private String name;
		private String password;
		private Map<Integer, Integer> points = new HashMap<>();

		User(final String name, final String password, final int points, final int levelId) {
			this.name = name;
			this.password = password;
			this.update(points, levelId);
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
