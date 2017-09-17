package com.sms.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:database.properties")
public class DataBaseConfiguration {

	@Autowired
	public Environment environment;

	@Bean
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(sessionFactory());

	}

	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBean factroyBean = new LocalSessionFactoryBean();
		factroyBean.setDataSource(getDataSource());
		factroyBean.setPackagesToScan("com.concretepage.entity");
		factroyBean.setHibernateProperties(hibernateProperties());
		try {
			factroyBean.afterPropertiesSet();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return factroyBean.getObject();
	}

	@Bean
	public DataSource getDataSource() {
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName(environment.getProperty("database.driverClassName"));
		datasource.setUrl(environment.getProperty("database.url"));
		datasource.setUsername(environment.getProperty("database.username"));
		datasource.setPassword(environment.getProperty("database.password"));
		return datasource;
	}

	@Bean
	public HibernateTransactionManager hibernateTransactionManager() {
		return new HibernateTransactionManager(sessionFactory());
	}

	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		return properties;
	}
}
