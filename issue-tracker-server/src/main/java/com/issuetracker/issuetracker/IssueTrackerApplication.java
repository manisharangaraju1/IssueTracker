package com.issuetracker.issuetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@SpringBootConfiguration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication (exclude = SecurityAutoConfiguration.class)
public class IssueTrackerApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(IssueTrackerApplication.class, args);
//
//	}

	public static void main(String[] args)
	{
		ApplicationContext ctx = SpringApplication.run(IssueTrackerApplication.class, args);

		String[] beanNames = ctx.getBeanDefinitionNames();

		Arrays.sort(beanNames);

		for (String beanName : beanNames)
		{
			System.out.println(beanName);
		}
	}

}
