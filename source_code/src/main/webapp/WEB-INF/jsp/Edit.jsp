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
@import url("<c:url value='/css/mathquill.css'/>");
</style>
<style type="text/css">
@import url("<c:url value='/css/umeditor.min.css'/>");
</style>
<link rel="stylesheet" href="<c:url value='/css/font-awesome.min.css'/>">


<title>My Cloud Note</title>
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<div class="row" id="center" style="margin: 0">
		<div id="toggle_hidden">
			<div class="pc-part col-xs-2" id="pc-part-1">
				<div id="pc-part-1-header">
					<span class="pc-part-span">全部笔记本</span>
					<button id="add-notebook" class="btn btn-default btn-xs mybtn-plus">
						<i class="fa fa-plus"></i>
					</button>
				</div>
				<div id="pc-part-1-center" class="pc-part-center">
					<div class="module" data-toggle="niceScroll">
						<div>
							<ul>
								<li><a class="unchecked"> <i class="fa fa-book"></i>
										默认笔记本
								</a></li>
								<li><a class="checked"> <i class="fa fa-book"></i>
										默认笔记本
								</a></li>
								<li><a class="unchecked"> <i class="fa fa-book"></i>
										默认笔记本
								</a></li>
								<li><a class="unchecked"> <i class="fa fa-book"></i>
										默认笔记本
								</a></li>
								<li><a class="unchecked"> <i class="fa fa-book"></i>
										默认笔记本
								</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div id="pc-part-1-footer">
					<div class="row margin-zero padding-zero">
						<div class="col-xs-4 click" id="rollback_button" title='回收站'>
							<i class='fa fa-trash-o'
								style='font-size: 20px; line-height: 31px;'></i>
						</div>
						<div class="col-xs-4 click" id="rollback_button" title='收藏笔记本'>
							<i class='fa fa-star' style='font-size: 20px; line-height: 31px;'></i>
						</div>
						<div class="col-xs-4 click" id="rollback_button" title='参加活动笔记'>
							<i class='fa fa-users'
								style='font-size: 20px; line-height: 31px;'></i>
						</div>
					</div>
				</div>
			</div>
			<div class="pc-part col-xs-3" id="pc-part-2">
				<div id="pc-part-2-header">
					<span class="pc-part-span">全部笔记</span>
					<button id="add-note" class="btn btn-default btn-xs mybtn-plus">
						<i class="fa fa-plus"></i>
					</button>
				</div>
				<div id="pc-part-2-center" class="pc-part-center">
					<div class="module" data-toggle="niceScroll">
						<div>
							<ul>
								<li><a class="checked"> <i class="fa fa-file-text-o"></i>
										默认笔记默认笔记默认笔记默
										<div class="functions"
											style="display: inline-block; position: absolute; right: 2px;">
											<div title="移动" class="function">
												<i class="fa fa-random small-icon"></i></div>
											<div title="分享" class="function">
												<i class="fa fa-sitemap small-icon"></i></div>
											<div title="删除" class="function">
												<i class="fa fa-close small-icon"></i></div>
										</div>

								</a></li>
								<li><a class="unchecked"> <i class="fa fa-file-text-o"></i>
										默认笔记
								</a></li>
								<li><a class="unchecked"> <i class="fa fa-file-text-o"></i>
										默认笔记
								</a></li>

							</ul>
						</div>
					</div>
				</div>
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
			<div id="pc-part-3-center" class="pc-part-center">
				<div class="module" data-toggle="niceScroll">
					<div class="ueditor-wrap margin-zero">
						<div id="pc-part-3-center-title"
							style="padding: 5px 0px; height: 44px;">
							<div class="row margin-zero">
								<div class="col-xs-9">
									<input type="text" class="form-control" id="input-note-title"
										placeholder="笔记标题...">
								</div>
							</div>
						</div>
						<div id="pc-part-3-center-ueditor"">
							<div class="row margin-zero">
								<div class="col-xs-12 margin-zero">
									<script type="text/plain" id="myEditor"
										style="width: 100%; height: 400px;">
									<p>点击输入内容...</p>
								</script>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="footer.jsp"></c:import>
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="<c:url value='/js/jquery.min.js'/>"></script>
	<script src="<c:url value='/js/umd/popper.min.js'/>"></script>
	<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/js/prototype.js'/>"></script>
	<script src="<c:url value='/js/theme-setup.js'/>"></script>

	<!-- ueditor -->
	<script type="text/javascript" charset="utf-8"
		src="<c:url value='/js/ue/umeditor.min.js'/>"></script>
	<script type="text/javascript" charset="utf-8"
		src="<c:url value='/js/ue/umeditor.config.js'/>"></script>
	<script type="text/javascript" charset="utf-8"
		src="<c:url value='/js/mathquill.min.js'/>"></script>
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
			$(".ueditor-wrap").css("height", (pc_height - 44 - 44) + "px");
			$("#myEditor").css("height", (pc_height - 44 - 44 - 100) + "px");
			//$("#myEditor").css("min-height", "0px");
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
			//实例化Ueditor编辑器
			var um = UM.getEditor('myEditor');

		});
		//改变窗口大小时调整页面尺寸
		window.onresize = function() {
			set_height();
			toggle_hidden();

			var width = $("#pc-part-3").width();
			$('.edui-container,.edui-editor-body').width(width - 30 - 6);
			$('#myEditor').width(width - 30 - 6 - 20);
		};
	</script>
</body>
</html>