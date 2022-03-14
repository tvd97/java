<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglist.jsp"%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/content/user/css/bill.css"/>"
	rel="stylesheet">
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
				<div class="row gutters">
					<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
						<div class="card">
							<div class="card-body p-0">
								<div class="invoice-container">
									<div class="invoice-header">
										<!-- Row start -->
										<div class="row gutters">
											<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6">
												<a href="index.html" class="invoice-logo"> Thông tin
													người nhận </a>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-6">
												<address class="text-right">
													Hệ thông cây giống Việt <br> Địa chỉ: 45 Ngô Quyền Sơn
													Trà Đà Nẵng<br> 0143294242
												</address>
											</div>
										</div>
										<!-- Row end -->
										<!-- Row start -->
										<div class="row gutters">
											<div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
												<div class="invoice-details">
													<address>${data.addr}</address>
												</div>
											</div>
											<div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
												<div class="invoice-details">
													<div class="invoice-num">
														<div>Invoice - #009</div>
														<div>10-10-2021</div>
													</div>
												</div>
											</div>
										</div>
										<!-- Row end -->
									</div>
									<div class="invoice-body">
										<!-- Row start -->
										<div class="row gutters">

											<div class="table-responsive">
												<table class="table custom-table m-0">
													<thead>
														<tr>
															<th>Loại cây</th>
															<th>Mã cây</th>
															<th>Số lượng</th>
															<th>Tổng tiền</th>
														</tr>
													</thead>
													<tbody>
														<c:set var="total" value="${0}" />
														<c:forEach var="item" items="${order}">
															<tr>
																<td>${item.name}
																	<p class="m-0 text-muted"></p>
																</td>
																<td>#${item.id_product }</td>
																<td>${item.count }</td>
																<td><fmt:formatNumber type="number" groupingUsed="true" value="${item.price*item.count}"/>VND</td>
																<c:set var="total" value="${total + item.price*item.count}" />
															</tr>
														</c:forEach>
														<tr>
															<td>&nbsp;</td>
															<td colspan="2">
																<p>
																	Tổng<br> Vận chuyển 
																</p>
																<h5 class="text-success">
																	<strong>Tổng tiền</strong>
																</h5>
															</td>
															<c:set var="shipping" value="30000"></c:set>
															<td>
																<p>
																	<fmt:formatNumber type="number" groupingUsed="true" value="${total}"/>VND<br>
																	 <fmt:formatNumber type="number" groupingUsed="true" value="${shipping}"/>VND

																</p>
																<h5 class="text-success">
																	<strong><fmt:formatNumber type="number" groupingUsed="true" value="${total+shipping}"/>VND</strong>
																</h5>
															</td>
														</tr>
													</tbody>
												</table>
											</div>

										</div>
										<!-- Row end -->
									</div>
									<div class="invoice-footer">Thank you for your Business.
									</div>
								</div>
							</div>
						</div>
					</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
