<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglist.jsp"%>
<head>
<title>Đăng Nhập</title>
</head>

<body>
	<section id="form">
		<!--form-->
		<div class="container">
			<h3 class="title text-center"><a href='<c:url value="/trang-chu"/>'> Về trang chủ</a></h3>
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form">						
						<!--login form-->
						<h2>Bạn đã có tài khoản!</h2>
						<span style="color: red">${errorLogin}</span>					
						<form:form action="dang-nhap" method="POST"
							modelAttribute="userlogin">
							<form:input name="username" type="text"
								placeholder="Nhập tài khoản" path="username"  required="Nhập tài khoản"/>
							<form:input type="password" name="password"
								placeholder="Nhập mật khẩu" path="password"  required="Nhập mật khẩu"/>
							<span> <form:checkbox element="class='checkbox'"
									path="remember" /> Ghi nhớ đăng nhập
							</span>
							
							<button type="submit" class="btn btn-default">Đăng nhập</button>
						</form:form>

					</div>
					<!--/login form-->
				</div>
				<div class="col-sm-1">
					<h2 class="or">Hoặc</h2>
				</div>
				<div class="col-sm-4">
					<div class="signup-form">
						<!--sign up form-->
						<h2>Bạn chưa có tài khoản!</h2>
						<span style="color: red">${error}</span>
						<form:form action="dang-ky" method="POST"
							modelAttribute="userregister">
							<form:input type="text" placeholder="Tên hiển hị" path="name" />
							<form:input type="text" placeholder="Tài khoản" path="username" required="Nhập tài khoản" />
							<form:input type="password" placeholder="Mật khẩu"
								path="password" required="Nhập mật khẩu" />
							<button type="submit" class="btn btn-default">Đăng ký</button>
						</form:form>
					</div>
					<!--/sign up form-->
				</div>
			</div>
		</div>
	
	</section>
	<!--/form-->
</body>
