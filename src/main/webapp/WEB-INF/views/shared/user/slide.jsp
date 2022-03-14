<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglist.jsp"%>
<section id="slider">
	<!--slider-->
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div id="slider-carousel" class="carousel slide"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#slider-carousel" data-slide-to="0"
							class="active"></li>
						<li data-target="#slider-carousel" data-slide-to="1"></li>
						<li data-target="#slider-carousel" data-slide-to="2"></li>
						<li data-target="#slider-carousel" data-slide-to="3"></li>
						<li data-target="#slider-carousel" data-slide-to="4"></li>
						<li data-target="#slider-carousel" data-slide-to="5"></li>
						<li data-target="#slider-carousel" data-slide-to="6"></li>
						<li data-target="#slider-carousel" data-slide-to="7"></li>
						<li data-target="#slider-carousel" data-slide-to="8"></li>
						<li data-target="#slider-carousel" data-slide-to="9"></li>
					</ol>
					<div class="carousel-inner">
						<c:forEach var="slide" items="${slides}" varStatus="index">

							<c:if test="${index.first}">
								<div class="item active">
							</c:if>
							<c:if test="${ not index.first}">
								<div class="item ">
							</c:if>
							<div class="col-sm-6">
								<h1>
									<span>E</span>-SHOPPER
								</h1>
								<h2>${slide.name}</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
									sed do eiusmod tempor incididunt ut labore et dolore magna
									aliqua.</p>
								<a href="<c:url value="/san-pham/product/${slide.id}"/>"><button
										type="button" class="btn btn-default get">Chi tiết</button></a>
							</div>
							<div class="col-sm-4">
								<div class="product-image-wrapper">
									<div class="single-products">
										<div class="productinfo text-center">
											<img
												src="<c:url value="/content/image/${slide.nameSpecies}/${slide.img}"/>"
												class="girl img-responsive" alt="" />
										</div>

									</div>

								</div>
							</div>
					</div>

					</c:forEach>
				</div>
				<a href="#slider-carousel" class="left control-carousel hidden-xs"
					data-slide="prev"> <i class="fa fa-angle-left"></i>
				</a> <a href="#slider-carousel" class="right control-carousel hidden-xs"
					data-slide="next"> <i class="fa fa-angle-right"></i>
				</a>
			</div>

		</div>
	</div>
</section>