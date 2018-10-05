<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="Assets/css/reset.css"/>
<link rel="stylesheet" type="text/css" href="Assets/css/common.css"/>
<link rel="stylesheet" type="text/css" href="Assets/css/thems.css">
<script type="text/javascript" src="Assets/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" language="javascript">

function checkform(){
	if(document.getElementById("usernameid").value==""){
		
		alert('用户名不能为空');
		return false;
	}
	
	var valid = /^\w+$/;
	if(!valid.test(document.getElementById("usernameid").value)){
		alert('用户名必须是数字，字母或者下划线');
		return false;
		
	}
	
	if(document.getElementById("passwordid").value==""){
		
		alert('密码不能为空');
		return false;
	}
	
	if(document.getElementById("passwordid").value.length<6){
		
		alert('密码长度必须大于6位');
		return false;
	}
	
	
	
	if(document.getElementById("truenameid").value==""){
		
		alert('姓名不能为空');
		return false;
	}
	
	
	
	
	if(document.getElementById("phoneid").value==""){
		
		alert('手机不能为空');
		return false;
	}
	
	valid = /^0?1[3,5,8,7][0,1,2,3,4,5,6,7,8,9]\d{8}$/;
	
	if(!valid.test(document.getElementById("phoneid").value)){
		
		alert('请输入正确的手机格式');
		return false;
	}
	
	if(document.getElementById("emailid").value==""){
		alert('email不能为空');
		return false;
	}
	
	var reg = new RegExp('^[a-zA-Z0-9]+@[a-zA-Z0-9]+.[a-z][a-z.]{2,8}$');
	
	if(!reg.test(document.getElementById("emailid").value)){
		
		alert('请输入正确的邮箱地址');
		return false;
	}
	
	
	
	return true;

}


</script>

</head>
<body>
<!--头部-->
<!--头部-->

<div class="main">
<!--产品展示-->
<div class="pro_list clearfix">
    <div class="pro_m">
    	<div class="box_h">
        	<span>用户注册</span>
        </div>
        <div >
        	<div class="book_m">
        	<form action="indexmethod!register" method="post" onsubmit="return checkform()">
            <ul class="booking">
            	
                 <li class="sex">
                	<span>角&nbsp;&nbsp;&nbsp;&nbsp;色：</span>
                    <input name="role" checked type="radio" value="1"><em>学生</em>
                    <input name="role" type="radio" value="2"><em>教师</em>
                </li>
                <li>
                	<span>用户名：</span>
                    <input name="username" type="text" id="usernameid" class="duan">
                    <i>*</i>
                </li>
                 <li>
                	<span>姓&nbsp;&nbsp;&nbsp;&nbsp;名：</span>
                    <input name="truename" id="truenameid" type="text" class="duan">
                    <i>*</i>
                </li>
                 <li>
                	<span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
                    <input name="password" id="passwordid" type="password" class="duan">
                    <i>*</i>
                </li>
                <li class="sex">
                	<span>性&nbsp;&nbsp;&nbsp;&nbsp;别：</span>
                    <input name="sex" checked type="radio" value="男"><em>男</em>
                    <input name="sex" type="radio" value="女"><em>女</em>
                </li>
               
                <li>
                	<span>院&nbsp;&nbsp;&nbsp;&nbsp;系：</span>
                    <input name="yuanxi" id="yuanxiid" type="text" class="duan">
                    <i>*</i>
                </li>
                 <li>
                	<span>电&nbsp;&nbsp;&nbsp;&nbsp;话：</span>
                    <input name="phone" id="phoneid" type="text" class="duan">
                </li>
                  <li>
                	<span>邮&nbsp;&nbsp;&nbsp;&nbsp;箱：</span>
                    <input name="email" id="emailid" type="text" class="duan">
                    <i>*</i>
                </li>
               

                
                <li>
                <input style="width:80px; height:20px;" type="submit" name="submit"  value="保存"  />&nbsp;&nbsp;&nbsp;
                <input style="width:80px; height:20px;" type="reset" name="reset"  value="重置"  />  
               </li>
            </ul>
            </form>
        </div>
        </div>
    </div>
</div>
<!--产品展示-->
</div>
<!--底部-->
<!--底部-->
</body>
</html>
