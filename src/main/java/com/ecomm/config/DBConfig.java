package com.ecomm.config;

import java.sql.DriverManager;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.UserDetail;

@Configuration
@ComponentScan("com.ecomm")
@EnableTransactionManagement
public class DBConfig
{
	//DataSource Bean
	
	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
		
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:~/ecom");
		dataSource.setUsername("jdbc");
		dataSource.setPassword("jdbc");
		
		System.out.println("--DataBase Created--");
		return dataSource;
		
	}
	
	//SessionFactory Bean
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProperties=new Properties();
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update" );
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getH2DataSource());
		factory.addProperties(hibernateProperties);
		
		factory.addAnnotatedClass(Category.class);
		factory.addAnnotatedClass(Product.class);
		factory.addAnnotatedClass(UserDetail.class);
		
		System.out.println("--Session Factory--");
		return factory.buildSessionFactory();
	}
	
	
	//HibernateTransaction Bean
	@Bean(name="txManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("--txManager Object Created--");
		return new HibernateTransactionManager(sessionFactory);	
	}
	
	
}		

