package com.dev.Model;

public class TeamSaveRequest {

	
	private Team team;
	private User user;
	private Game game;
	
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public TeamSaveRequest(Team team, User user, Game game) {
		super();
		this.team = team;
		this.user = user;
		this.game = game;
	}
	public TeamSaveRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
