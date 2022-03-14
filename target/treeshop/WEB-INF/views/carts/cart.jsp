<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglist.jsp"%>
<head>
<title>Đay là trang giỏ hàng</title>
</head>
<body>
	<content tag="menuHead"> <%@include
		file="/WEB-INF/views/shared/user/menuHead.jsp"%>
	</content>
	<section id="cart_items">
		<div class="container">
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<th class="image"><a>Tiệp tục xem</a></th>
							<th class="description">Tên cây giống</th>
							<th class="price">Giá</th>
							<th class="quantity">Số lượng</th>
							<th class="total">Tổng</th>
							<th></th>
						</tr>
					</thead>
					<tbody>


						<c:forEach var="item" items="${carts }">
							<tr id="row_${item.id}">
								<td class="cart_product"><a
									href="<c:url value="/san-pham/chi-tiet-san-pham/${item.id_product}"/>"><img
										src="<c:url value="/content/image/${item.img}"/>" alt=""  style="width: 50px;height: 50px;"></a></td>
								<td class="cart_description">
									<h4>
										<a href="">${item.name}</a>
									</h4>
									<p>ID: ${item.id_product}</p>
								</td>
								<td class="cart_price">
									<p>
										<fmt:formatNumber type="number" groupingUsed="true"
											value="${item.price }" />
									</p>
								</td>
								<td class="cart_quantity"><input type="number"
									id="${item.id}" value="${item.count }" size="2" min="0"
									onchange="onChange(${item.id},this.value)" /></td>
								<td class="cart_total">
									<p class="cart_total_price">
										<fmt:formatNumber type="number" groupingUsed="true"
											value="${item.count* item.price}" />
									</p>
								</td>
								<td class="cart_delete"><a class="cart_quantity_delete"
									onclick="deleteitem(${item.id})"><i
										class="fa fa-times"></i></a></td>
							</tr>
						</c:forEach>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td><a href="<c:url value="/thanh-toan"/>"><button
										type="button" class="btn btn-primary"><i class="fa fa-crosshairs"></i>Thanh toán</button></a></td>
						</tr>

					</tbody>
				</table>
			</div>
		</div>
	</section>
	<script type="text/javascript">
		function onChange(id,count) {
			window.location="chinh-sua?id="+id+"&&count="+count;
		}
	</script>
	<script type="text/javascript">
		function deleteitem(id) {
			if(confirm('Xóa cây giống này?'))
					{window.location="xoa?id="+id;}
			
		}
	</script>
	<!--/#cart_items-->
</body>