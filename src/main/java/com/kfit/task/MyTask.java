package com.kfit.task;

import javax.annotation.PostConstruct;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfit.job.HelloJob;

@Service
public class MyTask {
	@Autowired
	private Scheduler scheduler;
	
	@PostConstruct  //init-method
	public void init() {
		//定义jobDetail
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("job1","scheduler").build();	
		//定义
		SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger","group1").startNow().withSchedule(simpleScheduleBuilder).build();
		try {
			scheduler.scheduleJob(jobDetail,trigger);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
