package com.dev.Dao;

import java.util.List;

import com.dev.Model.Match;
import com.dev.Model.Team;

public interface MatchDao {
	
	public void saveMatch(Match request) throws Exception;
	
	public Match getMatchyId(int id);

	public List<Team> joinMatch(int userId, int matchId);

	public List<Match> getTodayMatches();
	
}
