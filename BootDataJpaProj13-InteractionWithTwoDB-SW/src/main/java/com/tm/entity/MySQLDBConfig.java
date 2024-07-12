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
@EnableJpaRepositories(basePackages="com.tm.repository.promotions",
                          entityManagerFactoryRef ="mysqlEMF",
                          transactionManagerRef ="mysqlTxMgmr")
public class MySQLDBConfig {

	@Bean(name="mysqlDS")
	@ConfigurationProperties(prefix="mysql.datasource")
	public DataSource createMysqlDs()
	{
		return DataSourceBuilder.create().build(); // gives Data Source object pointing to jdbc pool postgres
	}
	
	@Bean(name="mysqlEMF")
	public LocalContainerEntityManagerFactoryBean createMysqlEMF(EntityManagerFactoryBuilder builder)
	{
		// prepare hibernate peoperties as the Map colletion
		Map<String,Object> map=new HashMap();
		map.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
		map.put("hibernate.hbm2ddl.auto","update");
		//use EntityManagerFactoryBuilder to create LocalContainerEntityManagerFactoryBean and indirectly EntityManagerFacotry obj
	return builder.dataSource(createMysqlDs())
		.packages("com.tm.entity.promotions") // entity class package name
		.properties(map) // hibernate peoperties
		.build();
			
	}
	
	@Bean(name="mysqlTxMgmr")
	public PlatformTransactionManager createMysqlTxMgmr(@Qualifier("mysqlEMF") EntityManagerFactory factory)
	{
		return new JpaTransactionManager(factory);
	}
}





