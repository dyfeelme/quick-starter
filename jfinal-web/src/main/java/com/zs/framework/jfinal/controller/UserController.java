package com.zs.framework.jfinal.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

public class UserController extends Controller{
	
	@ActionKey("/login")
	public void login(){
		render("login.html");
	}

}
