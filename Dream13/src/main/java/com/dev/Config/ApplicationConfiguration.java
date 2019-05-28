package com.dev.Config;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.dev.DaoImpl.TeamDaoImpl;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.dev")
public class ApplicationConfiguration extends WebMvcConfigurerAdapter{
	
	private final String URL = "jdbc:mysql://localhost:3306/Dream11";
	private final String USER = "root";
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String PASSWORD = "root";
	
	final static Logger logger = Logger.getLogger(TeamDaoImpl.class);
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
		logger.info("******************************************inside cors method");
        registry.addMapping("/**")
                .allowedMethods("GET", "POST").allowedOrigins("*");
    }
	
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