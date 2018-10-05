<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="Assets/css/reset.css"/>
<link rel="stylesheet" type="text/css" href="Assets/css/common.css"/>
<link rel="stylesheet" type="text/css" href="Assets/css/thems.css">
<script type="text/javascript" src="Assets/js/jquery-1.8.3.min.js"></script>

</head>
<body>

  <%
org.springframework.web.context.WebApplicationContext app4 = org.springframework.web.context.support.WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
dao.FenleiDao fenleiDao = (dao.FenleiDao)app4.getBean("fenleiDao");
List<model.Fenlei> fenleilist = fenleiDao.selectBeanList(0,15," where deletestatus=0 ");
%>

<!--产品展示-->

	<div class="left_nav">
    	<div class="box_h">
        	<span>版块</span>
        </div>
        <ul class="lei">
          <%
        for(model.Fenlei bean:fenleilist){
        %>
        	<li><span><a href="indexmethod!sy_luntanlist?id=<%=bean.getId() %>"><%=bean.getName() %></a></span></li>
                <% 
        }
        %>
        </ul>
        <div class="space_hx">&nbsp;</div>
    	<!--联系我们-->
        <div class="contact">
            <div class="box_h">
                <span>用户登陆</span>
            </div>
            
             <c:if test="${user==null}">
         <form action="indexmethod!login" method="post" onsubmit="return checkform()" >
            <ul class="contact_m">
               
                <li><span>用户名：</span> <input name="username" type="text" class="duan"></li>
                <li><span>密码：</span><input name="password" type="password" class="duan"></li>
                <li><span>角色：</span>
                <input name="role" checked type="radio" value="1"><em>学生</em>
                 <input name="role" type="radio" value="2"><em>教师</em>
                </li>
                <li>
                <input style="width:80px; height:20px;" type="submit" name="submit"  value="登陆"  />&nbsp;&nbsp;&nbsp;
                <input style="width:80px; height:20px;" type="reset" name="reset"  value="重置"  />   
               </li>
               <li>   
               <span>
                 <a href="javascript:;" onClick="javascript:window.open('register.jsp','','width=760,height=560,left=490, top=150,toolbar=no, status=no, menubar=no, resizable=yes, scrollbars=yes');return false;">没有账号?点击注册</a>
               </span>
              </li>

            </ul>
            </form>   
             
        </c:if>
        
        <br/><br/>
        <!-- 登陆之后 -->
        <c:if test="${user!=null}">
        <input type="hidden" name="id" value="${bean.id }"/>
          <form action="indexmethod!loginout" method="post"  >
            <ul class="contact_m">
               
                <li><span>当前用户：</span>${user.username }</li>
                <li><span>当前角色：</span><c:if test="${user.role==1}">学生</c:if><c:if test="${user.role==2}">教师</c:if></li>
                <li>
                <input style="width:80px; height:20px;" type="submit" name="submit"  value="退出"  />
               </li>
               <li>   
                 <span>
                 <a href="javascript:;" onClick="javascript:window.open('indexmethod!userupdate?id=${bean.id }','','width=760,height=560,left=490, top=150,toolbar=no, status=no, menubar=no, resizable=yes, scrollbars=yes');return false;">个人信息修改</a>
               </span>
              </li>

            </ul>
            </form>   
             
        </c:if>
        
        
        </div>
        
        <!--联系我们-->
    </div>





</body>
</html>
