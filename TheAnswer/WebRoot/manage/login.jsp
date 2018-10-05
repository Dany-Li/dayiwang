<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<!-- Custom Theme files -->
<link href="css/style2.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 

</head>
<body>
<!--header start here-->
<div class="login-form">
			<div class="top-login">
				<span><img src="images/group.png" alt=""/></span>
			</div>
			<h1>后台登录</h1>
			<div class="login-top">
			<form  method="post"  action="method!login" >
				<div class="login-ic">
					<i ></i>
					<input type="text"   name="username"/>
					<div class="clear"> </div>
				</div>
				<div class="login-ic">
					<i class="icon"></i>
					<input type="password"   name="password"/>
					<div class="clear"> </div>
				</div>
			
				<div class="log-bwn">
					<input type="submit"  value="登陆" >
				</div>
				</form>
			
			</div>
			
</div>		
<!--header start here-->
</body>
</html>