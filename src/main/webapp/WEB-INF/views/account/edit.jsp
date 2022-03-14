<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglist.jsp"%>
<head>
<title>Thông tin cá nhân</title>
</head>
<body>
	<content tag="menuHead"> <%@include
		file="/WEB-INF/views/shared/user/menuHead.jsp"%>
	</content>
	<section>
		<div class="container">
			<div class="row">
				<%@include file="//WEB-INF/views/shared/user/menu.jsp"%>
				<div class="col-sm-9 padding-right">

					<div class="category-tab">
						<div class="col-sm-12">
							<h3 class="title text-center">Cập nhật thông tin</h3>
						</div>
						<form>
							<div class="form-group row">
								<label for="staticEmail" class="col-sm-2 col-form-label">Mã
									người dùng</label>
								<div class="col-sm-10">
									<input type="text" readonly class="form-control-plaintext"
										id="infoid" value="${info.id}">
								</div>
							</div>
							<div class="form-group row">
								<label for="staticEmail" class="col-sm-2 col-form-label">Họ</label>
								<div class="col-sm-10">
									<input type="text" class="form-control-plaintext"
										id="fisrtname" value="${info.fistName}">
								</div>
							</div>
							<div class="form-group row">
								<label for="staticEmail" class="col-sm-2 col-form-label">Tên</label>
								<div class="col-sm-10">
									<input type="text" class="form-control-plaintext"
										id="lastname" value="${info.lastName}">
								</div>
							</div>
							<div class="form-group row">
								<label for="staticEmail" class="col-sm-2 col-form-label">Địa
									chỉ</label>
								<div class="col-sm-10">
									<input type="text" class="form-control-plaintext"
										id="address" value="${info.address}">
								</div>
							</div>
							<div class="form-group row">
								<label for="staticEmail" class="col-sm-2 col-form-label">Số
									điện thoại</label>
								<div class="col-sm-10">
									<input type="text" class="form-control-plaintext"
										id="phone" value="${info.phone}">
								</div>
							</div>
							<div class="form-group row">
								<label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
								<div class="col-sm-10">
									<input type="text" class="form-control-plaintext"
										id="email" value="${info.email}">
								</div>
							</div>
							<div class="form-group row">
								<label for="staticEmail" class="col-sm-2 col-form-label">Tên
									đăng nhập</label>
								<div class="col-sm-10">
									<input type="text" readonly class="form-control-plaintext"
										id="username" value="${info.username}">
								</div>
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>


					</div>
				</div>
			</div>
		</div>
	</section>
</body>
