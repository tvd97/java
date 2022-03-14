<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglist.jsp"%>
<head>
<title>Đây là trang danh mục</title>
<style>
.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	font-size: 8px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>
</head>
<body>
	<section>
		<content tag="menuHead"> <%@include
			file="/WEB-INF/views/shared/user/menuHead.jsp"%>
		</content>
		<content tag="Search">
		<div class="search_box pull-right">
			<input type="text" placeholder="Search" />
		</div>
		</content>
		<div class="container">
			<div class="row">
				<%@include file="//WEB-INF/views/shared/user/menu.jsp"%>
				<div class="col-sm-9 padding-right">
					<div class="category-tab">
						<!--category-tab-->
						<div class="col-sm-12">
							<h2 class="title text-center">
								Cây
								<c:forEach var="item" items="${product}" varStatus="loop"><c:if test="${loop.first}">${item.nameSpecies }</c:if></c:forEach>
								giống
							</h2>
						</div>
						<div class="header-bottom">
							<!--header-bottom-->
							<div class="container">
								<div class="row">
									<div class="col-sm-3">
										<div class="search_box pull-right">
											<input type="text" placeholder="Search" /> <a><i
												class='fas fa-search'></i>Tìm kiếm</a>
										</div>

									</div>
								</div>
							</div>
						</div>
						<div class="tab-content">
							<div class="tab-pane fade active in" id="All">
								<c:forEach var="item" items="${product}">
									<div class="col-sm-3">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<a
														href='<c:url value="/san-pham/chi-tiet-san-pham/${item.id}"/>'><img
														class="card-img-top"
														src='<c:url value="/content/image/${item.img}"/>'
														alt="..."></a>

													<p>
														<fmt:formatNumber type="number" groupingUsed="true"
															value="${item.price}" />
														₫
													</p>
													<p>${item.name}</p>
													<div>
														<c:forEach begin="1" end="5" varStatus="loop">
															<c:if test="${loop.index<= item.rate}">
																<span class="fa fa-star checked"></span>
															</c:if>
															<c:if test="${loop.index>item.rate}">
																<span class="fa fa-star"></span>
															</c:if>
														</c:forEach>


													</div>
													<div>
														Tổng quan :
														<fmt:formatNumber type="number" maxIntegerDigits="3"
															value="${item.rate}" />
														<span class="fa fa-star checked"></span> <a href='<c:url value="/san-pham/chi-tiet-san-pham/${item.id}"/>'
															class="btn btn-default add-to-cart"><i
															class="fa fa-shopping-cart"
															></i> <small>Chi tiết</small></a>
													</div>

												</div>

											</div>
										</div>
									</div>
								</c:forEach>
							</div>

						</div>
					</div>
					<!--/category-tab-->
					<c:if test="${page.totalPage>1}">

						<div class="pagination">

							<a id="previous">&laquo;</a>
							<c:forEach var="item" begin="1" end="${page.totalPage}"
								varStatus="loop">
								<c:if test="${loop.index ==page.currentPage }">
									<a href='<c:url value="/trang-chu?page=${loop.index}"/>'
										class="active" id="urlActive">${loop.index}</a>
								</c:if>
								<c:if test="${loop.index !=page.currentPage }">
									<a href='<c:url value="/trang-chu?page=${loop.index}"/>'>${loop.index}</a>
								</c:if>
							</c:forEach>
							<a id="next">&raquo;</a>
						</div>

					</c:if>
				</div>
			</div>
		</div>
	</section>
</body>