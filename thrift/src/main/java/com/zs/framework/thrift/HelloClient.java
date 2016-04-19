package com.zs.framework.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class HelloClient {
	
	private static final String SERVER_IP = "localhost";
	private static final int SERVER_PORT = 8090;
	private static final int TIMEOUT = 30000;
	
	private void startClient(String username){
		TTransport transport = null;
		transport = new TSocket(SERVER_IP,SERVER_PORT,TIMEOUT);
		
		TProtocol prot = new TBinaryProtocol(transport);
		HelloService.Client client = new HelloService.Client(prot);
		try {
			transport.open();
			String result = client.sayName(username);
		} catch (TTransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null != transport)
				transport.close();
		}
	}
	
	public static void main(String[] args) {
		
		HelloClient client = new HelloClient();
		client.startClient("Thrift");
		
	}

}
