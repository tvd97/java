<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglist.jsp"%>
<div class="col-sm-3">
	<div class="left-sidebar">
		<h2>Danh mục</h2>
		<div class="panel-group category-products" id="accordian">
			<!--category-productsr-->
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian"
							href="#sportswear"> <span class="badge pull-right"><i
								class="fa fa-plus"></i></span> Cây giống
						</a>
					</h4>
				</div>
				<div id="sportswear" class="panel-collapse collapse">
					<div class="panel-body">
						<ul>
							<li><a href='<c:url value="/san-pham/tat-ca"/>'>Tất cả</a></li>
							<c:forEach var="item" items="${species}">
								<li><a href='<c:url value="/san-pham/${item.id}"/>'>${item.name}</a></li>
							</c:forEach>

						</ul>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a href='<c:url value="/nha-giong?page=1"></c:url>'>Nhà giống</a>
					</h4>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#mens">
							<span class="badge pull-right"><i class="fa fa-plus"></i></span>
							Quản lý
						</a>
					</h4>
				</div>
				<div id="mens" class="panel-collapse collapse">
					<div class="panel-body">
						<ul>
							<li><a href="#">Cây giống</a></li>
							<li><a href="#">Nhà vườn</a></li>
						
						</ul>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a href="<c:url value="/quan-ly/"/>">Quản trị website</a>
					</h4>
				</div>
			</div>
		</div>
		<!--/category-products-->
		<div class="shipping text-center">
			<!--shipping-->
			<img src="images/home/shipping.jpg" alt="" />
		</div>
		<!--/shipping-->

	</div>
</div>