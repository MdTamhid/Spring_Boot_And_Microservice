package com.tm.entity;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQProperties.Packages;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(basePackages="com.tm.repository.prod",
                          entityManagerFactoryRef ="postEMF",
                          transactionManagerRef ="postTxMgmr")
public class PostgresDBConfig {

	@Bean(name="postDS")
	@ConfigurationProperties(prefix="postgres.datasource")
	@Primary
	public DataSource createPostgresDs()
	{
		return DataSourceBuilder.create().build(); // gives Data Source object pointing to jdbc pool postgres
	}
	
	@Bean(name="postEMF")
	@Primary
	public LocalContainerEntityManagerFactoryBean createPostEMF(EntityManagerFactoryBuilder builder)
	{
		// prepare hibernate peoperties as the Map colletion
		Map<String,Object> map=new HashMap();
		map.put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
		map.put("hibernate.hbm2ddl.auto","update");
		//use EntityManagerFactoryBuilder to create LocalContainerEntityManagerFactoryBean and indirectly EntityManagerFacotry obj
	return builder.dataSource(createPostgresDs())
		.packages("com.tm.entity.prod") // entity class package name
		.properties(map) // hibernate peoperties
		.build();
			
	}
	
	@Bean(name="postTxMgmr")
	@Primary
	public PlatformTransactionManager createPostTxMgmr(@Qualifier("postEMF") EntityManagerFactory factory)
	{
		return new JpaTransactionManager(factory);
	}
}





