package com.dev.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.dev.Dao.TeamDao;
import com.dev.Model.IPLTeam;
import com.dev.Model.Player;
import com.dev.Model.Team;
import com.dev.Model.TeamSaveRequest;

@Component
public class TeamDaoImpl implements TeamDao{
	
	final static Logger logger = Logger.getLogger(TeamDaoImpl.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private final String SQL_INSERT_TEAM = "insert into TEAM(name, captain_id, vice_captain_id, user_id, match_id ) values(?,?,?,?,?)";
	private final String SQL_GET_TEAM_BY_ID = "select * from Team where id = ?";
	private final String SQL_GET_IPL_TEAM = "select * from IPLTeam where id = ?";
	private final String SQL_GET_Players = "select * from Player where teamid = ?";
	private final String SQL_SAVE_TEAM_HAS_Players = "insert into team_has_players(team_id, player_id) values(?, ?)";
	private final String SQL_GET_PlAYER_BY_ID = "Select * from Player where id = ?";
	private final String SQL_TEAM_BY_USERID_AND_MATCHID = "Select * from TEAM where user_id = ? and match_id= ?";

	public List<Player> getPlayers(int teamId) {
		List<Player> players = new ArrayList<Player>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_GET_Players,teamId);
		
		for (Map row : rows) {
			Player player = new Player();
			player.setId((Integer)(row.get("id")));
			player.setName((String) (row.get("name")));	
			player.setPlayerType((String) row.get("playerType"));
			player.setPointsThisSeason((Integer) row.get("pointScoredThisSeason"));
			player.setIplTeamId((Integer) row.get("teamid"));
			players.add(player);
		}
			
		return players;
	}

	public void savePlayers(TeamSaveRequest request) {
		final Team team = request.getTeam();
		List<Player> players = team.getPlayers();
		//jdbcTemplate.update(SQL_INSERT_TEAM, team.getName(), team.getCaptainId(), team.getViceCaptainId(), team.getUserId(), team.getMatchId());
		
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {           

		                public PreparedStatement createPreparedStatement(Connection connection)
		                        throws SQLException {
		                    PreparedStatement ps = connection.prepareStatement(SQL_INSERT_TEAM,
		                    		new String[] {"id"}); 
		                    ps.setString(1, team.getName());
				            ps.setInt(2, team.getCaptainId());
				            ps.setInt(3, team.getViceCaptainId());
				            ps.setInt(4, team.getUserId());
				            ps.setInt(5, team.getMatchId());
		                    return ps;
		                }
		            }, keyHolder);
		
		
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+keyHolder.getKey());
		for(Player player : players)
		jdbcTemplate.update(SQL_SAVE_TEAM_HAS_Players, keyHolder.getKey().intValue(), player.getId() );
	}

	public void sayHello()
	{
		System.out.println("Hello Yoga");
	}
	

	public IPLTeam getIPLTeam(int iplTeamId) {
		IPLTeam iplTeam = (IPLTeam) jdbcTemplate.queryForObject(
				SQL_GET_IPL_TEAM, new Object[] { iplTeamId }, 
				new BeanPropertyRowMapper(IPLTeam.class));
		
		List<Player> players = this.getPlayers(iplTeamId);
		iplTeam.setPlayers(players);

		return iplTeam;
	}

	public Player getPlayerById(int playerId) {
		Player player = (Player) jdbcTemplate.queryForObject(
				SQL_GET_PlAYER_BY_ID, new Object[] { playerId }, 
				new BeanPropertyRowMapper(Player.class));
		
		return player;
	}

	public Team getTeamByUserAndMatch(int userId, int matchId) {
		logger.info("============= Inside team daoi impl userId = "+userId +"and matchId = "+matchId);
		Team team = (Team) jdbcTemplate.queryForObject(
				SQL_TEAM_BY_USERID_AND_MATCHID, new Object[] { userId, matchId }, 
				new BeanPropertyRowMapper(Team.class));
		return team;
	}

	public Team getTeamById(int teamId) {
		Team team = (Team) jdbcTemplate.queryForObject(
				SQL_GET_TEAM_BY_ID, new Object[] { teamId }, 
				new BeanPropertyRowMapper(Team.class));
		return team;
	}
	
}
