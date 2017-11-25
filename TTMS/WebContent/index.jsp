<%@ page pageEncoding="UTF-8" isErrorPage="false" errorPage="error.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <style type="text/css">
	    body {font-size:24pt}
	    input {font-size:24pt}
    </style>
      <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="client/css/common.css">
    <link rel="stylesheet" href="client/css/bootstrap.min.css">
    <style type="text/css">
        .log-in{
            width: 100%;
            margin: 0 auto;
            height: 618px;
            background: url("client/img/bg3.jpg") center center no-repeat;
            background-size: cover;
        }
        .log-in .form{
            border: 1px solid #5e5e5e;
            border-radius: 10px;
            width: 340px;
            height: 350px;
        }
        .log-in .footer{
            font-size: 12px;
            padding-top: 180px;
        }
    </style>
  </head>
 <body class="log-in">
    <header>
        <h1>&nbsp;&nbsp;欢迎来到剧院票务管理系统&nbsp;&nbsp;<small>(156工作室)</small></h1>
    </header>
    <div class="log row">
        <div class="col-md-3 col-md-push-8 form">
            <form  action="Login" method="post">
                <h2>登录</h2>
                <div class="form-group">
                    <label style="font-size: 15px;">用户名</label>
                    <input type="text" class="user form-control" id="exampleInputName2" name="name" placeholder="请输入用户名">
                </div>
                <div class="form-group">
                    <label style="font-size: 15px;">密码</label>
                    <input type="password" class="password form-control" name="pass" id="exampleInputEmail2" placeholder="请输入密码">
                </div>
                <div class="form-group">
                    <label class="remember"><input type="checkbox">&nbsp;&nbsp;记住密码</label>
                    <span style="color: #5e5e5e">(请不要在公共场合下勾选此项哦!)</span>
                </div>
                <div class="form-group"><p>登录不了?&nbsp;&nbsp;&nbsp;<a href="sign_up.html">注册</a> | <a href="forgot.html">忘记密码?</a></p></div>
                <div class="form-group">
                    <input type="submit" value="登录" class="btn btn-primary" ">
                </div>
            </form>
        </div>
    </div>
    <div class="footer row">
        <div class="col-md-12 text-center">
            <p><small>&copy;西安邮电大学计算机学院软件工程1505班<a>156工作室</a></small></p>
        </div>
    </div>
  
</body>
</html>
