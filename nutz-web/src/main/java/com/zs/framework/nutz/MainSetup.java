package com.zs.framework.nutz;

import org.apache.commons.mail.HtmlEmail;
import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.integration.quartz.NutQuartzCronJobFactory;
import org.nutz.ioc.Ioc;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

import com.zs.framework.nutz.beans.User;
import com.zs.framework.nutz.service.RedisService;
import com.zs.framework.nutz.service.UserService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class MainSetup implements Setup {
	
	private static final Log log = Logs.get();

	@Override
	public void destroy(NutConfig conf) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(NutConfig conf) {
		Ioc ioc = conf.getIoc();
		Dao dao = ioc.get(Dao.class);
		Daos.createTablesInPackage(dao, "com.zs.framework.nutz", true);

		 // 初始化默认根用户
        if (dao.count(User.class) == 0) {
            UserService us = ioc.get(UserService.class);
            us.add("admin", "123456");
        }

		// 获取NutQuartzCronJobFactory从而触发计划任务的初始化与启动
		ioc.get(NutQuartzCronJobFactory.class);

		// 测试发送邮件
		try {
			HtmlEmail email = ioc.get(HtmlEmail.class);
			email.setSubject("测试NutzWeb");
			email.setMsg("This is a test mail ... :-)" + System.currentTimeMillis());
			email.addTo("zorosteven@163.com");// 请务必改成您自己的邮箱啊!!!
			email.buildMimeMessage();
			email.sendMimeMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//测试Redis
		RedisService redis = ioc.get(RedisService.class);
        redis.set("hi", "wendal");
        log.debug("redis say again : "  + redis.get("hi"));
	}
}
