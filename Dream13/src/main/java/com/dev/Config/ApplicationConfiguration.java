package com.dev.Config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "s")
public class ApplicationConfiguration {
	
	private final String URL = "jdbc:mysql://localhost:3306/Dream11";
	private final String USER = "root";
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String PASSWORD = "root";
	

	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(URL);
		driverManagerDataSource.setUsername(USER);
		driverManagerDataSource.setPassword(PASSWORD);
		driverManagerDataSource.setDriverClassName(DRIVER);
		return driverManagerDataSource;
	}
	
	@Bean
	JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
 }