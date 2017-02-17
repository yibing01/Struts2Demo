package com.belstar.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

/**
* @author yibing 
* @E-mail:yibingzn@qq.com
* @version ����ʱ�䣺2017��2��17�� ����10:54:14
* �����û���¼�����Action��
*/
public class LoginAction implements Action,ServletResponseAware{
	//�ṩ������������װHTTP�������
	private String username;
	private String password;
	//��װ��������ʾ��Tip����
	private String tip;
	private HttpServletResponse response;
	//�������Ե�getter��setter
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
	//Action�ദ���û������Ĭ�Ϸ�����execute
	public String execute() {
		ActionContext context = ActionContext.getContext();
		//ͨ��ActionContext����application��Χ�ڵ�����ֵ
		Integer counter = (Integer) context.getApplication().get("counter");
		if (counter == null) {
			counter = 1;
		}else {
			counter = counter + 1;
		}
		//ͨ��ApplicationContext������application��Χ�ڵ�����
		context.getApplication().put("counter", counter);
		//ͨ��ApplicationContext������session��Χ�ڵ�����
		context.getSession().put("username", username);
		if (username.equals("qwe") && password.equals("123")) {
			//ͨ��response���cookie
			Cookie cookie = new Cookie("username", username);
			cookie.setMaxAge(60 * 60);
			response.addCookie(cookie);
			//ͨ��ApplicationContext����request��Χ�ڵ�����
			context.put("tip", "��������ʾ�����ѳɹ���¼");
			return SUCCESS;
		}else {
			//ͨ��ApplicationContext����request��Χ�ڵ�����
			context.put("tip", "��������ʾ����¼ʧ��");
			return ERROR;
		}
	}
	//Action �е�ע������߼�
	public String regist(){
		ActionContext.getContext().getSession().put("username",username);
		setTip("��ϲ��"+ username +"�ѳɹ�ע��");
		return SUCCESS;
	}
	
}
