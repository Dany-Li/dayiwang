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
        	<span>回帖答疑</span>
        </div>
        <div class="main_r clearfix">
        	<div class="book_m">
        	<div class="book_a">
            	<span>主题：${bean2.biaoti}</span>
            	&nbsp;&nbsp;&nbsp;&nbsp;当前回复总数：${num}
                <p>&nbsp;&nbsp;&nbsp;&nbsp;${bean2.content }</p>
            </div>
            
            <ul class="book_list">
             <c:if test="${user==null}">
             <li class="hui">
             ***登录可见内容*** 	
             </li> 
             </c:if>  
                
           <c:if test="${user!=null}">
                   <c:forEach items="${list}" var="bean">
                     <li class="hui">
                    	<div class="w_left">
                        	<b>
                     	回帖教师：${bean.user.username}  <c:if test="${bean.goods==1}"><font color="green">【最佳答案】</font></c:if>     <br/>
                        	</b>
                            答疑内容：               <c:if test="${bean.stauts==0}">
                             ${bean.content }  
                              <c:if test="${user.id==bean.luntan.user.id}">
                              <c:if test="${bean2.goods==0}">
                              <input type="button" style="width:10%;height:3%;float:right" value="设为最佳答案"  onclick="location.href='indexmethod!goods?id=${bean.id}'" /> 
                              </c:if>
                               </c:if>
                                
                              <br/> 
                        	${fn:substring(bean.createtime,0, 16)}
                        </c:if>
                         <c:if test="${bean.stauts==1}">
                          <span style="color: red">  ***本条信息为不可见信息***</span>
                        </c:if>
                        
                    
                        
                        </div>
                       
                    </li>
                    </c:forEach>
                    </c:if>
                   
                </ul>
                 <div class="space_hx">&nbsp;</div>
        <!--分页导航-->
          <div class="pclady_page">
            ${pagerinfo }
           </div>
            
            
             <c:if test="${user.role==2}">
            <form action="indexmethod!sy_taolunadd2" method="post" onsubmit="return checkform()">
     <input type="hidden" name="id" value="${bean2.id }"/>
            <ul class="booking">
            	
                <li>
                	<span>回复内容：</span>
                    <textarea name="content" id="contentid" cols="" rows=""></textarea>
                    <i>*</i>
                </li>
               
                
                <li>
                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
                	<input type="submit" value="发送"/>&nbsp; &nbsp; 
                    <input type="button" onclick="location.href='indexmethod!sy_luntanlist'" value="返回"/>
                </li>
            </ul>
            
            </form>
            </c:if>
            
            
            
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
