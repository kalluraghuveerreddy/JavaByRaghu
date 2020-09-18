package com.javabyraghu.friendsportal.config;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.javabyraghu.friendsportal")
@EnableTransactionManagement
public class PersistanceConfiguration {

	@Bean("dataSource")
	public BasicDataSource getDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/friend");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("root123");

		return basicDataSource;

	}

	@Bean
	public SessionFactory localSessionFactoryBuilder() {
		LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(getDataSource());
		localSessionFactoryBuilder.addProperties(getProperties());
		localSessionFactoryBuilder.scanPackages("com.javabyraghu.friendsportal.model");

		return localSessionFactoryBuilder.buildSessionFactory();

	}

	private Properties getProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");

		return properties;
	}

	@Bean
	public HibernateTransactionManager hibernateTransactionManager() {
		return new HibernateTransactionManager(localSessionFactoryBuilder());
	}

}
