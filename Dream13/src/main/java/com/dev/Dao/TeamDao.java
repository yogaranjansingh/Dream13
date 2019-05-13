package com.dev.Dao;

import java.util.List;

import com.dev.Model.Player;
import com.dev.Model.TeamSaveRequest;

public interface TeamDao {
	
	public List<Player> getPlayers(int teamId);
	public void savePlayers(TeamSaveRequest request);
	
}
