//获取笔记本列表
function get_notebook_list() {
	listNotebooks();
}

// 注册事件
$(function() {
	// 显示用户名
	$("#profile-username").text(getCookie("userName"));
	// 获取笔记本列表
	get_notebook_list();
	// 点击笔记本 加载笔记list和编辑框
	$(document).on("click", "#pc-part-1 li", function() {
		// 显示笔记区域和编辑区域
		$("#pc-part-2, #pc-part-3").css("display", "block");
		$("#pc-part-2 ul").empty();
		$(".edui-container").css("width", "100%");// 解决ue隐藏后展开时宽度太小问题
		// 隐藏其他区域
		$("#pc-part-4, #pc-part-5,#pc-part-6,#pc-part-7,#pc-part-8").hide();
		// 取消功能按钮的点击效果
		$("#recycle-btn,#like-btn,#shared-btn").removeClass("clicked");
		// 取消其它笔记本的点击效果
		$(this).siblings("li").children("a").removeClass("checked");
		// 本笔记本添加点击效果
		$(this).children("a").addClass("checked");
		
	});
	// 添加笔记本
	$("#add-notebook-btn").click(function() {
		var notebookName = $("#notebookName").val();
		if (notebookName == null || notebookName == "") {
			return;
		} else {
			console.log("notebookName=" + notebookName);
			addNoteBook(notebookName);
		}
	});
});