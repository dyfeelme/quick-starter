package com.zs.framework.dubbox;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("users")
public class UserServiceImpl implements UserService {

	@POST
	@Path("registry")
	@Consumes({MediaType.APPLICATION_JSON})
	public void registryUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("Save User");
	}

}
