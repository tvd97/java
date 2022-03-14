<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglist.jsp"%>
<div class="col-sm-3">
	<div class="left-sidebar">
		<h2>Chức năng</h2>
		<div class="panel-group category-products" id="accordian">
			<!--category-productsr-->
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian"
							href="#sportswear"> <span class="badge pull-right"><i
								class="fa fa-plus"></i></span> Quản lý cây giống
						</a>
					</h4>
				</div>
				<div id="sportswear" class="panel-collapse collapse">
					<div class="panel-body">
						<ul>
							<li><a href='<c:url value="/quan-ly/them"/>'>Thêm</a></li>
							<li><a href='<c:url value="/quan-ly/san-pham/tat-ca"/>'>Tất
									cả</a></li>
							<c:forEach var="item" items="${species}">
								<li><a
									href='<c:url value="/quan-ly/san-pham/${item.id }"/>'>${item.name}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#mens">
							<span class="badge pull-right"><i class="fa fa-plus"></i></span>
							Quản lý đơn hàng
						</a>
					</h4>
				</div>
				<div id="mens" class="panel-collapse collapse">
					<div class="panel-body">
						<ul>
							<li><a href="<c:url value="/quan-ly/don-hang/chua-duyet"/>">Chưa
									duyệt</a></li>
							<li><a href="<c:url value="/quan-ly/don-hang/da-duyet"/>">Đã
									duyệt</a></li>

						</ul>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-parent="#accordian"
							href="<c:url value="/quan-ly/tai-khoan"/>"> <span
							class="badge pull-right"><i class="fa fa-plus"></i></span> Quản
							lý tài khoản
						</a>
					</h4>
				</div>

			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a href="<c:url value="/quan-ly/nha-giong"/>">Quản lý nhà giống
							liên kết</a>
					</h4>
				</div>
			</div>
		</div>
		<!--/category-products-->
	</div>
</div>
