package com.zs.framework.quartz;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

public final class AutowiredSpringBeanJobFactory  extends SpringBeanJobFactory implements ApplicationContextAware{

	private transient AutowireCapableBeanFactory factory;
	
	@Override
	public void setApplicationContext(final ApplicationContext context) throws BeansException {
		factory = context.getAutowireCapableBeanFactory();
	}
	
	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
		 final Object instance = super.createJobInstance(bundle);
	     factory.autowireBean(instance);
	     return instance;
	}

}
