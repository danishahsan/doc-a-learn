package com.insta.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
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
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
		basePackages= "com.insta.mySql.repo",
		entityManagerFactoryRef = "mySqlEntityManager",
		transactionManagerRef="mySqlTransaction")
@EnableTransactionManagement
public class PrimaryDB {

	@Primary
	@Bean("mySqlDb")
	@ConfigurationProperties("spring.datasource.mysql")
	DataSource getMySqlDataSource() {

		return DataSourceBuilder.create().build();
	}
	
	
	@Primary
	@Bean("mySqlEntityManager")
	LocalContainerEntityManagerFactoryBean getEntityManger(EntityManagerFactoryBuilder builder) {

		return builder.dataSource(getMySqlDataSource())
				.packages("com.insta.mySql.entity")
				.persistenceUnit("mySqlDb")
				.build();
	}
	
	
	@Primary
	@Bean("mySqlTransaction")
	PlatformTransactionManager getMySqlTransaction(@Qualifier("mySqlEntityManager")EntityManagerFactory em) {

		return new JpaTransactionManager(em);
	}
}
