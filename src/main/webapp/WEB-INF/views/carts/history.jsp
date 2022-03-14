<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglist.jsp"%>
<head>
<title>Lịch sử mua hàng</title>
</head>
<body>
	<content tag="menuHead"> <%@include
		file="/WEB-INF/views/shared/user/menuHead.jsp"%>
	</content>
	<content tag="Search">
	<div class="search_box pull-right">
		<input type="text" placeholder="Search" />
	</div>
	</content>
	<section>
		<div class="container">
			<div class="row">
				<%@include file="/WEB-INF/views/shared/user/menu.jsp"%>
				<div class="col-sm-9 padding-right">
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
								</tr>
							</thead>
							<tbody>
								<c:set var="date1" value="<%=new java.util.Date()%>" />
								<c:forEach var="item" items="${htr }">
									<tr>
										<td><a
											href='<c:url value="/lich-sua-mua-hang/chi-tiet?id=${item.id}"/>'>#${item.id}</a></td>
										<td>${item.name}</td>
										<td>${item.date}</td>
										<td>${item.addr}</td>
										<td>${item.phone}</td>
										<c:if test="${item.status==1}">
											<td style="color: green;">Thành công</td>
										</c:if>
										<c:if test="${item.status==0}">
											<td style="color: orange;">Đang chờ</td>
										</c:if>
										<c:if test="${item.status==-1}">
											<td style="color: red;">Bị hủy</td>
										</c:if>
										<c:if test="${item.status==-2}">
											<td style="color: red;">Đơn đã hủy</td>
										</c:if>
									</tr>

								</c:forEach>



							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>