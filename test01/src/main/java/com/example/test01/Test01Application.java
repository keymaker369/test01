package com.example.test01;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.example.test01.domain.Note;

@SpringBootApplication
@EnableWebSecurity
public class Test01Application {

	public static void main(String[] args) {
		SpringApplication.run(Test01Application.class, args);
	}
	
	@Bean(destroyMethod = "close")
	@ConfigurationProperties("app.datasource")
	public BasicDataSource getdataSource() {
		return new BasicDataSource();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(getdataSource())
				.packages(Note.class)
				.persistenceUnit("persistenceUnit")
				.build();		
	}
}
