<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<title>Nhà giống</title>
<style>
.pagination {
	display: flex;
	justify-content: center;
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
		<div class="container">
			<div class="row">
				<%@include file="//WEB-INF/views/shared/user/menu.jsp"%>
				<div class="col-sm-9 padding-right">
					<div class="category-tab">
						<!--category-tab-->
						<div class="col-sm-12">
							<h2 class="title text-center">Nhà vườn</h2>
						</div>
						<div class="tab-content">
							<div class="tab-pane fade active in" id="All">
								<c:forEach var="item" items="${farm}">
									<div class="col-sm-3">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<a
														href='<c:url value="/nha-giong/thong-tin-nha-vuon?id=${item.id}"/>'><img
														class="card-img-top"
														src='<c:url value="/content/logo/${item.logo}"/>'
														alt="..."></a>
													<p>${item.name }</p>
													<p>
														<small>Quận (Huyện): ${item.district}<br>
															Tỉnh (Thành): ${item.province}
														</small>
													</p>

												</div>

											</div>
										</div>
									</div>
								</c:forEach>
							</div>

						</div>
					</div>
					<!--/category-tab-->
					<div class="pagination">

						<a id="previous">&laquo;</a>
						<c:forEach var="item" begin="1" end="${page.totalPage}"
							varStatus="loop">
							<c:if test="${loop.index ==page.currentPage }">
								<a href='<c:url value="/nha-giong?page=${loop.index}"/>'
									class="active" id="urlActive">${loop.index}</a>
							</c:if>
							<c:if test="${loop.index !=page.currentPage }">
								<a href='<c:url value="/nha-giong?page=${loop.index}"/>'>${loop.index}</a>
							</c:if>
						</c:forEach>
						<a id="next">&raquo;</a>
					</div>

				</div>
			</div>
		</div>
	</section>


	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$('#previous')
									.click(
											function() {
												var url = window.location.href;
												var href = new URL(url);
												var page = href.searchParams
														.get("page");
												let rs = page - 1;
												window.location = '<c:url value="/nha-giong?page='
														+ rs + '"/>';

											});

						});
		$(document)
				.ready(
						function() {
							$('#next')
									.click(
											function() {
												var url = window.location.href;
												var href = new URL(url);
												var page = href.searchParams
														.get("page");
												let rs = Number(page) + 1;
												window.location = '<c:url value="/nha-giong?page='
														+ rs + '"/>';

											});

						});
	</script>
</body>