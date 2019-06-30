package com.dev.Model;

import java.util.List;

public class User {
	
	private int id;
	private String name;
	private int age;
	private String username;
	private String password;
	private List<Match> matchesPlayed;
	private Match currentMatch;
	private int currentScore;
	private int walletBalance;
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Match> getMatchesPlayed() {
		return matchesPlayed;
	}
	public void setMatchesPlayed(List<Match> matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}
	public Match getCurrentMatch() {
		return currentMatch;
	}
	public void setCurrentMatch(Match currentMatch) {
		this.currentMatch = currentMatch;
	}
	public int getCurrentScore() {
		return currentScore;
	}
	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}
	public int getWalletBalance() {
		return walletBalance;
	}
	public void setWalletBalance(int walletBalance) {
		this.walletBalance = walletBalance;
	}
	
}
