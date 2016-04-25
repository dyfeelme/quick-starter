package com.zs.framework.nutz.modules;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.lang.random.R;

import com.zs.framework.nutz.service.EmailService;

public abstract class AbstractModule {

	@Inject
	protected Dao dao;

	@Inject
	protected EmailService emailService;

	protected byte[] emailKEY = R.sg(24).next().getBytes();
}
