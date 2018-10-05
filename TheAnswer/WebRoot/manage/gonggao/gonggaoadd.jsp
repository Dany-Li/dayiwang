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
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="scripts/jquery/jquery-1.7.1.js"></script>
<link href="style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="style/authority/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="scripts/authority/commonAll.js"></script>
<script type="text/javascript" src="scripts/jquery/jquery-1.4.4.min.js"></script>
<script src="scripts/My97DatePicker/WdatePicker.js" type="text/javascript" defer="defer"></script>
<script type="text/javascript" src="scripts/artDialog/artDialog.js?skin=default"></script>
<script language="javascript" type="text/javascript">
function checkform()
{
	if (document.getElementById('biaotiid').value=="")
	{
		alert("标题不能为空");
		return false;
	}	
	if (document.getElementById('contentid').value=="")
	{
		alert("内容不能为空");
		return false;
	}	
	
	return true;
}
</script>
</head>
<body>
     <form action="method!gonggaoadd2" method="post" onsubmit="return checkform()">
	<input type="hidden" name="fyID" value="14458625716623" id="fyID"/>
	<div id="container">
		
		<div class="ui_content">
			<table  cellspacing="0" cellpadding="0" width="100%" align="left" border="0">

				<tr>
					<td class="ui_text_rt">标题:</td>
					<td class="ui_text_lt">
						<input  type="text" name="biaoti"  id='biaotiid' class="ui_input_txt02"/>
					</td>
				</tr>
				
				
				<tr>
					<td class="ui_text_rt">内容:</td>
					<td class="ui_text_lt">
						 <textarea rows="7" cols="50"  name="content"  id="contentid" ></textarea>
					</td>
				</tr>
				
				
				
				
				<tr>
					<td>&nbsp;</td>
					<td class="ui_text_lt">
						&nbsp;<input type="submit" value="提交" class="ui_input_btn01"/>
						&nbsp;<input onclick="javascript:history.go(-1);" type="button" value="返回" class="ui_input_btn01"/>
					</td>
				</tr>
			</table>
		</div>
	</div>
</form>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>