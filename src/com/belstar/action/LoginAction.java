package com.belstar.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

/**
* @author yibing 
* @E-mail:yibingzn@qq.com
* @version 创建时间：2017年2月17日 上午10:54:14
* 处理用户登录请求的Action类
*/
public class LoginAction implements Action,ServletResponseAware{
	//提供两个属性来封装HTTP请求参数
	private String username;
	private String password;
	//封装服务器提示的Tip属性
	private String tip;
	private HttpServletResponse response;
	//设置属性的getter和setter
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	//Action类处理用户请求的默认方法：execute
	public String execute() {
		ActionContext context = ActionContext.getContext();
		//通过ActionContext访问application范围内的属性值
		Integer counter = (Integer) context.getApplication().get("counter");
		if (counter == null) {
			counter = 1;
		}else {
			counter = counter + 1;
		}
		//通过ApplicationContext来设置application范围内的属性
		context.getApplication().put("counter", counter);
		//通过ApplicationContext来设置session范围内的属性
		context.getSession().put("username", username);
		if (username.equals("qwe") && password.equals("123")) {
			//通过response添加cookie
			Cookie cookie = new Cookie("username", username);
			cookie.setMaxAge(60 * 60);
			response.addCookie(cookie);
			//通过ApplicationContext设置request范围内的属性
			context.put("tip", "服务器提示：您已成功登录");
			return SUCCESS;
		}else {
			//通过ApplicationContext设置request范围内的属性
			context.put("tip", "服务器提示：登录失败");
			return ERROR;
		}
	}
	//Action 中的注册控制逻辑
	public String regist(){
		ActionContext.getContext().getSession().put("username",username);
		setTip("恭喜您"+ username +"已成功注册");
		return SUCCESS;
	}
	
}
