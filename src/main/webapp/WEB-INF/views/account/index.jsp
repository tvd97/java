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
							<h2 class="title text-center">Thông tin người dùng</h2>
						</div>
						<div class="table-responsive cart_info">
							<table class="table table-condensed">
								<thead>
									<tr>
										<th></th>
										<th></th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Mã người dùng</td>
										<td>${info.id}</td>
									</tr>
									<tr>
										<td>Họ tên</td>
										<td>${info.fistName}${info.lastName}</td>

									</tr>
									<tr>
										<td>Địa chỉ</td>
										<td>${info.address}</td>

									</tr>
									<tr>
										<td>Số điện thoại</td>
										<td>${info.phone}</td>

									</tr>
									<tr>
										<td>Email</td>
										<td>${info.email}1</td>

									</tr>
									<tr>
										<td>Tên đăng nhập</td>
										<td>${info.username}</td>
									</tr>
									<tr>
										<td></td>
										<td></td>
										<td><a href="<c:url value="/thanh-toan"/>"><button
													type="button" class="btn btn-primary">
													<i class="fa fa-crosshairs"></i>Cập nhật
												</button></a></td>
									</tr>
								</tbody>
							</table>
						</div>

					</div>
				</div>
			</div>
		</div>
	</section>
</body>
