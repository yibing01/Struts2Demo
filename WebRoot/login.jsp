<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><s:text name="登录处理"/></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
  	function register(){
  		//获取页面的第一个表单
  		targetForm = document.forms[0];
  		//动态修改表单的action属性
  		targetForm.action = "login!regist"
  	}
  </script>
  <body>
    <s:form action="login">
    	<s:textfield name="username" key="username"></s:textfield>
    	<s:textfield name="password" key="password"></s:textfield>
    	<s:submit key="login"></s:submit>
    	<input type="submit" value="注册" onclick="">
    </s:form>
  </body>
</html>
