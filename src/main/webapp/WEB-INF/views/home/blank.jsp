<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
<title>Trang Chủ</title>
</head>
<body>
	<section>
	<content tag="menuHead"> <%@include
		file="/WEB-INF/views/shared/user/menuHead.jsp"%>
	</content>
		<div class="container">
			<div class="row">
				<%@include file="//WEB-INF/views/shared/user/menu.jsp"%>
				<div class="col-sm-9 padding-right">

					<div class="category-tab">
						<!--category-tab-->
						<div class="col-sm-12">
							<h2 class="title text-center">Cay giong</h2>
						</div>
						<div class="tab-content">
							Danh mục chưa có sản phẩm
						</div>
					</div>
					<!--/category-tab-->
					

				</div>
			</div>
		</div>
	</section>	
</body>