package cn.jeas.quartz.service;

import org.springframework.stereotype.Service;

@Service
public class HelloJobService {
	public void sayHello(){
		System.out.println("say hell,my quartz!!!");
	}
}
