<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglist.jsp"%>

<head>
<meta charset="UTF-8">
<title>Thông tin đơn hàng</title>
<link href="<c:url value="/content/user/css/bill.css"/>"
	rel="stylesheet">
</head>
<body>
	<content tag="menuHead"> <%@include
		file="/WEB-INF/views/shared/user/menuHead.jsp"%>
	</content>
	<section id="cart_items">
		<div class="container">
			<div class="row">
				<%@include file="/WEB-INF/views/shared/user/menu.jsp"%>
				<div class="col-sm-9 padding-right">
					<h4 class="title text-center">Thông tin đơn hàng đã đặt</h4>
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
														Hệ thông cây giống Việt <br> Địa chỉ: 45 Ngô Quyền
														Sơn Trà Đà Nẵng<br> 0143294242
													</address>
												</div>
											</div>
											<!-- Row end -->
											<!-- Row start -->
											<div class="row gutters">
												<div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
													<div class="invoice-details">
														<address style="color: black;">
															${htritem.name}<br>Địa chỉ:${htritem.addr}<br>Số
															điện thoại:${htritem.phone}
														</address>
													</div>
												</div>
												<div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
													<div class="invoice-details">
														<div class="invoice-num" style="color: black;">
															<div>Ngày đặt: ${htritem.date}</div>
														</div>
													</div>
												</div>
											</div>
											<!-- Row end -->
										</div>
										<div class="invoice-body">
											<!-- Row start -->
											<div class="row gutters">
												<div class="col-lg-12 col-md-12 col-sm-12">
													<div class="table-responsive">
														<table class="table custom-table m-0">
															<thead>
																<tr>
																	<th>STT</th>
																	<th>Loại giống</th>
																	<th>Số lượng</th>
																	<th>Tổng tiền</th>
																</tr>
															</thead>
															<tbody>
																<c:set var="total" value="${0}" />
																<c:forEach var="item" items="${itemhtr}"
																	varStatus="loop">
																	<tr>
																		<td>${loop.index +1}</td>
																		<td>${item.seedling }</td>
																		<td>${item.count }</td>
																		<td><fmt:formatNumber type="number"
																				groupingUsed="true" value="${item.totalPrice}" />VND</td>
																	</tr>
																	<c:set var="total" value="${total + item.totalPrice}" />
																</c:forEach>


																<tr>
																	<td>Tổng tiền</td>
																	<td colspan="2"></td>
																	<td>

																		<h5 class="text-success">
																			<strong><fmt:formatNumber type="number"
																					groupingUsed="true" value=" ${total}" />VND</strong>
																		</h5>
																	</td>
																</tr>
																<tr>
																	<td></td>
																	<td colspan="2"></td>

																	<td><c:if test="${htritem.status==0 }">
																			<button class="" onclick="window.location.href='<c:url value="/don-hang/huy?id=${ htritem.id}"/>';">Hủy Đơn Hàng</button>
																		</c:if></td>
																</tr>
															</tbody>
														</table>
													</div>
												</div>
											</div>
											<!-- Row end -->
										</div>
										<div class="invoice-footer" style="color: red;">Cảm ơn
											bạn đã tin tưởng chúng tôi</div>
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
