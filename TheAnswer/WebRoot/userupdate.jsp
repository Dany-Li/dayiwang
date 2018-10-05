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


</head>
<body>
<!--头部-->
<!--头部-->

<div class="main">
<!--产品展示-->
<div class="pro_list clearfix">
    <div class="pro_m">
    	<div class="box_h">
        	<span>用户信息修改</span>
        </div>
        <div class="main_r clearfix">
        	<div class="book_m">
        	<form action="indexmethod!userupdate2" method="post" onsubmit="return checkform()">
        	<input type="hidden" name="id" value="${bean.id }"/>
            <ul class="booking">
            	
                <li>
                	<span>角&nbsp;&nbsp;&nbsp;&nbsp;色：</span>
                     <c:if test="${user.role==1}">学生</c:if><c:if test="${user.role==2}">教师</c:if>
                    <i>*</i>
                </li>
                <li>
                	<span>用户名：</span>
                    <input name="username" type="text" readonly id="usernameid" value="${bean.username }" class="duan">
                    <i>*</i>
                </li>
                 <li>
                	<span>姓&nbsp;&nbsp;&nbsp;&nbsp;名：</span>
                    <input name="truename" id="truenameid" type="text" value="${bean.truename }" class="duan">
                    <i>*</i>
                </li>
                 <li>
                	<span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
                    <input name="password" id="passwordid" type="password" value="${bean.password }" class="duan">
                    <i>*</i>
                </li>
                <li class="sex">
                	<span>性&nbsp;&nbsp;&nbsp;&nbsp;别：</span>
                    <input name="sex"  type="radio" <c:if test="${bean.sex=='男'}"> checked='checked'</c:if>><em>男</em>
                    <input name="sex" type="radio"  <c:if test="${bean.sex=='女'}"> checked='checked'</c:if>><em>女</em>
                </li>
               
                <li>
                	<span>院&nbsp;&nbsp;&nbsp;&nbsp;系：</span>
                    <input name="yuanxi" id="yuanxiid" value="${bean.yuanxi }" type="text" class="duan">
                    <i>*</i>
                </li>
                 <li>
                	<span>电&nbsp;&nbsp;&nbsp;&nbsp;话：</span>
                    <input name="phone" id="phoneid" value="${bean.phone }" type="text" class="duan">
                </li>
                  <li>
                	<span>邮&nbsp;&nbsp;&nbsp;&nbsp;箱：</span>
                    <input name="email" id="emailid" value="${bean.email }" type="text" class="duan">
                    <i>*</i>
                </li>
                

                
                <li>
                <input style="width:80px; height:20px;" type="submit" name="submit"  value="保存"  />&nbsp;&nbsp;&nbsp;
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
