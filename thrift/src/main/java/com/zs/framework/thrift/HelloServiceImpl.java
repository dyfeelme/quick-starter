package com.zs.framework.thrift;

import org.apache.thrift.TException;

public class HelloServiceImpl implements HelloService.Iface{

	public String sayName(String name) throws TException {
		// TODO Auto-generated method stub
		return "Hi,my name is "+name;
	}

	public int sayAge(int age) throws TException {
		// TODO Auto-generated method stub
		return age;
	}

	public boolean isHappy(boolean happy) throws TException {
		// TODO Auto-generated method stub
		return happy;
	}

	public void sayVoid() throws TException {
		// TODO Auto-generated method stub
		System.out.println("Here is void method !");
	}

	public String sayNull() throws TException {
		// TODO Auto-generated method stub
		return null;
	}

}
