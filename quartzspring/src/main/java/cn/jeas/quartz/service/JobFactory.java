package cn.jeas.quartz.service;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Service;

@Service("jobFactory")
public class JobFactory extends AdaptableJobFactory{
	@Autowired
	private AutowireCapableBeanFactory capableBeanFactory;
	
	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
		// 调用父类的方法：quartz基于配置job类型生产了一个job对象（没有在spring容器中）
		Object jobInstance = super.createJobInstance(bundle);
		// 将Quartz生产出来的job对象，注入到spring容器，该job对象就变成了bean
		capableBeanFactory.autowireBean(jobInstance);
		return jobInstance;
	}

}
