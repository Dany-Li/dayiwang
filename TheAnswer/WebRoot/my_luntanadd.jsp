<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();

%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="Assets/css/reset.css"/>
<link rel="stylesheet" type="text/css" href="Assets/css/common.css"/>
<link rel="stylesheet" type="text/css" href="Assets/css/thems.css">
<script type="text/javascript" src="Assets/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" language="javascript">

function checkform(){
	
	
	if(document.getElementById("fenleiid").value==""){
		
		alert('版块不能为空');
		return false;
	}
	
	if(document.getElementById("biaotiid").value==""){
		
		alert('主题不能为空');
		return false;
	}
	
	if(document.getElementById("contentid").value==""){
		
		alert('主题简介不能为空');
		return false;
	}

	
	return true;

}


</script>

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
        	<span>发帖信息</span>
        </div>
        <div class="main_r clearfix">
        	<div class="book_m">
        	<form action="indexmethod!my_luntanadd2" method="post"  onsubmit="return checkform()">
            <input type="hidden" name="id" value="${bean.id }"/>
            <ul class="booking">
            	
                 
                <li>
                	<span>版块：</span>
                    <select style="width:200px"  name="fenlei" id="fenleiid"> 
                     <option value="">--请选择--</option>
                     <c:forEach items="${list}" var="bean2">
                     <option value="${bean2.id }">${bean2.name}</option>
                     </c:forEach>
                   </select>
                </li>
                
                  
                <li>
                	<span>主题：</span>
                    <input name="biaoti" id="biaotiid" class="duan">
                </li>
                
                
                 <li>
                	<span>主题简介：</span>
                    <textarea name="content" id="contentid" cols="" rows=""></textarea>
                </li>
                
               
                

                
                <li>
                <input style="width:80px; height:20px;" type="submit" name="submit"  value="保存"  />&nbsp;&nbsp;&nbsp;
                <input style="width:80px; height:20px;" onclick="javascript:history.go(-1);"  type="button" value="返回"/>  
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
<jsp:include page="down.jsp"></jsp:include>
<!--底部-->
</body>
</html>
