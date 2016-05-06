package com.zs.framework.mina.filter;

import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.session.IoSession;

public class LoggingFilter extends IoFilterAdapter {
	
	@Override
	public void exceptionCaught(NextFilter nextFilter, IoSession session, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(nextFilter, session, cause);
	}
	
	@Override
	public void messageReceived(NextFilter nextFilter, IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		super.messageReceived(nextFilter, session, message);
	}

}
