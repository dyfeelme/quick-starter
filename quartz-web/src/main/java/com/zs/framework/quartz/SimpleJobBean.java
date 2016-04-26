package com.zs.framework.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.zs.framework.quartz.service.TaskService;

public class SimpleJobBean extends QuartzJobBean {
	
	@Autowired
	private TaskService taskService;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		
		System.out.println(sdf.format(new Date())+"-"+taskService.getTaskName("Simple")+"任务执行...");

	}

}
