package com.kfit.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job{
int i = 0 ;
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		// TODO Auto-generated method stub
		System.out.println("HelloJOb,data=,"+new Date()+"i="+i++);
		System.out.println();
	}
	
	

}
