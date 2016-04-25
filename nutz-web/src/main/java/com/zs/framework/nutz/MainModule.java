package com.zs.framework.nutz;

import org.beetl.ext.nutz.BeetlViewMaker;
import org.nutz.integration.shiro.ShiroSessionProvider;
import org.nutz.mvc.annotation.ChainBy;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Localization;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.SessionBy;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.annotation.Views;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

@SetupBy(value=MainSetup.class)
@IocBy(type=ComboIocProvider.class,args={
		"*js","ioc/","*anno","com.zs.framework.nutz","*tx",
        "*org.nutz.integration.quartz.QuartzIocLoader"
})
@Modules(scanPackage=true)
@Ok("json:full")
@Fail("jsp:jsp.500")
@Localization(value="msg/", defaultLocalizationKey="zh-CN")
@ChainBy(args="mvc/nutzweb-mvc-chain.js")
@SessionBy(ShiroSessionProvider.class)
@Views({BeetlViewMaker.class})
public class MainModule {

}
