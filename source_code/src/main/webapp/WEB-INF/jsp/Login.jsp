<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<!-- <meta name="viewport"	content="width=device-width, initial-scale=1, shrink-to-fit=no"> -->

<!-- Bootstrap CSS -->
<style type="text/css">
@import url("<c:url value='/css/bootstrap.min.css'/>");
</style>
<style type="text/css">
@import url("<c:url value='/css/main.css'/>");
</style>
<style type="text/css">
@import url("<c:url value='/css/login.css'/>");
</style>

<title>Login</title>
</head>
<body>
	<div class="outer" id="outer">
		<div class="log login_in">
			<c:url var="formAction" value="/user/login.do"></c:url>
			<form:form id="login-form" commandName="user"
				action="${formAction}" method="post" class="form-horizontal"
				role="form">
				<dl>
					<dt class="header">
						<h3>登 录</h3>
					</dt>
					<dt></dt>
					<dt class="letter">
						<div class="form-group">
							<label for="userName" class="col-xs-2 control-label">用户名</label>
							<div class="col-xs-9">
								<form:input class="form-control" id="userName" path="userName" />
							</div>
							<div class="col-xs-1"></div>
						</div>
					</dt>
					<dt class="letter">
						<div class="form-group">
							<label for="userPassword" class="col-xs-2 control-label">密码</label>
							<div class="col-xs-9">
								<form:password class="form-control" id="userPassword"
									path="userPassword" />
							</div>
							<div class="col-xs-1"></div>
						</div>
					</dt>
					<dt class="button">
						<div class="form-group">
							<div class="col-xs-offset-4 col-xs-8">
								<button type="submit" class="btn btn-primary">登录</button>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
									class="btn btn-default" href="<c:url value='/regist'/>">注册</a>
							</div>
						</div>
					</dt>
				</dl>
			</form:form>
		</div>
	</div>

	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="<c:url value='/js/jquery.slim.min.js'/>"></script>
	<script src="<c:url value='/js/umd/popper.min.js'/>"></script>
	<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
	<!-- Optional JavaScript -->
	<script type="text/javascript">
		function get_dom(e) {
			return document.getElementById(e);
		}
		function set_height() {
			var pc_height = window.innerHeight;
			$("#outer").css({
				"padding-top" : pc_height / 2 - 140 + "px",
				"height" : pc_height / 2 + 140 + "px"
			});
		}
		$(document).ready(function() {

			// 开始写 jQuery 代码...
			set_height();

		});
		//改变窗口大小时调整页面尺寸
		window.onresize = function() {
			set_height();
		};
	</script>

</body>
</html>