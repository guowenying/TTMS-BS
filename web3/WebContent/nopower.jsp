<%-- <%@ page pageEncoding="UTF-8" isErrorPage="false" errorPage="error.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0043)http://hi.baidu.com/com/error/?from=oldblog -->
<HTML><HEAD><TITLE>无权限页面</TITLE><!--STATUS OK-->
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<meta name="copyright" content="Copyright   ">
<script language="javascript" type="text/javascript">
window.wpo={start:new Date*1,pid:109,page:'qing'}
var i = 5;
var intervalid;
intervalid = setInterval("fun()", 1000);
function fun() {
if (i == 0) {
javascript:history.go(-1);
clearInterval(intervalid);
}
document.getElementById("mes").innerHTML = i;
i--;
}
</script>
<!--[if IE]>
<SCRIPT type=text/javascript>(function(){var a="abbr,article,aside,audio,canvas,datalist,details,dialog,eventsource,figure,footer,header,hgroup,mark,menu,meter,nav,output,progress,section,time,video".split(","),b=a.length;while(b--)document.createElement(a[b])})();</SCRIPT>
<![endif]-->
<!--[if (lt IE 8.0)]><LINK href="files/qbase.css" type=text/css 
rel=stylesheet><![endif]--><!--[if (!IE)|(gte IE 8.0)]><!--><link href="${pageContext.request.contextPath}/js/files/qbase_datauri.css" type=text/css rel=stylesheet><!--<![endif]-->
<STYLE type=text/css>.mod-notfound {
	BORDER-RIGHT: #e1e1e1 1px solid; BORDER-TOP: #e1e1e1 1px solid; MARGIN-TOP: 10px; BACKGROUND: #fff; BORDER-LEFT: #e1e1e1 1px solid; BORDER-BOTTOM: #e1e1e1 1px solid; HEIGHT: 585px; TEXT-ALIGN: center; border-radius: 10px
}
</STYLE>

<META content="MSHTML 6.00.6000.17117" name=GENERATOR></HEAD>
<BODY><SECTION class=mod-page-body>
<DIV class="mod-page-main wordwrap clearfix">
<DIV class=x-page-container>
<DIV class="mod-notfound grid-98"><IMG class=img-notfound height=320 
src="${pageContext.request.contextPath}/js/files/timg.jpg" width=520>
<P style="FONT-SIZE: 24px; LINE-HEIGHT: 70px">啊~哦~ 您无权限访问该页面！</P>
<P style="MARGIN-BOTTOM: 30px">${desc}</P>
<P style="FONT-SIZE: 14px; LINE-HEIGHT: 20px">您可以回到 <A 
href="${pageContext.request.contextPath}/index.jsp">网站首页</A> 或者<span ID="mes"> </span>秒后<a href="#" onclick="javascript:history.go(-1);">返回上一页</a></DIV></DIV></DIV></SECTION><FOOTER 
class="mod-footer mod-cs-footer">
<DIV class="clearfix hidden-box"></DIV>
<DIV class=footer-box>
 
<DIV class=copy-box>Copyright &copy;2017-2018 星空影院管理系统 All Rights Reserved</DIV></DIV></FOOTER>

</BODY></HTML>
 --%>
 <%-- <%@ page pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0043)http://hi.baidu.com/com/error/?from=oldblog -->
<HTML><HEAD><TITLE>错误页面</TITLE><!--STATUS OK-->
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<meta name="copyright" content="Copyright   ">
<script language="javascript" type="text/javascript">
window.wpo={start:new Date*1,pid:109,page:'qing'}
var i = 5;
var intervalid;
intervalid = setInterval("fun()", 1000);
function fun() {
if (i == 0) {
javascript:history.go(-1);
clearInterval(intervalid);
}
document.getElementById("mes").innerHTML = i;
i--;
}
</script>
<!--[if IE]>
<SCRIPT type=text/javascript>(function(){var a="abbr,article,aside,audio,canvas,datalist,details,dialog,eventsource,figure,footer,header,hgroup,mark,menu,meter,nav,output,progress,section,time,video".split(","),b=a.length;while(b--)document.createElement(a[b])})();</SCRIPT>
<![endif]-->
<!--[if (lt IE 8.0)]><LINK href="files/qbase.css" type=text/css 
rel=stylesheet><![endif]--><!--[if (!IE)|(gte IE 8.0)]><!--><link href="${pageContext.request.contextPath}/js/files/qbase_datauri.css" type=text/css rel=stylesheet><!--<![endif]-->
<STYLE type=text/css>.mod-notfound {
    BORDER-RIGHT: #e1e1e1 1px solid; BORDER-TOP: #e1e1e1 1px solid; MARGIN-TOP: 10px; BACKGROUND: #fff; BORDER-LEFT: #e1e1e1 1px solid; BORDER-BOTTOM: #e1e1e1 1px solid; HEIGHT: 585px; TEXT-ALIGN: center; border-radius: 10px
}
</STYLE>

<META content="MSHTML 6.00.6000.17117" name=GENERATOR></HEAD>
<BODY><SECTION class=mod-page-body>
<DIV class="mod-page-main wordwrap clearfix">
<DIV class=x-page-container>
<DIV class="mod-notfound grid-98"><IMG class=img-notfound height=320 
src="${pageContext.request.contextPath}/js/files/notfound.gif" width=520>
<P style="FONT-SIZE: 24px; LINE-HEIGHT: 70px">啊~哦~ 您要查看的页面不存在或已删除！</P>
<P style="MARGIN-BOTTOM: 30px">${desc}</P>
<P style="FONT-SIZE: 14px; LINE-HEIGHT: 20px">您可以回到 <A 
href="${pageContext.request.contextPath}/index.jsp">网站首页</A> 或者<span ID="mes"> </span>秒后<a href="#" onclick="javascript:history.go(-1);">返回上一页</a></DIV></DIV></DIV></SECTION><FOOTER 
class="mod-footer mod-cs-footer">
<DIV class="clearfix hidden-box"></DIV>
<DIV class=footer-box>
 
<DIV class=copy-box>Copyright &copy;2017-2018 星空影院管理系统 All Rights Reserved</DIV></DIV></FOOTER>

</BODY></HTML> --%>
<%@ page pageEncoding="UTF-8" isErrorPage="true"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <style type="text/css">
        body {font-size:30px}
        input {font-size:30px}
        div {color:red;text-align:center}
    </style>
  </head>
<body>
<br>
<div>出错了!</div>
<div>你的网络有问题，或者操作有问题，反正我们没问题。</div>
<br>
<div>${desc}</div>
<div><a href="index.jsp">回首页</a></div>
</body>
</html>
 