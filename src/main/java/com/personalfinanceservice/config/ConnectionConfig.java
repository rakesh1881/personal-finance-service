package com.personalfinanceservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import io.micrometer.common.lang.NonNull;

@Component
public class ConnectionConfig {

	@Autowired
	private Environment environment;
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	public HikariConfig getDataSource(@NonNull String db) {

		try {
			String driverClassName = environment.getProperty("spring.datasource.hikari.driver-class-name");
			String userName = environment.getRequiredProperty("spring.datasource.hikari.username");
			String password = environment.getRequiredProperty("spring.datasource.hikari.password");
			boolean autoCommit = environment.getProperty("spring.datasource.hikari.auto-commit", Boolean.class, false);
			int minIdle = Integer.parseInt(environment.getProperty("spring.datasource.hikari.minimum-idle"));
			int maximum = environment.getProperty("spring.datasource.hikari.maximum-pool-size", Integer.class, 2);
			Long connectionTimeOut = environment.getProperty("spring.datasource.hikari.connectionTimeout", Long.class,
					360000000l);
			Long maximumLifeTime = environment.getProperty("spring.datasource.hikari.max-lifetime", Long.class,
					420000000l);
			HikariConfig config = new HikariConfig();
			config.setDriverClassName(driverClassName);
			config.setUsername(userName);
			config.setPassword(password);
			config.setAutoCommit(autoCommit);
			config.setMinimumIdle(minIdle);
			config.setMaximumPoolSize(maximum);
			config.setMaxLifetime(maximum);
			config.setConnectionTimeout(connectionTimeOut);
			config.setMaxLifetime(maximumLifeTime);
			String jdbcUrl = environment.getProperty("jdbc-url");
			config.setJdbcUrl(jdbcUrl.replace("<compdb>", db));
			logger.debug("User Name For MySql Connection is {}",userName);

			return config;

		} catch (Exception e) {
			throw e;
		}
	}
	
	@Bean(name="trandb")
	public JdbcTemplate getTrandbConnection() {
		HikariConfig config = getDataSource("demoTran");
		return new JdbcTemplate(new HikariDataSource(config));
	}
	@Bean(name="masterdb")
	public JdbcTemplate getMasterdbConnection() {
		HikariConfig config = getDataSource("demo");
		return new JdbcTemplate(new HikariDataSource(config));
	}

}
