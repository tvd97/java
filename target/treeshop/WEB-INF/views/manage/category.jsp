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
									<th><small>ID</small></th>

									<th><small>Tên</small></th>
									<th>Titile</th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td>BO</td>
									<td>Bơ</td>
									<td></td>
									<td><button type="button" class="btn btn-link">Sủa</button><button type="button" class="btn btn-link">Xóa</button></td>
								<tr>
									<td>BUOI</td>
									<td>Bưởi</td>
									<td></td>
									<td><button type="button" class="btn btn-link">Sủa</button><button type="button" class="btn btn-link">Xóa</button></td>
								<tr>
									<td>CAM</td><td> Cam</td>
									<td></td>
									<td><button type="button" class="btn btn-link">Sủa</button><button type="button" class="btn btn-link">Xóa</button></td>
								<tr>
									<td>CHOMCHOM</td>
									<td>Chôm chôm</td>
								<tr>
									<td>MAM </td><td>Mận</td>
									<td></td>
									
									<td><button type="button" class="btn btn-link">Sủa</button><button type="button" class="btn btn-link">Xóa</button></td>
								<tr>
									<td>MANGCUT</td>
									<td>Măng cụt</td>
									<td></td>
									<td><button type="button" class="btn btn-link">Sủa</button><button type="button" class="btn btn-link">Xóa</button></td>
								<tr>
									<td>MIT</td><td> Mít</td>
									<td></td>
									<td><button type="button" class="btn btn-link">Sủa</button><button type="button" class="btn btn-link">Xóa</button></td>
								<tr>
									<td>NA</td>
									<td>Na</td>
									<td>na</td>
									<td><button type="button" class="btn btn-link">Sủa</button><button type="button" class="btn btn-link">Xóa</button></td>
								<tr>
									<td>NHAN</td>
									<td>Nhãn</td>
									<td>nhan</td>
									<td><button type="button" class="btn btn-link">Sủa</button><button type="button" class="btn btn-link">Xóa</button></td>
								<tr>
									<td>OI</td>
									<td>Ổi</td>
									<td>oi</td>
									<td><button type="button" class="btn btn-link">Sủa</button><button type="button" class="btn btn-link">Xóa</button></td>
								<tr>
									<td>XOAI</td>
									<td>Xoài</td>
									<td>xoai</td>
									<td><button type="button" class="btn btn-link">Sủa</button><button type="button" class="btn btn-link">Xóa</button></td>
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