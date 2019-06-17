// 根据用户ID加载笔记本列表
function listNotebooks() {
	// 从cookie 获取用户id
	var userId = getCookie("userId");
	var token = getToken();
	// 如果没有userId说明用户未登录，提醒后转到登陆页面
	console.log("userId=" + userId);
	if (userId == null || userId == "") {
		alert("用户未登录，请先进行登陆");
		location.href = "edit";
	}
	// 
	var listNotebooksUrl = $("#listNotebooksUrl").attr("value");
	console.log(loginurl);
	$.ajax({
		type : "post",
		url : listNotebooksUrl,
		dateTyoe : "json",
		data : {
			"userId" : userId,
			"token" : token
		},
		success : function(result) {
			console.log(result);
			if (result.status == 0) {
				var list = result.data;
				$(list).each(
						function() {
							// 添加笔记本和数据
							$("#pc-part-1 ul").append(
									'<li><a class="unchecked"> <i class="fa fa-book"></i> '
											+ this.notebookName + '</a></li>');
							$("#pc-part-1 li:last").data("notebook", this);
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

// 添加笔记本
function addNoteBook(notebookName) {
	var userId = getCookie("userId");
	var token = getToken();
	var addNotebookUrl = $("#addNotebookUrl").attr("value");
	$.ajax({
		type : "post",
		url : addNotebookUrl,
		dateTyoe : "json",
		data : {
			"userId" : userId,
			"token" : token,
			"title" : notebookName,
		},
		success : function(result) {
			console.log(result);
			if (result.status == 0) {
				var notebook = result.data;
				// 显示新添加的笔记本和数据
				$("#pc-part-1 li:first").after(
						'<li><a class="unchecked"> <i class="fa fa-book"></i> '
								+ notebook.notebookName + '</a></li>');
				$("#pc-part-1 li:first").next().data("notebook", notebook);
			} else {
				alert(result.msg);
			}
		},
		error : function(xhr, status, error) {
			alert("服务器连接失败");
		}
	});
}