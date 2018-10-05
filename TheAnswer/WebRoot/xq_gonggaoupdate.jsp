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
<jsp:include page="top.jsp"></jsp:include>
<!--头部-->

<div class="main">
<!--产品展示-->
<div class="pro_list clearfix">
	<jsp:include page="left.jsp"></jsp:include>
    <div class="pro_m">
    	<div class="box_h">
        	<span>帮助中心详情</span>
        </div>
        <div class="pro_md">
        	<h1>${bean.biaoti }</h1>
            <div class="time">
                <span>${fn:substring(bean.createtime,0, 19)}</span>
            </div>
            <div class="ctn">
            	<p>
            	${bean.content }
            	</p>
            </div>
            <div class="space_hx">&nbsp;</div>
            <!--导向页-->
            <div class="page_dx">
            	<p>
                	
                    <span><a href="javascript:history.go(-1);" >返回上页</a></span>
                </p>
                
            </div>
            <!--导向页-->
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
