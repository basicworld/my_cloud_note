// 加载笔记列表
function listNotesForNotebook(notebookId){
	var listNotesUrl = $("#listNotesUrl").attr("value");
	var userId = getCookie("userId");
	var token = getToken();
	$.ajax({
		type : "post",
		url : listNotesUrl,
		dateTyoe : "json",
		data : {
			"userId" : userId,
			"token" : token,
			"bookId" : notebookId,
		},
		success : function(result) {
			console.log(result);
			if (result.status == 0) {
				var notesList = result.data;
				$(notesList).each(function(){
					var li = '<li><a class="unchecked"> <i class="fa fa-file-text-o"></i> ' + this.noteTitle + 
					' <div class="functions"style="display: inline-block; position: absolute; right: 2px;"> <div title="移动" class="function"> <i class="fa fa-random small-icon"></i> </div> <div title="分享" class="function"> <i class="fa fa-share small-icon"></i> </div> <div title="删除" class="function"> <i class="fa fa-close small-icon"></i> </div> </div> </a></li>';
					// 显示新添加的笔记和数据
					$("#pc-part-2 ul").append(li);
					$("#pc-part-2 ul li:last").data("note", this);
				});
			} else {
				alert(result.msg);
			}
		},
		error : function(xhr, status, error) {
			alert("服务器连接失败");
		}
	});
}
// 加载一条笔记的详情
function getNoteDetail(noteId){
	var getNoteUrl = $("#getNoteUrl").attr("value");
	var userId = getCookie("userId");
	var token = getToken();
	$.ajax({
		type : "post",
		url : getNoteUrl,
		dateTyoe : "json",
		data : {
			"userId" : userId,
			"token" : token,
			"noteId" : noteId,
		},
		success : function(result) {
			console.log(result);
			if (result.status == 0) {
				var note = result.data;
				$("#input-note-title").val(note.noteTitle);
				um.setContent(note.noteBody==null?"":note.noteBody);
			} else {
				alert(result.msg);
			}
		},
		error : function(xhr, status, error) {
			alert("服务器连接失败");
		}
	});
}
// 创建笔记 新建笔记
function addNoteForNotebook(notebookId, noteName){
	var userId = getCookie("userId");
	var token = getToken();
	var addNoteUrl = $("#addNoteUrl").attr("value");
	$.ajax({
		type : "post",
		url : addNoteUrl,
		dateTyoe : "json",
		data : {
			//String userId, String bookId, String title
			"userId" : userId,
			"token" : token,
			"bookId" : notebookId,
			"title" : noteName,
		},
		success : function(result) {
			console.log(result);
			if (result.status == 0) {
				var notesList = result.data;
				$(notesList).each(function(){
					var li = '<li><a class="checked"> <i class="fa fa-file-text-o"></i> ' + this.noteTitle + 
					' <div class="functions"style="display: inline-block; position: absolute; right: 2px;"> <div title="移动" class="function"> <i class="fa fa-random small-icon"></i> </div> <div title="分享" class="function"> <i class="fa fa-share small-icon"></i> </div> <div title="删除" class="function"> <i class="fa fa-close small-icon"></i> </div> </div> </a></li>';
					// 显示新添加的笔记和数据
					// 新数据显示在第一条
					$("#pc-part-2 ul").prepend(li);
					$("#pc-part-2 ul li:first").next().data("note", this);
				});
			} else {
				alert(result.msg);
			}
		},
		error : function(xhr, status, error) {
			alert("服务器连接失败");
		}
	});
}
// 更新笔记 保存修改的笔记
// notebookId, noteId, noteTitle, noteBody
// noteDom: dom对象
function updateNote(notebookId, noteId, noteTitle, noteBody, noteDom){
	var userId = getCookie("userId");
	var token = getToken();
	var updateNoteUrl = $("#updateNoteUrl").attr("value");
	$.ajax({
		type : "post",
		url : updateNoteUrl,
		dateTyoe : "json",
		data : {
			//(String noteId, String title, String body)
			"userId" : userId,
			"token" : token,
			"bookId" : notebookId,
			"noteId" : noteId,
			"title" : noteTitle,
			"body" : noteBody,
		},
		success : function(result) {
			console.log(result);
			if (result.status == 0) {
				var note = result.data;
					var inote = '<i class="fa fa-file-text-o"></i> <span>' + noteTitle + 
					'</span> <div class="functions"style="display: inline-block; position: absolute; right: 2px;"> <div title="移动" class="function"> <i class="fa fa-random small-icon"></i> </div> <div title="分享" class="function"> <i class="fa fa-share small-icon"></i> </div> <div title="删除" class="function"> <i class="fa fa-close small-icon"></i> </div> </div>';
					noteDom.children(".checked").html(inote);
			} else {
				alert(result.msg);
			}
		},
		error : function(xhr, status, error) {
			alert("服务器连接失败");
		}
	});
}