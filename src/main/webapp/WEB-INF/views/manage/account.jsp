<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglist.jsp"%>
<head>
<title>Quản lý tài khoản</title>
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
								<c:forEach var="item" items="${account }">
									<tr>
										<td>${item.username }</td>
										<td>${item.password }</td>
										<c:if test="${item.status==1 }">
											<td style="color: green;">Hoạt động</td>
										</c:if>
										<c:if test="${item.status==0 }">
											<td style="color: green;">Đã khóa</td>
										</c:if>

										<td>${ item.name}</td>
										<c:if test="${item.status==1 }">
											<td><button type="button" class="btn btn-link"
													onclick="lock(String(${item.username }))">Khóa tài khoản</button></td>
										</c:if>
										<c:if test="${item.status==0 }">
											<td><button type="button" class="btn btn-link"
													onclick="unlock(String(${item.username }))">Mở tài khoản</button></td>
										</c:if>

									</tr>
								</c:forEach>



							</tbody>
						</table>

					</div>
					<!--/product-details-->
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript">
		function lock(input) {
			if (confirm("Khóa tài khoản này!")) {
				window.location.href = '<c:url value="/quan-ly/tai-khoan/khoa?user='+input +'"/>';
			}

		}
		function unlock(input) {
			if (confirm("Mở khóa tài khoản này!")) {
			window.location.href = '<c:url value="/quan-ly/tai-khoan/khoa?user='+input + '"/>';
			}
		}
	</script>
</body>