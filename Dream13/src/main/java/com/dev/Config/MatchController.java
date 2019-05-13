package com.dev.Config;

import java.util.Random;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.DaoImpl.TeamDaoImpl;
import com.dev.Model.DeliveryInfo;
import com.dev.Model.Game;
import com.dev.Model.GameRefreshRequest;
import com.dev.Model.TeamSaveRequest;

@RestController
@RequestMapping("/v1")
public class MatchController {
	
	final static Logger logger = Logger.getLogger(MatchController.class);
	
	@Autowired
	TeamDaoImpl teamDaoimpl;
	
	
	
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
    logger.info("inside controller");

    teamDaoimpl.sayHello();
      
    teamDaoimpl.savePlayers(request);
    System.out.println("successfully saved");
    }
    
    @RequestMapping("/refreshGame")
    public Game refreshGame(@RequestBody GameRefreshRequest request) {
		return null;
    }

    
}
