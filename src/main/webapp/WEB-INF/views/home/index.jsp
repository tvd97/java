<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglist.jsp"%>
<head>
<title>Trang Chủ</title>
</head>
<body>
	<content tag="menuHead"> <%@include
		file="/WEB-INF/views/shared/user/menuHead.jsp"%>
	</content>
	<content tag="Search">
	<div class="search_box pull-right">
		<input type="text" placeholder="Search" name="search"
			oninput="search(this)" />
	</div>
	</content>
	<section>
		<div class="container">
			<div class="row">
				<%@include file="/WEB-INF/views/shared/user/menu.jsp"%>
				<div class="col-sm-9 padding-right">
					<!--/category-tab-->
					<div class="recommended_items">
						<!--recommended_items-->
						<h2 class="title text-center">Cây giống được đánh giá cao</h2>

						<div id="recommended-item-carousel" class="carousel slide"
							data-ride="carousel">
							<div class="carousel-inner">
								<div class="item active">
									<c:forEach var="item" items="${rateproduct }" varStatus="loop">
										<div class="col-sm-4">
											<div class="product-image-wrapper">
												<div class="single-products">
													<div class="productinfo text-center">
														<a
															href='<c:url value="/san-pham/chi-tiet-san-pham/${item.id}"/>'><img
															class="card-img-top"
															src='<c:url value="/content/image/${item.img}"/>'
															alt="..."></a>
														<h2>
															<fmt:formatNumber type="number" groupingUsed="true"
																value="${item.price}" />
															₫
														</h2>
														<p>${item.name}</p>
														<div>
															<c:forEach begin="1" end="5" varStatus="key">
																<c:if test="${key.index<= item.rate}">
																	<span class="fa fa-star checked"></span>
																</c:if>
																<c:if test="${key.index>item.rate}">
																	<span class="fa fa-star"></span>
																</c:if>
															</c:forEach>


														</div>
														<a href='<c:url value="/san-pham/chi-tiet-san-pham/${item.id}"/>' class="btn btn-default add-to-cart"><i
															class="fa fa-shopping-cart"></i>Chi tiết</a>
													</div>

												</div>
											</div>
										</div>
										<c:if test="${(loop.index +1)%3==0 and not loop.last }">
								</div>
								<div class="item">
									</c:if>
									<c:if test="${loop.last }">
								</div>
								</c:if>
								</c:forEach>
							</div>
							<a class="left recommended-item-control"
								href="#recommended-item-carousel" data-slide="prev"> <i
								class="fa fa-angle-left"></i>
							</a> <a class="right recommended-item-control"
								href="#recommended-item-carousel" data-slide="next"> <i
								class="fa fa-angle-right"></i>
							</a>
						</div>
					</div>
					<!--/recommended_items-->
					<div class="recommended_items">
						<!--recommended_items-->
						<h2 class="title text-center">Cây giống được xem nhiều</h2>

						<div id="recommended-item-carousel" class="carousel slide"
							data-ride="carousel">
							<div class="carousel-inner">
								<div class="item active">
									<c:forEach var="item" items="${viewproduct }" varStatus="loop">
										<div class="col-sm-4">
											<div class="product-image-wrapper">
												<div class="single-products">
													<div class="productinfo text-center">
														<a
															href='<c:url value="/san-pham/chi-tiet-san-pham/${item.id}"/>'><img
															class="card-img-top"
															src='<c:url value="/content/image/${item.img}"/>'
															alt="..."></a>
														<h2>
															<fmt:formatNumber type="number" groupingUsed="true"
																value="${item.price}" />
															₫
														</h2>
														<p>${item.name}</p>
														<p>Lượt xem: ${item.viewCount}</p>
														<a href='<c:url value="/san-pham/chi-tiet-san-pham/${item.id}"/>'class="btn btn-default add-to-cart"><i
															class="fa fa-shopping-cart"></i>Chi tiết</a>
													</div>

												</div>
											</div>
										</div>
										<c:if test="${(loop.index +1)%3==0 and not loop.last }">
								</div>
								<div class="item">
									</c:if>
									<c:if test="${loop.last }">
								</div>
								</c:if>
								</c:forEach>
							</div>
							<a class="left recommended-item-control"
								href="#recommended-item-carousel" data-slide="prev"> <i
								class="fa fa-angle-left"></i>
							</a> <a class="right recommended-item-control"
								href="#recommended-item-carousel" data-slide="next"> <i
								class="fa fa-angle-right"></i>
							</a>
						</div>
					</div>
					<!--/recommended_items-->
					<div class="recommended_items">
						<!--recommended_items-->
						<h2 class="title text-center">Cây giống mới nhất</h2>

						<div id="recommended-item-carousel" class="carousel slide"
							data-ride="carousel">
							<div class="carousel-inner">
								<div class="item active">
									<c:forEach var="item" items="${newproduct }" varStatus="loop">
										<div class="col-sm-4">
											<div class="product-image-wrapper">
												<div class="single-products">
													<div class="productinfo text-center">
														<a
															href='<c:url value="/san-pham/chi-tiet-san-pham/${item.id}"/>'><img
															class="card-img-top"
															src='<c:url value="/content/image/${item.img}"/>'
															alt="..."></a>
														<h2>
															<fmt:formatNumber type="number" groupingUsed="true"
																value="${item.price}" />
															₫
														</h2>
														<p>${item.name}</p>
														<p>
															<b>Ngày đăng:</b> ${item.dateCreate }
														</p>
														<a href='<c:url value="/san-pham/chi-tiet-san-pham/${item.id}"/>' class="btn btn-default add-to-cart"><i
															class="fa fa-shopping-cart"></i>Chi tiết</a>
													</div>

												</div>
											</div>
										</div>
										<c:if test="${(loop.index +1)%3==0 and not loop.last }">
								</div>
								<div class="item">
									</c:if>
									<c:if test="${loop.last }">
								</div>
								</c:if>
								</c:forEach>
							</div>
							<a class="left recommended-item-control"
								href="#recommended-item-carousel" data-slide="prev"> <i
								class="fa fa-angle-left"></i>
							</a> <a class="right recommended-item-control"
								href="#recommended-item-carousel" data-slide="next"> <i
								class="fa fa-angle-right"></i>
							</a>
						</div>
					</div>
					<!--/recommended_items-->

				</div>
			</div>
		</div>
	</section>

	<content tag="Script"> <script type="text/javascript">
		$(document).ready(
				function() {
					$('#previous').click(
							function() {
								var url = window.location.href;
								var href = new URL(url);
								var page = href.searchParams.get("page");
								let rs = page - 1;
								window.location = url.substring(0, url
										.search("page"))
										+ 'page=' + rs;

							});

				});
		$(document).ready(
				function() {
					$('#next').click(
							function() {
								var url = window.location.href;
								var href = new URL(url);
								var page = href.searchParams.get("page");
								let rs = Number(page) + 1;
								window.location = url.substring(0, url
										.search("page"))
										+ 'page=' + rs;

							});

				});
	</script> <script type="text/javascript">
		function search(input) {
			var dataSend = {};
			dataSend["search"] = input.value;
			console.log(input.value);
			$.ajax({
						type : "GET",
						url : '<c:url value="/tim-kiem"/>',
						dataType : 'json',
						data : dataSend,
						success : function(res) {

							result = '<div class="category-tab"><!--category-tab-->';
							result += '<div class="col-sm-12"><h2 class="title text-center">Tìm kiếm</h2></div>';
							result += '<div class="tab-content">';
							result += '<div class="tab-pane fade active in" id="All">';
							$.each(res,function(k, v) {
												result += '<div class="col-sm-3">';
												result += '<div class="product-image-wrapper">';
												result += '<div class="single-products">';
												result += '<div class="productinfo text-center">';
												result += '<a href='
														+ '<c:url value="/san-pham/chi-tiet-san-pham/'+v.id+'"/>'+'>';
												result += '<img class="card-img-top" src='
														+ '<c:url value="/content/image/'+v.img+'"/>'
														+ ' alt="..."></a>';
												result += '<p>' + v.price
														+ '"₫</p><p><small>' + v.name
														+ '</small></p><div>';
														for(var i=1;i<=5;i++)
															{
															if(i<=parseInt(v.rate))
																result +='<span class="fa fa-star checked"></span>';
															else
																result +='<span class="fa fa-star "></span>';
															}
														
												result += ' </div><div><a href='
													+ '<c:url value="/san-pham/chi-tiet-san-pham/'+v.id+'"/>';
													result+=' class="btn btn-default add-to-cart">';
												result += '<i class="fa fa-shopping-cart" onclick="addProduct('
														+ v.id + ')">';
												result += '</i> <small>Chi tiết</small></a>';
												result += '</div></div></div></></div></div>';
											});
							result += '</div></div></div>';
							$('.padding-right').html(result);
						}

					});
		}
	</script></content>

</body>