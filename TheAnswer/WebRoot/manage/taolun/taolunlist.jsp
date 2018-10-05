<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/uploadfile/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="scripts/jquery/jquery-1.7.1.js"></script>
<link href="style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="style/authority/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="scripts/authority/commonAll.js"></script>
<script type="text/javascript" src="scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" type="text/css" href="style/authority/jquery.fancybox-1.3.4.css" media="screen"></link>
<script type="text/javascript" src="scripts/artDialog/artDialog.js?skin=default"></script>
<title></title>
<style>
	.alt td{ background:black !important;}
</style>
</head>
<body>
		<input type="hidden" name="allIDCheck" value="" id="allIDCheck"/>
		<input type="hidden" name="fangyuanEntity.fyXqName" value="" id="fyXqName"/>
		<div id="container">
			<div class="ui_content">
				<div class="ui_text_indent">
					<div id="box_border">
					<form action="method!taolunlist"  method="post">
						<div id="box_center">		
								版块：&nbsp;&nbsp;<input  name="name" type="text"  value="${name }" class="ui_input_txt02" />
							帖子主题：&nbsp;&nbsp;<input  name="biaoti" type="text"  value="${biaoti }" class="ui_input_txt02" />
						<input type="submit" value="查询" class="ui_input_btn01" onclick="search();" /> 
						</div>
						
						</form>
					</div>
				</div>
			</div>
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							
							<th>版块</th>
							<th>帖子主题</th>
							<th>回帖教师</th>
							<th>答疑内容</th>
							<th>信息状态</th>
							<th>添加时间</th>
							<th>操作</th>
							
							
						</tr>
						<c:forEach items="${list}"  var="bean">
							<tr>
							    <td>${bean.luntan.fenlei.name }</td>
								<td>${bean.luntan.biaoti }</td>
								<td>${bean.user.username }</td>
								<td>${bean.content }</td>
								<td>
								<c:if test="${bean.stauts==1}"><span style="color: red">不可见</span></c:if>
								<c:if test="${bean.stauts==0}">可见</c:if>
								<c:if test="${bean.goods==1}"><font color="green">【最佳答案】</font></c:if>
								</td>
								<td>${fn:substring(bean.createtime,0, 19)}</td>
								
								<td>
								<c:if test="${bean.goods==0}"><!-- 未评 -->
								<c:if test="${bean.stauts==0}">
                                  <a href="method!kejian?id=${bean.id }" onclick=" return confirm('确定要不可见吗?');">【不可见】</a> &nbsp; &nbsp; &nbsp;
                                 </c:if>
                                <c:if test="${bean.stauts==1}">
                                   <a href="method!kejian2?id=${bean.id }" onclick=" return confirm('确定要可见吗?');">【可见】</a> &nbsp; &nbsp; &nbsp;
                                 </c:if>
                                  </c:if>
                                 <a href="method!taolundelete?id=${bean.id }"  onclick=" return confirm('确定要删除吗?');">删除</a>
								</td>
							</tr>
						</c:forEach>


					</table>
				</div>
				<div class="ui_tb_h30">
					<div class="ui_flt" style="height: 30px; line-height: 30px;">
						${pagerinfo }
					</div>
					
				</div>
			</div>
		</div>
	</form>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
