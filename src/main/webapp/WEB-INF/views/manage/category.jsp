<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglist.jsp"%>
<head>
<title>Quản lý danh mục</title>
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
									<th><small>ID</small></th>

									<th><small>Tên</small></th>
									<th>Titile</th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${species}">
									<tr>
										<td>${item.id}</td>
										<td>${item.name}</td>
										<td>${item.metaName }</td>
										<td><button type="button" class="btn btn-link">Xóa</button></td>
									</tr>
								</c:forEach>
<tr>
										<td><input name="id" id="id"></td>
										<td><input name="name" id="name" ></td>
										<td><input name="title" id="title" ></td>
										<td><button type="button" class="btn btn-link">Thêm</button></td>
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