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
        	<span>帮助中心</span>
        </div>
        <div class="main_r">
            <div class="news_list">
                <ul>
                 <c:forEach items="${list}" var="bean">
                    <li>
                        <span><a href="indexmethod!xq_gonggaoupdate?id=${bean.id }"> ${bean.biaoti }</a></span>
                        <em> ${fn:substring(bean.createtime,0, 11)}</em>
                    </li>
                    </c:forEach>
                    
                </ul>
                <div class="space_hx">&nbsp;</div>
        <!--分页导航-->
          <div class="pclady_page">
            ${pagerinfo }
             
           </div>
                  <!--分页导航-->
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
