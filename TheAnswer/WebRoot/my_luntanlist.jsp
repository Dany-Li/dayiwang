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
        	<span>我的发帖</span>
        </div>
        <div class="main_r clearfix">
        	<div class="book_m">
        	<a href="indexmethod!my_luntanadd"><span style="color: red">【发帖】</span></a> &nbsp;
            	<ul class="book_list">
                	<li class="wen clearfix">
                    	<div  style="float:left;width:30%" class="w_left">	
                                                                版块
                        </div>
                        <div  style="float:left;width:30%" class="w_left">	
                                                                  主题
                        </div>
                         <div class="w_left">	
                                                                  发表用户
                        </div>
                      
                         <div class="w_left">	
                                                                   操作
                        </div>
                        
                        
                         <c:forEach items="${list}" var="bean">
                         <div  style="float:left;width:30%" class="w_left">	
                         ${bean.fenlei.name }
                        </div>
                         <div  style="float:left;width:30%" class="w_left">	
                         ${bean.biaoti }
                        </div>
                          <div class="w_left">	
                          ${bean.user.username}
                        </div>
                        
                         <div class="w_left">	
                          <h3>
                          <a href="indexmethod!sy_taolunlist?id=${bean.id}">【进入】</a>&nbsp; &nbsp;
                          <a href="indexmethod!my_luntandelete?id=${bean.id}" onclick=" return confirm('确定要删除吗?'); "><span style="color: black">删除</span></a>
                          </h3>
                        </div>
                        </c:forEach>
                    </li>
                    
                    
                    
                    
                
                    
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
