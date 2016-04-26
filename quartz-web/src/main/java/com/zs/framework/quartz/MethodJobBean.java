package com.zs.framework.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.zs.framework.quartz.service.TaskService;

public class MethodJobBean {
	
	@Autowired
	private TaskService taskService;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
	
	public void execute(){
		System.out.println(sdf.format(new Date())+"-"+taskService.getTaskName("Method")+"任务执行...");
	}

}
