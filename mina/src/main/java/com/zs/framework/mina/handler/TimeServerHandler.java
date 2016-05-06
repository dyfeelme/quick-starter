package com.zs.framework.mina.handler;


import java.util.Date;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class TimeServerHandler extends IoHandlerAdapter {
	
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {

		cause.printStackTrace();
	}
	
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {

		String msg = message.toString();
		if("quit".equalsIgnoreCase(msg.trim())){
			session.closeNow();
			return;
		}
		Date date = new Date();
		session.write(date.toString());
		System.out.println("server receiver msg:"+msg);
	}
	
	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		System.out.println("IDEL"+session.getIdleCount(status));
	}

}
