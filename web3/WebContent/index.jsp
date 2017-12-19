<%@ page pageEncoding="UTF-8" isErrorPage="false" errorPage="error.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>登录剧院票务管理系统</title>
	<link rel="stylesheet" type="text/css" href="css/register-login.css">

</head>
<body style="background-color:#e1e3db;">
<div class="cent-box">
	<div >
		<h1 class="main-title hide">156剧院票务管理系统</h1>
		<h2 class="sub-title" font-size:40px>欢迎进入156剧院管理系统</h2>
	</div>

	<div class="cont-main clearfix">
		<div class="index-tab">
			<div class="index-slide-nav">
				<a href="index.jsp" class="active">登录</a>
				<a href="#">注册</a>
				<div class="slide-bar"></div>				
			</div>
		</div>
		<form method="post" action="Login" class="login">
		<div class="login form">
			<div class="group">
				<div class="group-ipt username">
					<input type="text" name="username" id="username" class="ipt" placeholder="输入您的用户名" required oninvalid="setCustomValidity('请输入用户名,长度6位!')">
				</div>
				<div class="group-ipt password">
					<input type="password" name="password" id="password" class="ipt" placeholder="输入您的登录密码" required oninvalid="setCustomValidity('请输入密码,长度6位!')">
				</div>
			</div>
		</div>

		<div class="button">
			<button type="submit" class="login-btn register-btn " onclick="return checkusername()" id="button">登录</button>
		</div>
		</form>
		<div class="remember clearfix">
			<label class="remember-me"><span class="icon"><span class="zt"></span></span><input type="checkbox" name="remember-me" id="remember-me" class="remember-mecheck" checked>记住我</label>
			<label class="forgot-password">
				<a href="register.jsp">忘记密码？</a>
			</label>
		<div style="color:red" id="errormess">${desc}</div>
		</div>
	</div>
</div>

<div class="footer row">
        <div class="col-md-12 text-center">
            <p><small>&copy;西安邮电大学计算机学院软件工程1505班<a>156工作室</a></small></p>
        </div>
    </div>

<script src='js/particles.js' type="text/javascript"></script>
<script src='js/background.js' type="text/javascript"></script>
<script src='js/jquery.min.js' type="text/javascript"></script>
<script src='js/layer/layer.js' type="text/javascript"></script>
<script>
	$("#remember-me").click(function(){
		var n = document.getElementById("remember-me").checked;
		if(n){
			$(".zt").show();
		}else{
			$(".zt").hide();
		}
	});
</script>
</body>
</html>