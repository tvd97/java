<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglist.jsp"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<head>
<meta charset="UTF-8">
<title>Chi tiết cây giống</title>
<style type="text/css">
.checked {
	color: orange;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<body>
	<content tag="menuHead"> <%@include
		file="/WEB-INF/views/shared/user/menuHead.jsp"%>
	</content>
	<section>
		<div class="container">
			<div class="row">
				<%@include file="//WEB-INF/views/shared/user/menu.jsp"%>
				<div class="col-sm-9 padding-right">
					<div class="product-details">
						<!--product-details-->
						<div class="col-sm-5">
							<div class="view-product">
								<img
									src="<c:url value="/content/image/${product.img}"/>"
									alt="" />

							</div>
							<div id="similar-product" class="carousel slide"
								data-ride="carousel">
								<!-- Wrapper for slides -->
								<div class="carousel-inner">
									<c:set var="img" value='${fn:split(product.moreImg, ",")}' />
									<c:forEach var="imgitem" items="${img }" varStatus="index">
										<c:if test="${index.first}">
											<div class="item active">
										</c:if>
										<c:if test="${not index.first}">
											<div class="item">
										</c:if>
										<a> <img style="width: 50px; hight: 50px;"
											src="<c:url value="/content/image/${product.nameSpecies}/${imgitem}"/>" />
								</div>
								</c:forEach>
							</div>
							<!-- Controls -->
							<a class="left item-control" href="#similar-product"
								data-slide="prev"> <i class="fa fa-angle-left"></i>
							</a> <a class="right item-control" href="#similar-product"
								data-slide="next"> <i class="fa fa-angle-right"></i>
							</a>
						</div>
					</div>
					<div class="col-sm-7">
						<div class="product-information">
							<!--/product-information-->
							<img src="images/product-details/new.jpg" class="newarrival"
								alt="" />
							<h2>${product.name }</h2>
							<p>ID: ${product.id }</p>
							<img src="images/product-details/rating.png" alt="" /> <span>
								<span><fmt:formatNumber type="number" groupingUsed="true"
										value="${product.price}" /> ₫</span> <label>Số lượng:</label> <input
								type="number" value="1" id="count" />
								<button type="button" class="btn btn-outline cart"
									onclick="addProduct(${product.id});">
									<i class="fa fa-shopping-cart"></i> Thêm vào giỏ hàng
								</button>
							</span>
							<p>
								<b>Loại giống:</b> ${product.nameSpecies }
							</p>
							<p>
								<b>Ngày đăng:</b> ${product.dateCreate }
							</p>
							<p>
								<b>Nhà giống:</b> ${product.nameFarm}
							</p>
							<p>
								<b>Lượt xem:</b> ${product.viewCount}
							</p>
							<a href=""><img src="images/product-details/share.png"
								class="share img-responsive" alt="" /></a>
						</div>
						<!--/product-information-->
					</div>
				</div>
				<!--/product-details-->
				<div class="category-tab shop-details-tab">
					<!--category-tab-->
					<div class="col-sm-12">
						<ul class="nav nav-tabs">
							<li><a href="#details" data-toggle="tab">Thông tin</a></li>
							<li><a href="#companyprofile" data-toggle="tab">Liên
									quan</a></li>
							<li><a href="#rate" data-toggle="tab">Đánh giá</a></li>
							<li class="active"><a href="#reviews" data-toggle="tab">Bình
									luận</a></li>
						</ul>
					</div>
					<div class="tab-content">
						<div class="tab-pane fade" id="details">
							<h4 class="title text-center">Chi tiết Cây giống</h4>
							<div style="margin-left: 40px;">
								<h6>Tên cây giống:</h6>
								<br>
								<p>${product.name}</p>
								Loại giông:
								<h6></h6>
								<br>
								<p>${product.nameSpecies}</p>
								<h6>Mô tả:</h6>
								<br>
								<p>${product.characteristic}</p>

							</div>
							<h4 class="title text-center">Trồng và chăm sóc</h4>
							<div style="margin-left: 40px;">


								<p>${product.care }</p>

							</div>


						</div>

						<div class="tab-pane fade" id="companyprofile">
							<div class="col-sm-3">
								<div class="product-image-wrapper">
									<div class="single-products">
										<div class="productinfo text-center">
											<img src="images/home/gallery1.jpg" alt="" />
											<h2>$56</h2>
											<p>Easy Polo Black Edition</p>
											<button type="button" class="btn btn-default add-to-cart">
												<i class="fa fa-shopping-cart"></i>Add to cart
											</button>
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-3">
								<div class="product-image-wrapper">
									<div class="single-products">
										<div class="productinfo text-center">
											<img src="images/home/gallery3.jpg" alt="" />
											<h2>$56</h2>
											<p>Easy Polo Black Edition</p>
											<button type="button" class="btn btn-default add-to-cart">
												<i class="fa fa-shopping-cart"></i>Add to cart
											</button>
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-3">
								<div class="product-image-wrapper">
									<div class="single-products">
										<div class="productinfo text-center">
											<img src="images/home/gallery2.jpg" alt="" />
											<h2>$56</h2>
											<p>Easy Polo Black Edition</p>
											<button type="button" class="btn btn-default add-to-cart">
												<i class="fa fa-shopping-cart"></i>Add to cart
											</button>
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-3">
								<div class="product-image-wrapper">
									<div class="single-products">
										<div class="productinfo text-center">
											<img src="images/home/gallery4.jpg" alt="" />
											<h2>$56</h2>
											<p>Easy Polo Black Edition</p>
											<button type="button" class="btn btn-default add-to-cart">
												<i class="fa fa-shopping-cart"></i>Add to cart
											</button>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="tab-pane fade" id="rate">
							Đánh giá:
							<c:forEach begin="1" end="5" varStatus="loop">
								<c:if test="${loop.index<= product.rate}">
									<span class="fa fa-star checked"></span>
								</c:if>
								<c:if test="${loop.index>product.rate}">
									<span class="fa fa-star"></span>
								</c:if>
							</c:forEach>
							<br>
							<fmt:formatNumber type="number" maxIntegerDigits="3"
								value="${product.rate}" />
							<span class="fa fa-star checked"></span> trung bình trên tổng số
							${rate.size()} đánh giá<span class="fa fa-star checked"></span> <span
								class="fa fa-star checked"></span> <span
								class="fa fa-star checked"></span> <span
								class="fa fa-star checked"></span> <span
								class="fa fa-star checked"></span> <br>
							<div class="col-sm-12">
								<ul id="listrate">
									<c:forEach var="item" items="${rate}">
										<li><i class="fa fa-user"></i>${item.name}:
											${item.content}</li>
									</c:forEach>
								</ul>

								<p>
									<b>Để lại danh gia cua ban</b>
								</p>


								<div class="form-group">
									<label for="exampleFormControlInput1">Ten:</label> <input
										type="text" placeholder="Your Name" id='namerate' />
								</div>
								<div class="form-group">
									<label for="exampleFormControlInput1">Noi dung:</label>
									<textarea id="ratecontent"></textarea>				
								</div>
								Đánh giá
								<p style="display: flex;">
									<span class="fa fa-star fa-2x" data-index="0"></span> <span
										class="fa fa-star fa-2x" data-index="1"></span> <span
										class="fa fa-star fa-2x" data-index="2"></span> <span
										class="fa fa-star fa-2x" data-index="3"></span> <span
										class="fa fa-star fa-2x" data-index="4"></span>
								</p>


								<button type="button" class="btn btn-default pull-right"
									onclick="saveRate();">Đăng</button>

							</div>

						</div>
						<div class="tab-pane fade active in" id="reviews">
							<div class="col-sm-12">
								<ul id="listcmt">
									<li><a href=""><i class="fa fa-user"></i></a></li>
									<%
									Date date = new Date();
									out.print("<li><a href=''><i class='fa fa-clock-o'></i>" + date.toString() + "</a></li>");
									%>

								</ul>

								<p>
									<b>Để lại bình luận của bạn</b>
								</p>

								<div class="form-group">
									<label for="exampleFormControlInput1">Ten:</label> <input
										type="text" placeholder="Your Name" id='namecmt' />
								</div>
								<div class="form-group">
									<label for="exampleFormControlInput1">Noi dung:</label>
									<textarea id="cmt"></textarea>				
								</div>
								<button type="button" class="btn btn-default pull-right"
									onclick="saveCmt();">Đăng</button>

							</div>
						</div>
					</div>


				</div>

			</div>
		</div>
		<!--/category-tab-->
	</section>
	<content tag="Script"> <script type="text/javascript">
	function addProduct(id_product) {
		var count=$('#count').val();
		window.location='<c:url value="/them?id_product='+id_product+'&count='+count+'"/>';
	}
	
	</script> <script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script> <script type="text/javascript">
			var rateIndex=-1;
			$(document).ready(function () {
				$('.fa-star').on('click',function () {
					rateIndex= parseInt($(this).data('index'));	
				});
				$('.fa-star').mouseover(function () {
					resetColor();			
					var currentIndex= parseInt($(this).data('index'));
					for(var i=0;i<=currentIndex;i++)
						{				
							$('.fa-star[data-index="'+i+'"]').css('color','orange');
						}					
				});
				$('.fa-star').mouseleave(function () {
					resetColor();
					if(rateIndex!=-1)
						{
							for(var i=0;i<=rateIndex;i++)
							{			
								$('.fa-star[data-index="'+i+'"]').css('color','orange');
							}
						}					
				});	
			});
				function resetColor() {
					$('.fa-star').css('color','black');
				}
				function saveRate() {
					var dataSend={};
					dataSend["rate"]=rateIndex;
					dataSend["id_product"]=String(${product.id });
					dataSend["comment"]=$('#cmt').val();
					dataSend["name"]=$('#namerate').val();
					$.ajax({
						type : "GET",
						url : '<c:url value="/danh-gia"/>',
						dataType : 'json',	
						data :dataSend,			
						success : function(res) {
							var result='<ul id="listcmt">';
							$.each(res,function(k,v){
								result+='<li>'+k+v+'</li>';
								});
							result+='</ul>';
							$('#listcmt').html(result);
						}
					});			
				}
				function saveCmt() {
					var dataSend={};
					dataSend["id_product"]=String(${product.id });
					dataSend["comment"]=$('#cmt').val();
					dataSend["name"]=$('#namecmt').val();
					$.ajax({
						type : "GET",
						url : '<c:url value="/binh-luan"/>',
						dataType : 'json',	
						data :dataSend,			
						success : function(res) {
							var result='<ul id="listcmt">';
							$.each(res,function(k,v){
								result+='<li>'+v.name+':'+v.comment'</li>';
								});
							result+='</ul>';
							$('#listcmt').html(result);
						}
					});			
				}
	
	</script></content>



</body>