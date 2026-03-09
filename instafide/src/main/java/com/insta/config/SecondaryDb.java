package com.insta.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
		basePackages = "com.insta.postgre.repo",
		entityManagerFactoryRef = "postgreEntityManager",
		transactionManagerRef = "postgreTransaction")
//@EnableTransactionManagement

public class SecondaryDb {

	@Bean("postgreDb")
	@ConfigurationProperties("spring.datasource.postgres")
	 DataSource getPostDataSource() {

		 return DataSourceBuilder.create().build();
	}
	
	
	@Bean("postgreEntityManager")
	LocalContainerEntityManagerFactoryBean getEntityManager(EntityManagerFactoryBuilder builder) {

		return builder.dataSource(getPostDataSource())
				.packages("com.insta.postgre.entity")
				.persistenceUnit("postgreDb")
				.build();
	}
	
	@Bean("postgreTransaction")
	PlatformTransactionManager getPostTRansaction(@Qualifier("postgreEntityManager") EntityManagerFactory em) {

		return new JpaTransactionManager(em);
	}
}
