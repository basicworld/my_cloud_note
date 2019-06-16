<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="header">
	<div class="header-logo">LOGO</div>
	<div class="header-desc">我的云笔记</div>
	<div class="header-func">
		<div class="header-func-activity">
			<a href="#">活动</a>
		</div>
		<div class="header-func-search form-inline">
			<div>
				<input type="text" class="form-control" placeholder="搜索笔记"
					id="search_note" />
			</div>
		</div>
		<div class="header-func-user">
			<div class="profile-nav">
				<span class="profile-username">东方不败</span> <a
					class="dropdown-toggle icon" data-toggle="dropdown"> <span
					id="user-toggle-down-icon" class="fa fa-caret-down"></span>
				</a>
				<ul class="dropdown-menu animated flipInX" role="menu"
					style="right: 15px; left: auto;">
					<li><a href="<c:url value='/changepwd'/>"><i
							class="fa fa-user"></i> 修改密码</a></li>
					<li class="divider"></li>
					<li><a id="logout" href="#"><i class="fa fa-sign-out"></i>
							退出登录</a></li>
				</ul>
			</div>
		</div>
		<c:url var="logoutAction" value="/user/logout.do"></c:url>
		<div style="display: none" id="logoutUrl" value="${logoutAction }"></div>
	</div>
</div>