package com.zs.framework.mina.client;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.transport.socket.SocketConnector;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.zs.framework.mina.filter.LoggingFilter;
import com.zs.framework.mina.filter.codec.demux.SumUpProtocolCodecFactory;
import com.zs.framework.mina.handler.ClientSessionHandler;

public class TimeClient {
	
	private static final long CONNECTION_TIMEOUT = 30*1000L;
	private static final int PORT = 9123;
	private static final String HOSTNAME = "localhost";
	private static final boolean USE_CUSTOM_CODEC = true;

	public static void main(String[] args) throws Throwable {
		
		args = new String[]{"1","2","3","4"};
		
		if (args.length == 0) {
            System.out.println("Please specify the list of any integers");
            return;
        }

        // prepare values to sum up
        int[] values = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            values[i] = Integer.parseInt(args[i]);
        }

		SocketConnector connector = new NioSocketConnector();
		connector.setConnectTimeoutMillis(CONNECTION_TIMEOUT);
		
		if(USE_CUSTOM_CODEC){
			connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new SumUpProtocolCodecFactory(false)));
		
		}else{
			connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
		}
		
		connector.getFilterChain().addLast("logger", new LoggingFilter());
		connector.setHandler(new ClientSessionHandler(values));
		
		IoSession session;
		
		for(;;){
			try {
				ConnectFuture future = connector.connect(new InetSocketAddress(HOSTNAME, PORT));
				
				future.awaitUninterruptibly();
				
				session = future.getSession();
				break;
			} catch (RuntimeIoException e) {
				System.err.println("failed to connect .");
				e.printStackTrace();
				Thread.sleep(5000);
			}
		}
		
		session.getCloseFuture().awaitUninterruptibly();
		connector.dispose();
	}

}
