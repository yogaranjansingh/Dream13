	package com.dev.Config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.Dao.MatchDao;
import com.dev.DaoImpl.TeamDaoImpl;
import com.dev.Model.DeliveryInfo;
import com.dev.Model.IPLTeam;
import com.dev.Model.Match;
import com.dev.Model.Player;
import com.dev.Model.Team;
import com.dev.Model.TeamSaveRequest;

@RestController
@RequestMapping("/v1")
public class MatchController {
	
	final static Logger logger = Logger.getLogger(MatchController.class);
	
	@Autowired
	TeamDaoImpl teamDaoimpl;
	
	@Autowired
	MatchDao matchDaoImpl;
	
	
	
	@RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
		logger.info("welcome api");
        return "Welcome to dream11 API";
    }
 
    @RequestMapping("/nextDelivery")
    public DeliveryInfo nextDelivery() {//REST Endpoint.
    	DeliveryInfo dv = new DeliveryInfo();
    	int delivery[] = {0,1,2,3,4,6,-1,-2,-3};
    	Random random = new Random();
    	int rand = random.nextInt(delivery.length-1);
    	dv.setDelivery(rand);
    	
    	
    	if(rand==1 || rand==3)
    		swapBatsman(dv);
    	
    	return dv;
    }
    
    
    private void swapBatsman(DeliveryInfo dv) {
		int temp = dv.getStrikeBatsmanPlayerId();
		dv.setStrikeBatsmanPlayerId(dv.getNonStrikeBatsmanPlayerId());
		dv.setNonStrikeBatsmanPlayerId(temp);
	}

	@RequestMapping(value="/saveTeam",  method=RequestMethod.POST)
    public void saveTeam(@RequestBody TeamSaveRequest request) {
		System.out.println(request.toString());
		logger.info(request.toString());
    logger.info("inside controller");
    teamDaoimpl.savePlayers(request);
    System.out.println("successfully saved");
    }
    
    @RequestMapping("/getIPLTeam")
    public IPLTeam getIPLTeam(@RequestParam int iplTeamId) {
    	return teamDaoimpl.getIPLTeam(iplTeamId);
    }
    
    @RequestMapping("/joinMatch")
    public List<Team> joinMatch(@RequestParam int userId, @RequestParam int matchId) {
    	logger.info("Inside controller join match UserId = "+userId + " matchId=" +matchId);
    	List<Team> teams = matchDaoImpl.joinMatch(userId, matchId);
    	return teams;
    }
    
    
    @RequestMapping("/create")
    public Player getPlayerById(@RequestParam int playerId) {
    	return teamDaoimpl.getPlayerById(playerId);
    }
    
    @RequestMapping("/saveMatch")
    public List<Match> saveMatch() throws Exception {
    	int iplteamIdList[] = {1,2,3,4,5,6,7,8};
    	Random random = new Random();
    	int rand = random.nextInt(iplteamIdList.length-1);
    	List<Match> matches = new ArrayList<Match>();
    	Match match = new Match();
    	match.setIplTeam1Id(101);
    	match.setIplTeam2Id(102);
    	/*
    	 * this is how we will create matches later , for now we only have dummy data for two teams , so hardcoding the match data for ipl teams
    	 */
//    	match.setIplTeam1Id(iplteamIdList[rand]);
//    	if(rand==0)
//    	match.setIplTeam2Id(iplteamIdList[rand+1]);
//    	else
//    		match.setIplTeam2Id(iplteamIdList[rand-1]);
    	match.setStatus("upcoming");
    	match.setResult("not-played");
    	match.setDateOfMatch(new Date());
    	
    	matches.add(match);
    	matchDaoImpl.saveMatch(match);
    	return matches;
    }
    
    @RequestMapping("/getTodaysMatch")
    public List<Match> getTodaysMatch() {
    	/*
    	 * later we will get the matches from match table where date 
    	 * == new date(). Also the matches in match table will be added by 
    	 * randomly creating match. the saveMatch api will bbe called twice a day or so.
    	 */
    	return matchDaoImpl.getTodayMatches();
    }
    
}
