package com.zs.framework.jfinal.routers;

import com.jfinal.config.Routes;
import com.zs.framework.jfinal.controller.IndexController;

public class FrontRouter extends Routes {

	@Override
	public void config() {
		add("/",IndexController.class);

	}

}
