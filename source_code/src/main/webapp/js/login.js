// 绑定事件
$(function(){
	// 登录
	$("#login-btn").click(function(){
		login();
	});
});

// 登录
function login(){
	var username = $("#userName").val();
	var password = $("#userPassword").val();
	var loginurl = $("#loginUrl").attr("value");
	console.log(loginurl);
	if(username=="" || password==""){
		return;
	}
	$.ajax({
		type: "post",
		url: loginurl,
		dateTyoe:"json",
		data:{"userName":username, "userPassword":password},
		success:function(result){
			console.log(result);
			if(result.status==0){
				// 登陆成功，进入系统
				addToken(result.data.userToken);
				addCookie("userName",result.data.userName, 5);
				location.href="edit";
			}else{
				alert(result.msg);
			}
		},
		error: function(){
			alert("请求失败");
		}
	});
}
// 退出
// 注册
// 修改密码