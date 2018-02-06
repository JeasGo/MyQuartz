package cn.jeas.quartz.test;

import org.junit.Test;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest {
	
	@Test
	//简单定时任务
	public void testCronTriger() throws Exception{
		// Grab the Scheduler instance from the Factory
		//获取大管家
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		
		// and start it off
		//开启大管家
		scheduler.start();
		
		//定时任务的详细代码。。。。。
		// define the job and tie it to our HelloJob class
		//定义任务详情对象，参数，具体的job任务对象
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
				//指定任务的名字和组，一组可以包含很多job，定时任务调用时候根据组调用的，名字随便
		      .withIdentity("job1", "group1")
		      .build();
		
		// Trigger the job to run now, and then repeat every 40 seconds
		//定义触发（定时、重复）规则
		Trigger trigger = TriggerBuilder.newTrigger()
				//规则的名字和规则要关联的组
		      .withIdentity("trigger1", "group1")
		      //程序启动后立即开始执行job任务
		      .startNow()
		      //使用什么样的定时对象
		      .withSchedule(
//		    		CronScheduleBuilder.cronSchedule("0/5 * * * * ?") 
		    		CronScheduleBuilder.cronSchedule("0/3 26 20 6 * ?") 
		              )            
		      .build();
		
		// Tell quartz to schedule the job using our trigger
		//任务详情和定时规则交给大管家
		scheduler.scheduleJob(jobDetail, trigger);
		
		//不让junit终止jvm
		while(true){
			
		}
	
		//关闭大管家
//		scheduler.shutdown();

	}
	
	
	@Test
	//简单定时任务
	public void testSimpleTriger() throws Exception{
		// Grab the Scheduler instance from the Factory
		//获取大管家
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		
		// and start it off
		//开启大管家
		scheduler.start();
		
		//定时任务的详细代码。。。。。
		// define the job and tie it to our HelloJob class
		//定义任务详情对象，参数，具体的job任务对象
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
				//指定任务的名字和组，一组可以包含很多job，定时任务调用时候根据组调用的，名字随便
		      .withIdentity("job1", "group1")
		      .build();
		
		// Trigger the job to run now, and then repeat every 40 seconds
		//定义触发（定时、重复）规则
		Trigger trigger = TriggerBuilder.newTrigger()
				//规则的名字和规则要关联的组
		      .withIdentity("trigger1", "group1")
		      //程序启动后立即开始执行job任务
		      .startNow()
		      //使用什么样的定时对象
		      .withSchedule(
		    		  //简单的定时任务触发对象
		    		  SimpleScheduleBuilder.simpleSchedule()
		    		  //每隔多少秒执行一次
		              .withIntervalInSeconds(3)
		              //总共要执行多少次，repeatForever是永远执行下去
		              .repeatForever()
		              )            
		      .build();
		
		// Tell quartz to schedule the job using our trigger
		//任务详情和定时规则交给大管家
		scheduler.scheduleJob(jobDetail, trigger);
		
		//不让junit终止jvm
		while(true){
			
		}
	
		//关闭大管家
//		scheduler.shutdown();

	}
	
	//quatz容器启动和关闭
	@Test
	public void testFirst() throws Exception {
		//创建一个Scheduler：调度大管家
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler scheduler = sf.getScheduler();
		//To do something interesting, you need code between the start() and shutdown() calls.
		scheduler.start();
		
		//中间添加调度代码
		
		scheduler.shutdown();
	}
	

	
}
