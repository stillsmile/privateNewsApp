package com.etc.action;

import com.etc.domain.User;

public class LoginAction {

	private String account;
	
	private Integer type;
	
	private String password;
	
	@SuppressWarnings("unused")
	public String execute() {
		
		System.out.println("account = " + account);
		System.out.println("password = " + password);
		System.out.println("type = " + type);
		
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		user.setType(type);
		//创建系统数据层对象
		
		//查询用户是否存在
		//User loginUser = service.getAdmin(user);
		User loginUser = null;
		if(loginUser == null){//如果用户名或密码错误
			return "loginError";
		} else{ //正确
			if(User.USER_ADMIN == type){
				return "admin";
			} else if(User.USER_STUDENT == type){
				return "student";
			} else if(User.USER_TEACHER == type){
				return "teacher";
			}
		}
		return "success";
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
}
