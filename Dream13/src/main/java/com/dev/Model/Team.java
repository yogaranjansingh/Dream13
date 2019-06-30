package	com.dev.Model;

import java.util.List;

public class Team {
	
	private int id;
	private String name;
	private int captainId;
	private int viceCaptainId;
	private int userId;
	private int matchId;
	private List<Player> players;
	private int score;
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCaptainId() {
		return captainId;
	}
	public void setCaptainId(int captainId) {
		this.captainId = captainId;
	}
	public int getViceCaptainId() {
		return viceCaptainId;
	}
	public void setViceCaptainId(int viceCaptainId) {
		this.viceCaptainId = viceCaptainId;
	}
	
	
}
