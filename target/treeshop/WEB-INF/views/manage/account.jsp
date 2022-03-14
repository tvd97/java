<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglist.jsp"%>
<head>
<title>Insert title here</title>
</head>
<body>
	<content tag="menuHead"> <%@include
		file="/WEB-INF/views/shared/user/menuHead.jsp"%>
	</content>
	<section>
		<div class="container">
			<div class="row">
				<%@include file="/WEB-INF/views/manage/menu.jsp"%>
				<div class="col-sm-9 padding-right">
					<div class="product-details">
						<table class="table table-condensed" style="text-align: center;">
							<thead>
								<tr class="cart_menu">
									<th><small>Tên tài khoản</small></th>

									<th><small>Mật khẩu</small></th>
									<th><small>Trạng thái</small></th>
									<th><small>Tên hiển thị </small></th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td>191c900123</td>
									<td>$2a$10$aJ2Hl1ZD2zZIQXdK0os7U.pgz0UErVGYAtzCXhmzrXO...</td>
									<td style="color: green;">Hoạt động</td>
									<td>thai băn đán</td>
									<td><button type="button" class="btn btn-link">Khóa
											tài khoản</button></td>
								</tr>
								<tr>
									<td>admin</td>
									<td>$2a$10$aJ2Hl1ZD2zZIQXdK0os7U.pgz0UErVGYAtzCXhmzrXO...</td>
									<td style="color: green;">Hoạt động</td>
									<td></td>
									<td><button type="button" class="btn btn-link">Khóa
											tài khoản</button></td>
								</tr>
								<tr>
									<td>admin2</td>
									<td>$2a$10$aJ2Hl1ZD2zZIQXdK0os7U.pgz0UErVGYAtzCXhmzrXO...</td>
									<td style="color: green;">Hoạt động</td>
									<td>thai băn đán</td>
									<td><button type="button" class="btn btn-link">Khóa
											tài khoản</button></td>
								</tr>
								<tr>
									<td>lngoan</td>
									<td>21232f297a57a5a743894a0e4a801fc3</td>
									<td style="color: green;">Hoạt động</td>
									<td></td>
									<td><button type="button" class="btn btn-link">Khóa
											tài khoản</button></td>
								</tr>

								<tr>
									<td>nhang</td>
									<td>21232f297a57a5a743894a0e4a801fc3</td>
									<td style="color: green;">Hoạt động</td>
									<td></td>
									<td><button type="button" class="btn btn-link">Khóa
											tài khoản</button></td>
								</tr>

								<tr>
									<td>ttinh</td>
									<td>21232f297a57a5a743894a0e4a801fc3</td>
									<td style="color: green;">Hoạt động</td>
									<td></td>
									<td><button type="button" class="btn btn-link">Khóa
											tài khoản</button></td>
								</tr>

								<tr>
									<td>tvd1</td>
									<td>21232F297A57A5A743894A0E4A801FC3</td>
									<td style="color: green;">Hoạt động</td>
									<td>thai</td>
									<td><button type="button" class="btn btn-link">Khóa
											tài khoản</button></td>
								</tr>

							</tbody>
						</table>

					</div>
					<!--/product-details-->
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript">
		function deleteItme(id) {
			if (confirm("Xóa bản ghi này!")) {
				window.location = '<c:url value="/quan-ly/san-pham/xoa?id='
						+ id + '"/>';
			}

		}
		function editItme(id) {

			window.location = '<c:url value="/quan-ly/san-pham/chinh-sua?id='
					+ id + '"/>';

		}
	</script>
</body>