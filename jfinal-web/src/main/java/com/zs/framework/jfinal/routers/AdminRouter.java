package com.zs.framework.jfinal.routers;

import com.jfinal.config.Routes;
import com.zs.framework.jfinal.controller.IndexController;
import com.zs.framework.jfinal.controller.UserController;

public class AdminRouter extends Routes {

	@Override
	public void config() {
		add("/index", IndexController.class);
		add("/admin/login",UserController.class);
	}

}
