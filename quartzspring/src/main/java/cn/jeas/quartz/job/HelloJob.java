package cn.jeas.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import cn.jeas.quartz.service.HelloJobService;

public class HelloJob implements Job{
	
	@Autowired
	private HelloJobService helloJobService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		helloJobService.sayHello();
	}
	
}
