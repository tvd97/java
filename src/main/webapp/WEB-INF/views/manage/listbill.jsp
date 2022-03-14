<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglist.jsp"%>
<head>
<title>Thông tin đơn hàng</title>
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

					<div class="category-tab">
						<!--category-tab-->
						<div class="col-sm-12">
							<h2 class="title text-center">Đơn hàng</h2>
						</div>
						<div class="table-responsive cart_info">
							<table class="table table-condensed">
								<thead>
									<tr class="cart_menu">
										<th class="image">ID</th>
										<th class="description">Người nhân</th>
										<th class="price">Ngày đặt</th>
										<th class="quantity">Địa chỉ</th>
										<th class="total">Số điện thoại</th>
										<th>Trạng thái</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${data}">
										<tr>
											<td>#${item.id }</td>
											<td>${item.name }</td>
											<td>${item.date }</td>
											<td>${item.addr }</td>
											<td>${item.phone}</td>
											<td>Chua duyệt</td>
											<td><button type="button" class="btn btn-link"
													onclick="window.location.href='<c:url value="/quan-ly/don-hang/chi-tiet?id=${item.id}"/>'">Chi
													tiết</button>
										</tr>
									</c:forEach>



								</tbody>
							</table>
						</div>
						<!--/product-details-->
					</div>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript">
		function aceptbill() {
			if (confirm("Thông qua đơn hàng này!")) {
				window.location.href = '<c:url value="/quan-ly/san-pham/xoa?id='
						+ id + '"/>';
			}

		}
		function canclebill() {
			if (confirm("Hủy đơn hàng này!")) {
				window.location.href = '<c:url value="/quan-ly/san-pham/xoa?id='
						+ id
				'"/>';
			}

		}
	</script>
</body>