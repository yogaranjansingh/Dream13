package com.dev.DaoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dev.Dao.TeamDao;
import com.dev.Model.Player;
import com.dev.Model.Team;
import com.dev.Model.TeamSaveRequest;

@Component
public class TeamDaoImpl implements TeamDao{
	
	final static Logger logger = Logger.getLogger(TeamDaoImpl.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private final String SQL_INSERT_TEAM = "insert into team_has_players( team_id, player_id) values(?,?)";

	public List<Player> getPlayers(int teamId) {
		return null;
	}

	public void savePlayers(TeamSaveRequest request) {
		logger.info("inside dao");
		logger.info("value of request objject" + request);
		Team team = request.getTeam();
		List<Player> players = team.getPlayers();
		for(Player player : players)
		jdbcTemplate.update(SQL_INSERT_TEAM, player.getId(), player.getIplTeamId());
	}

	public void sayHello()
	{
		System.out.println("Hello Yoga");
	}

}
