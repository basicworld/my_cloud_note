<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>修改密码 - 我的云笔记</title>
</head>
<body>
	<div class="outer" id="outer">
		<div class="log login_in" id="login-div" style="display: none;">
			<c:url var="formAction" value="/user/changepwd.do"></c:url>
			<div style="display: none" id="changePwdUrl" value="${formAction }"></div>
			<div id="login-form" class="form-horizontal" role="form">
				<dl>
					<dt class="header">
						<h3>修改密码</h3>
					</dt>
					<dt></dt>
					<dt class="letter">
						<div class="form-group">
							<label for="lastPassword" class="col-xs-2 control-label">原密码</label>
							<div class="col-xs-9">
								<input type="password" class="form-control" id="lastPassword"
									path="lastPassword" />
							</div>
							<div class="col-xs-1"></div>
						</div>
					</dt>
					<dt class="letter">
						<div class="form-group">
							<label for="newPassword" class="col-xs-2 control-label">新密码</label>
							<div class="col-xs-9">
								<input type="password" class="form-control" id="newPassword"
									path="newPassword" />
							</div>
							<div class="col-xs-1"></div>
						</div>
					</dt>
					<dt class="letter">
						<div class="form-group">
							<label for="confirmPassword" class="col-xs-2 control-label">确认密码</label>
							<div class="col-xs-9">
								<input type="password" class="form-control" id="confirmPassword" />
							</div>
							<div class="col-xs-1"></div>
						</div>
					</dt>
					<dt class="button">
						<div class="form-group">
							<div class="col-xs-offset-4 col-xs-8">
								<button type="submit" class="btn btn-primary" id="changepwd-btn">修改密码</button>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
									class="btn btn-default" href="<c:url value='/login'/>">去登陆</a>
							</div>
						</div>
					</dt>
				</dl>
			</div>
		</div>
	</div>

	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="<c:url value='/js/jquery.min.js'/>"></script>
	<script src="<c:url value='/js/umd/popper.min.js'/>"></script>
	<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
	<!-- functions -->
	<script src="<c:url value='/js/login.js'/>"></script>
	<script src="<c:url value='/js/cookie.js'/>"></script>
	<script src="<c:url value='/js/token.js'/>"></script>
	<!-- Optional JavaScript -->
	<script type="text/javascript">
		function set_height() {
			var pc_height = window.innerHeight;
			$("#outer").css({
				"padding-top" : pc_height / 2 - 160 + "px",
				"height" : pc_height / 2 + 160 + "px"
			});
		}
		$(document).ready(function() {

			// 开始写 jQuery 代码...
			set_height();
			// 显示登录框
			// 先隐藏后显示，是为了避免看到设置登录框居中效果时的过度画面
			$("#login-div").attr("style", "display:block;");

		});
		//改变窗口大小时调整页面尺寸
		window.onresize = function() {
			set_height();
		};
	</script>

</body>
</html>