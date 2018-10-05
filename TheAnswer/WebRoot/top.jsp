<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="Assets/css/reset.css"/>
<link rel="stylesheet" type="text/css" href="Assets/css/common.css"/>
<link rel="stylesheet" type="text/css" href="Assets/css/thems.css">
<script type="text/javascript" src="Assets/js/jquery-1.8.3.min.js"></script>

</head>
<body>
<!--头部-->
<div class="head_bg">
	<div class="header clearfix">
        		<span style="font-size: 35px;font-weight: bold;color: blue; margin-left:0%;">
课程答疑网
    </span>
    </div>
</div>
<!--头部-->
<!--导航条-->
<div class="nav_bg">
	<ul class="nav clearfix">
    	<li><a href="./">首页</a></li>
    	
       
        <c:if test="${user.role==1}">
        <li class="line">&nbsp;</li>
         <li><a href="indexmethod!my_luntanlist">我的发帖</a></li>

        </c:if>
      
         
         
        <li class="line">&nbsp;</li>
          <li><a href="indexmethod!sy_gonggaolist">帮助中心</a></li>
       
    </ul>
</div>
<!--导航条-->


</body>
</html>
