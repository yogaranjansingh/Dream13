	package com.dev.Config;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    public Integer nextDelivery() {//REST Endpoint.
    	DeliveryInfo dv = new DeliveryInfo();
    	int delivery[] = {0,1,2,3,4,6,-1,-2,-3};
    	Random random = new Random();
    	int rand = random.nextInt(delivery.length-1);
    	dv.setDelivery(rand);
    	
    	
    	if(rand==1 || rand==3)
    		swapBatsman(dv);
    	
    	return rand;
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
    
    @RequestMapping(value="/joinMatch", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public Match joinMatch(@RequestParam int userId, @RequestParam int matchId) {
    	logger.info("Inside controller join match UserId = "+userId + " matchId=" +matchId);
    	Match match = matchDaoImpl.joinMatch(userId, matchId);
    	return match;
    }
    
    @RequestMapping("/loadTeams")
    public List<Team> loadTeams(@RequestParam int userId, @RequestParam int matchId) {
    	List<Team> teams = matchDaoImpl.loadTeams(userId, matchId);
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
    
    @RequestMapping("/getMatchById")
    public Match getMatchById(@RequestParam int matchId) {
    	return matchDaoImpl.getMatchyId(matchId);
    }
    
    @RequestMapping("/getTeamById")
    public Team getTeamById(@RequestParam int teamId) {
    	return teamDaoimpl.getTeamById(teamId);
    }
    
    @RequestMapping("/startMatch")
    public void startMatch(@RequestParam int matchId) throws InterruptedException {
    	Match match = this.getMatchById(matchId);
    	int deliveriesPlayed = 0;
    	int totalScore =0;
    	IPLTeam iplTeam1 = this.getIPLTeam(match.getIplTeam1Id());
    	
    	IPLTeam iplTeam2 = this.getIPLTeam(match.getIplTeam2Id());
    	
    	logger.info("************************************************");
    	logger.info("************************************************");
    	logger.info("IPLTeam1 = "+iplTeam1);
    	logger.info("IPLTeam1 = "+iplTeam2);
    	
    		
    	
    	Team team1 = this.getTeamById(match.getTeamId1());
    	Team team2 =  this.getTeamById(match.getTeamId2());
    	
    	logger.info("Team1="+team1);
    	logger.info("Team2="+team2);
    	int score1 = 0;
    	int score2 = 0;
    	
    	HashSet<Integer> t1 = new HashSet<Integer>();
    	HashSet<Integer> t2 = new HashSet<Integer>();
    	
    	for(Player p : team1.getPlayers())
    	{
    		t1.add(p.getId());
    	}
    	
    	for(Player p : team2.getPlayers())
    	{
    		t2.add(p.getId());
    	}
    	
    	List<Player> players1 = iplTeam1.getPlayers();
    	List<Player> players2 = iplTeam1.getPlayers();
    	
    	int currentlyBatting= 0;
    	Player bat1 = players1.get(currentlyBatting);
    	Player bat2 = players1.get(currentlyBatting+1);
    	
    	while(deliveriesPlayed<=120 || currentlyBatting<=10)
    	{
    		
    		logger.info("match is running");
			int delivery = this.nextDelivery();
			if(delivery == -3)
			{
				currentlyBatting+=1;
				bat1 = players1.get(currentlyBatting);
				deliveriesPlayed++;
				logger.info("*******--OUT--********");
			}
			
			else if(delivery == -2 ||delivery==-1)
			{
				if(t1.contains(bat1.getId()))
					score1+=1;
				logger.info("*******--Wide Ball--********");
			}
			else
			{
				if(t1.contains(bat1.getId()))
					score1+=delivery;
				if(t2.contains(bat1.getId()))
					score2+=delivery;
				
				if(delivery==1 || delivery==3)
				{
					Player temp = bat1;
					bat1 = bat2;
					bat2 = temp;
				}
				deliveriesPlayed++;
				logger.info("*******--run scored--******** "+delivery+"  runs");
			}
			
			if(deliveriesPlayed%6==0)
			{
				Player temp = bat1;
				bat1 = bat2;
				bat2 = temp;
				logger.info("*******--Over Complete--********");
			}
			logger.info("@@@@@@@@@@@@@@@@@@");
			logger.info("Updating score score1="+score1+" and score2 = "+score2);		
			logger.info("@@@@@@@@@@@@@@@@@@");
			matchDaoImpl.updateScore(score1, score2, matchId);
			Thread.sleep(3000);
    	}
    	logger.info("inning complete");
    	
    }
    
    @RequestMapping("/updatePoints")
    public void updatePoints(int matchId, int deliveryCode) {
    	
    	matchDaoImpl.updateCurrentState(matchId,deliveryCode);
    }
    
}
