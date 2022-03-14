<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglist.jsp"%>

<head>
<meta charset="UTF-8">
<title>Thanh toan</title>
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
						<!--category-tab-->
						<div class="col-sm-12">
							<h2 class="title text-center">Thong tin nguoi nhan</h2>
						</div>
						<div class="tab-content">
							<div class="form-group row">
								<label for="inputName" class="col-sm-2 col-form-label">Họ
									tên người nhận</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputName"
										placeholder="Name" name="name" />
								</div>
							</div>
							<div class="form-group row">
								<label for="inputAddress" class="col-sm-2 col-form-label">Địa
									chỉ</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputAddress"
										placeholder="Address" name="address" />
								</div>
							</div>
							<div class="form-group row">
								<label for="inputPhone" class="col-sm-2 col-form-label">Số
									điện thoại</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputPhone"
										placeholder="Phone" name="phone" />
								</div>
							</div>
							<div class="form-group row">
								<label for="inputNote" class="col-sm-2 col-form-label">Ghi
									chú</label>
								<div class="col-sm-10">
									<textarea type="text" class="form-control" rows="5" cols="15"
										id="inputNote" placeholder="Note" name="note"></textarea>
								</div>
							</div>
							<div class="table-responsive cart_info">
								<table class="table table-condensed">
									<thead>
										<tr class="cart_menu">
											<th class="image"></th>
											<th class="description">Tên cây giống</th>
											<th class="price">Giá</th>
											<th class="quantity">Số lượng</th>
											<th class="total">Tổng</th>
											<th></th>
										</tr>
									</thead>
									<tbody>


										<c:forEach var="item" items="${billitem }" varStatus="index">
											<tr id="row_${item.id}">
												<td class="cart_product"><a
													href="<c:url value="/san-pham/chi-tiet-san-pham/${item.id_product}"/>"><img
														src="<c:url value="/content/img/${item.img}"/>" alt=""></a></td>
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
													onchange="changData(this.value,${index.index})" /></td>
												<td class="cart_total">
													<p class="cart_total_price">
														<fmt:formatNumber type="number" groupingUsed="true"
															value="${item.count* item.price}" />
													</p>

												</td>
												<td class="cart_delete"><button
														class="cart_quantity_delete"
														onclick="deleteItem(${item.id})">
														<i class="fa fa-times" style="color: red"></i>
													</button></td>
											</tr>
										</c:forEach>
										<c:set var="total">
											<c:forEach var='item' items='${order }'>

												<c:set var="total" value="${item.count* item.price}">
												</c:set>
											</c:forEach>


										</c:set>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>${total }</td>
											<td><button
														type="button" class="btn btn-primary" onclick="sendData()">Đặt hàng</button></td>
										</tr>

									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<content tag="Script"> <script type="text/javascript">
		function changData(val, index) {
			var dataSend = {};
			dataSend["count"] = val;
			dataSend["index"] = index;
			$.ajax({
					type : "GET",
					url : '<c:url value="/sua/order"/>',
					dataType : 'json',
					data : dataSend,
					success : function(res) {
						var result = '<tbody>';
						$.each(res,function(k, v) {
							result += '<tr id="row_'+v.id+'"><td class="cart_product"><a href="<c:url value="/san-pham/chi-tiet-san-pham/'+v.id_product+'"/>"><img src="<c:url value="/content/img/'+v.img+'"/>" alt=""></a></td>';
							result += '<td class="cart_description"><h4><a href="">'+ v.name+'</a></h4><p>ID: '+ v.id_product+'</p></td>';
							result += '<td class="cart_price"><p>'+ v.price + '</p></td>';
							result += '<td class="cart_quantity"><input type="number" id="'+ v.id+ '" value="'+ v.count+ '" size="2" min="0" onchange="changData(this.value,'+k+')" /></td>';
							result += '<td class="cart_total"><p class="cart_total_price">'+ v.count* v.price+ '</p></td>';
							result += '<td class="cart_delete"><button class="cart_quantity_delete" onclick="deleteItem('+ v.id+ ')"><i class="fa fa-times" style="color: red"></button></td>';
							result += '</tr>';						
						});
						result+='<tr><td></td><td></td><td></td><td></td><td>${total }</td><td><button type="button" class="btn btn-primary" onclick="sendData()">Đặt hàng</button></td></tr>';
						result += '</tbody>';
						$('.table-condensed').html(result);
						}
					});
		}
	</script> <script type="text/javascript">
	function deleteItem(index) {
		var dataSend = {};
		dataSend["index"] = index;
		if(confirm('Xoá item này'))
			{
			$.ajax({
					type : "GET",
					url : '<c:url value="/xoa/order"/>',
					dataType : 'json',
					data : dataSend,
					success : function(res) {
						$('#row_'+index).remove();
					}
					});
				}
		
	}
	</script> <script type="text/javascript">
function sendData() {
	var name = document.getElementById('inputName').value;
	var address = document.getElementById('inputAddress').value;
	var phone = document.getElementById('inputPhone').value;
	var note = document.getElementById('inputNote').value;
	window.location.href='<c:url value="/hoan-tat-dat-hang?name='+name+'&address='+address+'&phone='+phone+'&note='+note+'"/>';
}
	
	</script> </content>
</body>