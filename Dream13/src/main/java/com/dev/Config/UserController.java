package com.dev.Config;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.Dao.UserDao;
import com.dev.Model.LoginRequest;
import com.dev.Model.RegistertionRequest;
import com.dev.Model.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	HttpSession httpSession;
	
	final static Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	UserDao userDao;

	@RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
		logger.info("welcome to user api");
        return "Welcome to user management API";
    }
	
	@RequestMapping("/register")
    public void register(@RequestBody RegistertionRequest request) {//Welcome page, non-rest
		
		userDao.register(request);
    }
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
    public User login(@RequestBody LoginRequest request) {//Welcome page, non-rest
		User user = userDao.login(request);
		return user;
    }
}
