package com.dev.DaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dev.Dao.UserDao;
import com.dev.Model.LoginRequest;
import com.dev.Model.RegistertionRequest;
import com.dev.Model.User;

@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private final String SQL_INSERT_USER = "insert into user(name,age,username,password) values(?,?,?,?)";
	private final String SQL_GET_USER = "select* from user where username = ? and password = ?";
	
	public void register(RegistertionRequest request) {
		
		jdbcTemplate.update(SQL_INSERT_USER, request.getName(), request.getAge(), request.getUsername(), request.getPassword());
		
	}

	public User login(LoginRequest request) {
		User user = (User) jdbcTemplate.queryForObject(
				SQL_GET_USER, new Object[] { request.getUsername(),request.getPassword() }, 
				new BeanPropertyRowMapper(User.class));
		
		
//List<Player> players = new ArrayList<Player>();
//		
//		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_GET_USER,request.getUsername(),request.getPassword());
//		User user = new User();
//		
//		for (Map row : rows) {
//			user.setId((Integer)(row.get("id")));
//			
//		}
		
		return user;
	}

}
