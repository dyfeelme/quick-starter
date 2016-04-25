package com.zs.framework.jfinal;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.zs.framework.jfinal.beans.User;
import com.zs.framework.jfinal.controller.IndexController;
import com.zs.framework.jfinal.controller.UserController;
import com.zs.framework.jfinal.interceptors.AuthInterceptor;
import com.zs.framework.jfinal.routers.AdminRouter;
import com.zs.framework.jfinal.routers.FrontRouter;

public class MainConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants constants) {
		PropKit.use("system.properties");
		constants.setDevMode(PropKit.getBoolean("devmode"));
		constants.setViewType(ViewType.JSP);

	}

	@Override
	public void configHandler(Handlers handlers) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configInterceptor(Interceptors interceptors) {
		interceptors.add(new AuthInterceptor());

	}

	@Override
	public void configPlugin(Plugins plugins) {
		loadPropertyFile("db.properties");
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"),
		getProperty("user"), getProperty("password"));
		plugins.add(c3p0Plugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		plugins.add(arp);
		arp.addMapping("user", User.class);

	}

	@Override
	public void configRoute(Routes routes) {
		routes.add(new FrontRouter()).add(new AdminRouter());

	}

}
