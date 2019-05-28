package com.dev.DaoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dev.Dao.MatchDao;
import com.dev.Dao.TeamDao;
import com.dev.Model.Match;
import com.dev.Model.Player;
import com.dev.Model.Team;

@Component
public class MatchDaoImpl implements MatchDao {

	final static Logger logger = Logger.getLogger(MatchDaoImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	TeamDao teamDao;

	private final String SQL_GET_MATCH_BY_ID = "select * from Dream11.match where id = ?";
	private final String SQL_SAVE_MATCH = "insert into Dream11.match(status, result, userid1, userid2, dateOfMatch, teamid1, teamid2, iplTeamId1, iplTeamId2) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String SQL_UPDATE_MATCH1 = "update Dream11.match set userid1 = ? , teamid1 = ? where id = ?";
	private final String SQL_UPDATE_MATCH2 = "update Dream11.match set userid2 = ? , teamid2 = ? where id = ?";
	private final String SQL_GET_MATCHES = "select * from Dream11.match";
	private final String SQL_GET_PLAYERS_FROM_TEAM = "select * from Dream11.team_has_players where team_id = ?";
	private final String SQL_GET_PLAYER_BY_ID = "select * from Dream11.Player where id = ?";

	public void saveMatch(Match match) throws Exception {
		jdbcTemplate.update(SQL_SAVE_MATCH, match.getStatus(), match.getResult(), match.getUserId1(),
				match.getUserId2(), match.getDateOfMatch(), match.getTeamId1(), match.getTeamId2(),
				match.getIplTeam1Id(), match.getIplTeam2Id());
	}

	public Match getMatchyId(int id) {
		Match match = (Match) jdbcTemplate.queryForObject(SQL_GET_MATCH_BY_ID, new Object[] { id },
				new BeanPropertyRowMapper(Match.class));
		return match;
	}

	public List<Team> joinMatch(int userId, int matchId) {
		logger.info("/n looking for team with userId=" + userId + " and matchId = " + matchId);
		Team team = teamDao.getTeamByUserAndMatch(userId, matchId);

		Match match = this.getMatchyId(matchId);
		if (match.getUserId1() == 0) {
			jdbcTemplate.update(SQL_UPDATE_MATCH1, userId, team.getId(), match.getId());
		} else {
			jdbcTemplate.update(SQL_UPDATE_MATCH2, userId, team.getId(), match.getId());
		}
		match = this.getMatchyId(matchId);
		Team team1 = null;
		Team team2 = null;
		try {
			team1 = teamDao.getTeamById(match.getTeamId1());
			
			List<Player> playerList = new ArrayList<Player>();
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_GET_PLAYERS_FROM_TEAM,team1.getId());
			for (Map row : rows) {
				Player player = (Player) jdbcTemplate.queryForObject(SQL_GET_PLAYER_BY_ID, new Object[] { row.get("player_id") },
						new BeanPropertyRowMapper(Player.class));
				playerList.add(player);
			}
			team1.setPlayers(playerList);
		} catch (Exception e) {
			team1 = new Team();
		}
		
		try {
			team2 = teamDao.getTeamById(match.getTeamId2());
			List<Player> playerList = new ArrayList<Player>();
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_GET_PLAYERS_FROM_TEAM,team2.getId());
			for (Map row : rows) {
				Player player = (Player) jdbcTemplate.queryForObject(SQL_GET_PLAYER_BY_ID, new Object[] { row.get("player_id") },
						new BeanPropertyRowMapper(Player.class));
				playerList.add(player);
			}
			team2.setPlayers(playerList);
		} catch (Exception e) {
			team2 = new Team();
		}
		
		logger.info("team1 = "+team1.toString() +"  team2 = "+team2.toString());

		List<Team> teams = new ArrayList<Team>();
		teams.add(team1);
		teams.add(team2);
		return teams;

	}

	public List<Match> getTodayMatches() {
		List<Match> matches = new ArrayList<Match>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_GET_MATCHES);

		for (Map row : rows) {
			Match match = new Match();
			match.setId((Integer) row.get("id"));
			match.setDateOfMatch((Date) row.get("dateOfMatch"));
			match.setIplTeam1Id((Integer) row.get("iplTeamId1"));
			match.setIplTeam2Id((Integer) row.get("iplTeamId2"));
			match.setResult((String) row.get("result"));
			match.setStatus((String) row.get("status"));
			match.setTeamId1((Integer) row.get("teamid1"));
			match.setTeamId2((Integer) row.get("teamid2"));
			match.setUserId1((Integer) row.get("userid2"));
			match.setUserId2((Integer) row.get("userid2"));
			matches.add(match);
		}

		return matches;

	}

}
