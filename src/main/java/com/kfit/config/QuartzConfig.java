package com.kfit.config;

import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * 
 * @author poyu
 *
 */
@Configuration
public class QuartzConfig {
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		return schedulerFactoryBean;
	}
	
	public Scheduler schedule() {
		return schedulerFactoryBean().getScheduler();
		
	}

}
