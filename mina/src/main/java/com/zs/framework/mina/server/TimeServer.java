package com.zs.framework.mina.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.zs.framework.mina.filter.LoggingFilter;
import com.zs.framework.mina.handler.TimeServerHandler;

public class TimeServer {
	
	private static final int PORT = 9123;
	private static final int READ_BUFFER_SIZE = 2048;

	public static void main(String[] args) {
		IoAcceptor acceptor = new NioSocketAcceptor();
		try {
			//添加过滤器
			acceptor.getFilterChain().addLast("logger", new LoggingFilter());
			acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory( Charset.forName( "UTF-8" ))));
			
			acceptor.setHandler(new TimeServerHandler());
			
			acceptor.getSessionConfig().setReadBufferSize(READ_BUFFER_SIZE);
			acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
			
			acceptor.bind(new InetSocketAddress(PORT));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
