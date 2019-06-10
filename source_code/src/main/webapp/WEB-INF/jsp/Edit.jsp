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

<title>My Cloud Note</title>
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<div class="row" id="center" style="margin: 0">
		<div id="toggle_hidden">
			<div class="pc-part col-xs-2" id="pc-part-1">
				<div id="pc-part-1-header">全部笔记本</div>
				<div id="pc-part-1-center" class="pc-part-center">笔记本组</div>
				<div id="pc-part-1-footer">删除 收藏 活动笔记</div>
			</div>
			<div class="pc-part col-xs-3" id="pc-part-2">
				<div id="pc-part-2-header">全部笔记</div>
				<div id="pc-part-2-center" class="pc-part-center">笔记组</div>
			</div>

		</div>

		<div class="pc-part col-xs-7" id="pc-part-3">
			<div id="pc-part-3-header">
				<div
					style="float: left; font-size: 18px; line-height: 31px; padding: 3px 10px;">
					<span>编辑笔记</span>
				</div>
				<div style="float: right; padding: 1px 10px;">
					<button class="btn btn-primary">保存笔记</button>
				</div>
			</div>
			<div id="pc-part-3-center">
				<div style="padding: 5px 10px; background: #fff; height: 44px;">
					<div id="pc-part-3-center-title" class="row margin-zero">
						<div class="col-xs-9">
							<input type="text" class="form-control" id="input-note-title"
								placeholder="笔记本标题...">
						</div>
					</div>
				</div>
				<div id="ueditor-wrap" style="background: #ccc;">
					<div id="pc-part-3-center-ueditor">ueditor</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="footer.jsp"></c:import>

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
			pc_height = pc_height - 50 - 30;
			$("#pc-part-1-center").css("height", (pc_height - 31 - 31) + "px");
			$("#pc-part-2-center").css("height", (pc_height - 31) + "px");
			$("#pc-part-3-center").css("height", (pc_height - 44) + "px");
			$("#ueditor-wrap").css("height", (pc_height - 44 - 44) + "px");
		}
		function toggle_hidden() {
			var pc_width = window.innerWidth;
			if (pc_width < 780) {
				$("#toggle_hidden").hide();
				$("#pc-part-3").attr("class", "pc-part col-xs-12");
			} else {
				$("#toggle_hidden").show();
				$("#pc-part-3").attr("class", "pc-part col-xs-7");
			}
		}
		$(document).ready(function() {

			// 开始写 jQuery 代码...
			set_height();
			toggle_hidden();

		});
		//改变窗口大小时调整页面尺寸
		window.onresize = function() {
			set_height();
			toggle_hidden();
		};
	</script>

</body>
</html>