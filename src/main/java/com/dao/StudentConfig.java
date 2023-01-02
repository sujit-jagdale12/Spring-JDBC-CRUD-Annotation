package com.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan({"com.dao"})
public class StudentConfig {

	// You can give ant name to access the DataSource bean
	
	@Bean(name = { "data", "dataSource", "source", "connection" })
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	@Bean("template")
	public JdbcTemplate getTemplate() {
		JdbcTemplate template=new JdbcTemplate();
		template.setDataSource(getDataSource());
		
		return template;
	}
	
	//If you have autowired the studentimpl class then doesn't need to create this method
	
//	@Bean("dao")
//	public StudentDao getDao() {
//		StudentImpl impl=new StudentImpl();
//		impl.setTemplate(getTemplate());
//		
//		return impl;
//	}
}
