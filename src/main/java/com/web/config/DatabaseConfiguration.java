package com.web.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfiguration {

	@Bean
	public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();

	    dataSource.setDriverClassName("org.postgresql.Driver");
	    dataSource.setUsername("postgres");
	    dataSource.setPassword("abcd1234");
	    dataSource.setUrl(
	      "jdbc:postgresql://localhost:5432/postgres?createDatabaseIfNotExist=true"); 
	    
	    return dataSource;
	}
	
}
