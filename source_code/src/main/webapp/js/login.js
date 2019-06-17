// 绑定事件
$(function() {
	// 登录
	$("#login-btn").click(function() {
		login();
	});
	// 注册
	$("#regist-btn").click(function() {
		regist();
	});
	// 修改密码
	$("#changepwd-btn").click(function() {
		changePwd();
	});
	// 退出
	$("#logout").click(function() {
		logout();
	});
});

// 登录
function login() {
	var username = $("#userName").val();
	var password = $("#userPassword").val();
	var loginurl = $("#loginUrl").attr("value");
	console.log(loginurl);
	if (username == "" || password == "") {
		return;
	}
	$.ajax({
		type : "post",
		url : loginurl,
		dateTyoe : "json",
		data : {
			"userName" : username,
			"userPassword" : password
		},
		success : function(result) {
			console.log(result);
			if (result.status == 0) {
				// 登陆成功，进入系统
				addToken(result.data.userToken);
				addCookie("userName", result.data.userName, 5);
				addCookie("userId", result.data.userId, 5);
				location.href = "edit";
			} else {
				alert(result.msg);
			}
		},
		error : function(xhr, status, error) {
			alert("服务器连接失败");
		}
	});
}
// 退出
function logout() {
	// 清空cookie
	delAllCookie();
	// 跳转到登陆页面
	location.href = "login";
//	var logoutUrl = $("#logoutUrl").attr("value");
//	$.ajax({
//		type : "post",
//		url : logoutUrl,
//		dateTyoe : "json",
//		data : {},
//		success : function(result) {
//			if (result.status == 0) {
//				delAllCookie();
//				// 跳转到登陆页面
//				location.href = "login";
//			} else {
//				alert(result.msg);
//			}
//		},
//		error : function(xhr, status, error) {
//			alert("服务器连接失败");
//		}
//	});
}
// 注册
function regist() {
	var userName = $("#userName").val();
	var userNick = $("#userNick").val();
	var userPassword = $("#userPassword").val();
	var userPassword2 = $("#userPassword2").val();
	var registurl = $("#registUrl").attr("value");
	console.log(registurl);
	if (userName == "" || userNick == "" || userPassword == ""
			|| userPassword2 == "") {
		return;
	}
	// todo 用户名校验
	// todo 密码校验
	if (userPassword.length < 6 || userPassword != userPassword2) {
		alert("密码长度不足6位，或两次密码不一致");
		return;
	}
	;
	var user = {
		"userName" : userName,
		"userNick" : userNick,
		"userPassword" : userPassword
	};
	$.ajax({
		type : "post",
		url : registurl,
		dateTyoe : "json",
		data : user,
		success : function(result) {
			if (result.status == 0) {
				// 登陆成功，进入系统
				// addToken(result.data.userToken);
				// addCookie("userName",result.data.userName, 5);
				alert("注册成功，跳转到登陆页面");
				// 跳转到登陆页面
				location.href = "login";
			} else {
				alert(result.msg);
			}
		},
		error : function(xhr, status, error) {
			alert("服务器连接失败");
		}
	});
}
// 修改密码
function changePwd() {
	var userName = getCookie("userName");
	var lastPassword = $("#lastPassword").val();
	var newPassword = $("#newPassword").val();
	var confirmPassword = $("#confirmPassword").val();
	var changePwdUrl = $("#changePwdUrl").attr("value");
	console.log(changePwdUrl);
	if (userName == "") {
		alert("尚未登陆，无法修改密码");
		return;
	}
	if (lastPassword == "" || newPassword == "" || confirmPassword == "") {
		return;
	}
	// todo 密码校验
	if (newPassword.length < 6 || newPassword != confirmPassword) {
		alert("新密码长度不足6位，或两次密码不一致");
		return;
	}
	;
	$.ajax({
		type : "post",
		url : changePwdUrl,
		dateTyoe : "json",
		data : {
			"userName" : userName,
			"lastPassword" : lastPassword,
			"finalPassword" : newPassword
		},
		success : function(result) {
			if (result.status == 0) {
				// 修改密码成功后，删除原来的cookie和token token也是保存为cookie形式
				delAllCookie();
				// 跳转到登陆页面
				alert("修改密码成功，请重新登陆");
				location.href = "login";
			} else {
				alert(result.msg);
			}
		},
		error : function(xhr, status, error) {
			alert("服务器连接失败");
		}
	});
}