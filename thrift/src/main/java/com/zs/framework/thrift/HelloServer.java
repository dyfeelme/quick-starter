package com.zs.framework.thrift;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.AbstractServerArgs;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class HelloServer {
	
	public static final int SERVER_PORT = 8090;
	
	private void startServer(){
		TProcessor processor = new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl());
		
		TServerSocket transport;
		try {
			transport = new TServerSocket(SERVER_PORT);
			
			TServer.Args args = new TServer.Args(transport);
			args.processor(processor);
			args.protocolFactory(new TBinaryProtocol.Factory());
			TServer server = new TSimpleServer(args);
			server.serve();
			
		} catch (TTransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) throws Exception{
		
		HelloServer server = new HelloServer();
		server.startServer();
	}

}
