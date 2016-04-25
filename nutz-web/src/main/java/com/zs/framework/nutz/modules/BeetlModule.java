package com.zs.framework.nutz.modules;

import org.nutz.dao.QueryResult;
import org.nutz.dao.pager.Pager;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Ok;

import com.zs.framework.nutz.beans.UserProfile;

public class BeetlModule extends AbstractModule {

	@At
	@Ok("beetl:hello.html")
	@Fail("void") // beelt的机制导致只能使用void,详细原因看nutzbook中的代码吧
	public Object hello() {
		QueryResult qr = new QueryResult();
		Pager pager = dao.createPager(1, 20);
		pager.setRecordCount(dao.count(UserProfile.class));
		qr.setPager(pager);
		qr.setList(dao.query(UserProfile.class, null, pager));
		return qr;
	}
}
