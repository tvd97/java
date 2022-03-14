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
					<div class="category-tab">
						<!--category-tab-->
						<div class="col-sm-12">
							<h2 class="title text-center">Thông tin đơn hàng</h2>
						</div>
						<div class="table-responsive cart_info">
							<table class="table table-condensed">
								<thead>
									<tr class="cart_menu">
										<th class="image">ID</th>
										<th class="description">Cây giống</th>
										<th class="price">Số lượng</th>
										<th class="quantity">Tổng tiền</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${data}" varStatus="index">
										<tr>
											<td>#${item.id }</td>
											<td>${item.name }</td>
											<td>${item.count }</td>
											<td>${item.total }</td>
										</tr>
									</c:forEach>


									<tr>
										<td></td>
										<td></td>
										<td></td>
										<td></td>

										<td><button type="button" class="btn btn-link"
												onclick="aceptbill(${id})">Nhận đơn</button>
											<button type="button" class="btn btn-link"
												onclick="canclebill(${id})">Hủy đơn</button>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<!--/product-details-->
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript">
		function aceptbill(id) {
			if (confirm("Thông qua đơn hàng này!")) {
				window.location.href = '<c:url value="/quan-ly/don-hang/nhan-don?id='+id+'"/>';
			}

		}
		function canclebill(id) {
			if (confirm("Hủy đơn hàng này!")) {
				window.location.href = '<c:url value="/quan-ly/don-hang/huy-don?id='
						+ id + '"/>';
			}

		}
	</script>
</body>