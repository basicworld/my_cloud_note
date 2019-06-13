// 获取token
function getToken(){
	return getCookie("token");
}
// 配置token 有效期24小时
function addToken(tValue){
	addCookie("token", tValue, 24);
}
// 删除token
function delToken(){
	delCookie("token");
}

// 检验token 检验是否有效