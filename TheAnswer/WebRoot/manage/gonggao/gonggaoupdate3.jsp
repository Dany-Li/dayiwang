<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="css/admin.css" type="text/css" rel="stylesheet">
<script language="javascript" type="text/javascript">

function checkform()
{
	 
	

	if (document.getElementById('biaotiid').value=="")
	{
		alert("标题不能为空");
		return false;
	}
	
	return true;
	
}


</script>

</HEAD>
<BODY>
<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
  <TR height=28>
    <TD background=images/title_bg1.jpg>当前位置:---》》${title }</TD></TR>
  <TR>
    <TD bgColor=#b1ceef height=1></TD></TR>
  <TR height=20>
    <TD background=images/shadow_bg.jpg></TD></TR></TABLE>
     <form action="${url }?id=${bean.id }" method="post" onsubmit="return checkform()">
<TABLE cellSpacing=0 cellPadding=0 width="60%" align=center border=1>
  	
  	<TR height=>
    <TD align="center" >标题:</TD>
    <TD align="center"> 
    <input  type="text" name="biaoti"  id='biaotiid'  size="30" value="${bean.biaoti }"  readonly="readonly"/>
 
    </TD>
    </TR>
    
    <TR height=>
    <TD align="center" >内容:</TD>
    <TD align="center"> 
    <textarea rows="7" cols="50"  name="content" readonly="readonly">${bean.content }</textarea>
 
    </TD>
    </TR>
    
    
    
    <TR height=>
    <TD align="center" > 操作：</TD>
    <TD align="center"> 

				<input  onclick="javascript:history.go(-1);" style="width: 60px" type="button" value="返回" />
    
    </TD>
    </TR>
    
    </TABLE>
    </form>
 </BODY></HTML>
