//获取笔记本列表
function get_notebook_list(){
	listNotebooks();
}



// 注册事件
$(function(){
	console.log("regist functions");
	$("#add-notebook-btn").click(function(){
		var notebookName = $("#notebookName").val();
		if(notebookName==null || notebookName==""){
			return;
		}else{
			console.log("notebookName="+notebookName);
			addNoteBook(notebookName);
		}
	});
});