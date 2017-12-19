<%@ page pageEncoding="UTF-8" isErrorPage="false" errorPage="../../error.jsp"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>首页</title>   
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/site.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style type="text/css">
    html, body {
        height: 100%;
    }
    </style>
  </head>
  <body>
    <%-- <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="#">${currentUserName}</a>
          <div class="btn-group pull-right">
            <a class="btn" href="${pageContext.request.contextPath}/JSP/OrdinaryUser/my-profile.jsp"><i class="icon-user"></i> ${currentUserName}</a>
            <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
              <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
              <li><a href="${pageContext.request.contextPath}/JSP/OrdinaryUser/my-profile.jsp">个人资料</a></li>
              <li class="divider"></li>
              <li><a href="${pageContext.request.contextPath}/ExitServlet">退出</a></li>
            </ul>
          </div>
          <div class="nav-collapse">
            <ul class="nav">
            <li><a href="${pageContext.request.contextPath}/JSP/OrdinaryUser/nav.jsp">首页</a></li>
              <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">员工 <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="#"data-toggle="modal" data-target="#NEWModal" data-whatever="new" >新建员工</a></li>
                    <li class="divider"></li>
                    <li><a href="${pageContext.request.contextPath}/JSP/Administrators/employees.jsp">管理员工</a></li>
                </ul>
              </li>
              <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">用户 <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="#"data-toggle="modal" data-target="#NEWModal" data-whatever="new">新建用户</a></li>
                    <li class="divider"></li>
                    <li><a href="${pageContext.request.contextPath}/JSP/Administrators/user.jsp">管理用户</a></li>
                </ul>
              </li>
        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">设施 <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath}/JSP/Administrators/studio.jsp">演出厅管理</a></li>
                    <li class="divider"></li>
                    <li><a href="${pageContext.request.contextPath}/JSP/Administrators/seat.jsp">座位管理</a></li>
                </ul>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div> --%>
 <h2 style="margin-left:380px;color:blue; font-size:45px;margin-top:-30px; line-height:50px;">欢迎进入剧院票务管理系统</h2>
    <div class="container-fluid">
      <div class="row-fluid">
      
        <div class="span3">
        
          <div class="well sidebar-nav">
            <ul class="nav nav-list">
             <li ><a href="${pageContext.request.contextPath}/JSP/Admin/studio.jsp"><h3 style="line-height:50px;">
             演出厅管理</h3></a></li>
              <li><a href="${pageContext.request.contextPath}/JSP/Admin/seat.jsp"><h3 style="line-height:50px;" >
              座位管理</h3></a></li>
              <li ><a href="${pageContext.request.contextPath}/JSP/Admin/employees.jsp"><h3
              style="line-height:50px;">员工管理</h3></a></li>
              <li><a href="${pageContext.request.contextPath}/JSP/Admin/user.jsp"><h3 style="line-height:50px;"
              >用户管理</h3></a></li>
             
              <li><a href="${pageContext.request.contextPath}/ExitServlet"><h3 style="line-height:50px;">退出登录</h3></a></li> 
            </ul>
          </div>
        </div>
</body>
</html>