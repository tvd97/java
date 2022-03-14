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
									<th><small>id</small></th>
									<th><small>Tên </small></th>
									<th><small>Loại</small></th>
									<th><small>giá</small></th>
									<th><small>lượt xem</small></th>
									<th><small>ảnh</small></th>
									<th><small>ảnh khác</small></th>
									<th><small>ngày tạo</small></th>
									<th><small>mô tả</small></th>
								</tr>
							</thead>
							<tbody>


								<c:forEach var="item" items="${data}">
									<tr id="row_${item.id}">
										<td><small>${item.id }</small></td>
										<td><small>${item.name }</small></td>
										<td><small>${item.species}</small></td>
										<td><small>${item.price}</small></td>
										<td><small>${item.views}</small></td>
										<td><small>${item.img }</small></td>
										<td></td>
										<td><small>${item.date}</small></td>
										<td><small>${item.charactic}</small></td>
										<td><small><button class="btn btn-link btn-sm" onclick="editItme(${item.id})">
													<i class='fas fa-edit' style="color: red"></i>
												</button>
												<button class="btn btn-link btn-sm"
													onclick="deleteItme(${item.id})">
													<i class="fa fa-remove" style="color: red"></i>
												</button></small></td>
									</tr>
								</c:forEach>
								<tr>
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
		if(confirm("Xóa cây giống này!"))
			{
			window.location='<c:url value="/quan-ly/san-pham/xoa?id='+id+'"/>';
			}
		
		
	}
	function editItme(id) {
		
			window.location='<c:url value="/quan-ly/san-pham/chinh-sua?id='+id+'"/>';
		
		
		
	}
	</script>
</body>