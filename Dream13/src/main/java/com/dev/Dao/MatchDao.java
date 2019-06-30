package com.dev.Dao;

import java.util.List;

import com.dev.Model.Match;
import com.dev.Model.Team;

public interface MatchDao {
	
	public void saveMatch(Match request) throws Exception;
	
	public Match getMatchyId(int id);

	public Match joinMatch(int userId, int matchId);
	
	public List<Team> loadTeams(int userId, int matchId);

	public List<Match> getTodayMatches();

	public void updateCurrentState(int matchId, int deliveryCode);

	public void updateScore(int score1, int score2 , int matchId);
	
}
