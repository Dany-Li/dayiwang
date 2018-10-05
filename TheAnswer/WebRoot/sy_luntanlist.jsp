<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
%>
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
        	<span>版块</span>
        		 <input type="hidden" name="id" value="${bean.id }"/>
        </div>
        <div class="pro_md">
        	<h1>${fenlei }版块</h1>
           
         	
            
              <c:forEach items="${list}" var="bean2">
    	<ul class="text_list">
        <li>
        <span>
        <a href="indexmethod!sy_taolunlist?id=${bean2.id }">【进入】</a>
        </span>
                     <span> 主题：${bean2.biaoti } </span>
                      <span> 发布用户：${bean2.user.username } </span>
                     发布时间：${fn:substring(bean2.createtime,0, 10)} 
        </li>
      </ul>
      </c:forEach> 	
           
            
            <!--导向页-->
             <div class="space_hx">&nbsp;</div>
        <!--分页导航-->
          <div class="pclady_page">
            ${pagerinfo }
             
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
