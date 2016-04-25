package com.zs.framework.nutz.service;

import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.IocBean;

import com.zs.framework.nutz.interceptor.RedisInterceptor;

@IocBean
public class RedisService {

    @Aop("redis")
    public void set(String key, String val) {
    	RedisInterceptor.jedis().set(key, val);
    }

	@Aop("redis") // 加上这个拦截器后jedis()才能返回Jedis实例哦
    public String get(String key) {
        return RedisInterceptor.jedis().get(key);
    }
}
