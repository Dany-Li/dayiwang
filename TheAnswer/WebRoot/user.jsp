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
<jsp:include page="top.jsp"></jsp:include>
<!--头部-->

<div class="main">
<!--产品展示-->
<div class="pro_list clearfix">
	<jsp:include page="left.jsp"></jsp:include>
    <div class="pro_m">
    	<div class="box_h">
        	<span>个人信息</span>
        </div>
        <div class="main_r clearfix">
        	<div class="book_m">
        	
            <ul class="booking">
            	
                
                <li>
                	<span>用户名：</span>
                                                      张三
                    <i>*</i>
                </li>
                 <li>
                	<span>等&nbsp;&nbsp;&nbsp;&nbsp;级：</span>
                    VIP2
                    <i>*</i>
                </li>
                <li class="sex">
                	<span>性&nbsp;&nbsp;&nbsp;&nbsp;别：</span>
                                                  男
                </li>
               
                <li>
                	<span>地&nbsp;&nbsp;&nbsp;&nbsp;址：</span>
                                                 上海
                    <i>*</i>
                </li>
                <li>
                	<span>籍&nbsp;&nbsp;&nbsp;&nbsp;贯：</span>
                                                   上海
                    <i>*</i>
                </li>
                <li>
                	<span>电&nbsp;&nbsp;&nbsp;&nbsp;话：</span>
                    12345678901
                </li>
                
                
                <li>
                	<span>邮&nbsp;&nbsp;&nbsp;&nbsp;箱：</span>
                    11@QQ.COM
                    <i>*</i>
                </li>
                
               
            </ul>
        </div>
        </div>
    </div>
</div>
<!--产品展示-->
</div>
<!--底部-->
<jsp:include page="down.jsp"></jsp:include>
<!--底部-->
</body>
</html>
