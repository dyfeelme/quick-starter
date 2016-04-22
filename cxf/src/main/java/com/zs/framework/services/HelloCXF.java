package com.zs.framework.services;

import javax.jws.WebService;

@WebService
public interface HelloCXF {

	public String sayHello(String name);
}
