<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglist.jsp"%>
<div class="mainmenu pull-left">
	<ul class="nav navbar-nav collapse navbar-collapse">
		<li><a href='<c:url value="/trang-chu"/>'><i
				class='fas fa-home'></i> Trang chủ</a></li>
		<li class="dropdown"><a href="#"><i
				class="fa fa-shopping-cart"></i> Giỏ Hàng <c:if
					test="${not empty cCart}">
					<small style="color: red;">(${cCart})</small>
				</c:if> <i class="fa fa-angle-down"></i> </a>
			<ul role="menu" class="sub-menu">
				<li><a href='<c:url value="/gio-hang"/>'><i
						class="fa fa-shopping-cart"></i> Giỏ Hàng<c:if
							test="${not empty cCart}">
							<small style="color: red;">(${cCart})</small>
						</c:if></a></li>
				<li><a href='<c:url value="/lich-sua-mua-hang"/>'><i
						class='fas fa-history'></i> Lich su mua</a></li>
			</ul></li>
		<c:if test="${not empty login}">
			<li class="dropdown"><a href="#">Tài Khoản
					(${login.username})<i class="fa fa-angle-down"></i>
			</a>
				<ul role="menu" class="sub-menu">
					<li><a href='<c:url value="/tai-khoan"/>'>Thông tin</a></li>
					<li><a data-toggle="modal" data-target="#myModal">Đổi mật
							khẩu</a></li>
				</ul></li>
		</c:if>
		<li><c:if test="${not empty login}">
				<a href="<c:url value="/dang-xuat"/>"><i class="fa fa-lock"></i>
					Đăng xuất</a>
			</c:if> <c:if test="${ empty login}">
				<a href="<c:url value="/dang-nhap"/>"><i class="fa fa-lock"></i>
					Đăng Nhập | Đăng ký</a>
			</c:if></li>
	</ul>
</div>


