/**
 * edit页面的主要逻辑
 * pc-part-1 笔记本栏
 * pc-part-2 笔记栏
 * pc-part-3 笔记编辑区
 * pc-part-4 回收站
 * pc-part-5 搜索结果
 * pc-part-6 我的收藏
 * pc-part-7 我的分享
 * pc-part-8 预览笔记
 * 
 * 点击1，显示2、3，隐藏4、5、6、7、8
 * 点击回收站按钮，显示4、8，隐藏2、3、5、6、7
 * 点击我的收藏，显示6、8，隐藏2、3、4、5、7
 * 点击我的分享，显示7、8，隐藏2、3、4、5、6
 */

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
		// 获取笔记本中的笔记
		var notebookId = getCheckedNoteBook().data("notebook").notebookId;
		listNotesForNotebook(notebookId);
		
	});
	// 点击笔记 设置点击效果 并加载笔记内容
	$(document).on("click", "#pc-part-2 li", function(){
		// 取消其他笔记的选中效果
		$(this).siblings('li').children('a').removeClass('checked');
		// 添加选中效果
		$(this).children('a').addClass('checked');
		// 获取笔记详情
		var noteId = getCheckedNote().data("note").noteId;
		console.log("noteId= " + noteId);
		getNoteDetail(noteId);
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
	// 添加笔记
	$("#add-note-btn").click(function() {
		var noteName = $("#noteName").val();
		var notebookId = getCheckedNoteBook().data("notebook").notebookId;
		if (noteName == null || noteName == "") {
			return;
		} else {
			console.log("noteName=" + noteName +", notebookId=" + notebookId);
			addNoteForNotebook(notebookId, noteName);
		}
	});
	// 修改保存笔记内容
	$("#save-note-btn").click(function(){
		var notebookId = getCheckedNoteBook().data("notebook").notebookId;
		var noteId = getCheckedNote().data("note").noteId;
		var noteTitle = $("#input-note-title").val();
		var noteBody = um.getContent();
		var noteDom = getCheckedNote();
		
		updateNote(notebookId, noteId, noteTitle, noteBody, noteDom);
	});
	// 点击回收站图标，打开回收站 和 预览窗格
	// * 点击回收站按钮，显示4、8，隐藏2、3、5、6、7
	$("#recycle-btn").click(function(){
		$("#pc-part-4, #pc-part-8").css("display", "block");
		$("#pc-part-2, #pc-part-3,#pc-part-5,#pc-part-6,#pc-part-7").hide();
		// 清空预览区域
		emptyPreviewNoteArea();
		// 取消笔记本列表的选择效果
		uncheckAllNotebooks();
		// 清空回收站li 然后重新加载
		$("#pc-part-4-center ul").empty();
		var notebookId=$('#recycle-btn').data('notebook').notebookId; // 回收站是一个笔记本
		listNotesForRecycleNotebook(notebookId);
	});
	// 点击我的收藏，打开我的收藏 和 预览窗格
	// * 点击我的收藏，显示6、8，隐藏2、3、4、5、7
	$("#like-btn").click(function(){
		$("#pc-part-6, #pc-part-8").css("display", "block");
		$("#pc-part-2, #pc-part-3,#pc-part-4,#pc-part-5,#pc-part-7").hide();
		emptyPreviewNoteArea();
		uncheckAllNotebooks();
		// 清空li 然后重新加载
		$("#pc-part-6-center ul").empty();
		var notebookId=$('#like-btn').data('notebook').notebookId; // 回收站是一个笔记本
		listNotesForMyLikeNotebook(notebookId);
		
	});
	// 点击我的分享，打开我的分享 和 预览窗格
	// * 点击我的分享，显示7、8，隐藏2、3、4、5、6
	$("#shared-btn").click(function(){
		$("#pc-part-7, #pc-part-8").css("display", "block");
		$("#pc-part-2, #pc-part-3,#pc-part-4,#pc-part-5,#pc-part-6").hide();
		emptyPreviewNoteArea();
		uncheckAllNotebooks();
		// 清空li 然后重新加载
		$("#pc-part-7-center ul").empty();
		var notebookId=$('#share-btn').data('notebook').notebookId; // 我的分享是一个笔记本
		listNotesForShareNotebook(notebookId);
		
	});
});

// 获取已选择的笔记本
function getCheckedNoteBook() {
	return $("#pc-part-1-center .checked").parent();
}
// 获取已选择的笔记
function getCheckedNote(){
	return $("#pc-part-2-center .checked").parent();
}
// 取消选择笔记本
function uncheckAllNotebooks(){
	// 取消笔记本的点击效果
	$("#pc-part-1 li a").removeClass("checked");
	$("#pc-part-1 li a").addClass("unchecked");
}
// 清空预览区的内容
function emptyPreviewNoteArea(){
	$("#preview-note-title").html("笔记标题...");
	$("#preview-note-body").html("笔记内容...");
}