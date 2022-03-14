<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglist.jsp"%>
<head>
<title>Insert title here</title>
</head>
<body>
	<content tag="menuHead"> <%@include
		file="/WEB-INF/views/shared/user/menuHead.jsp"%>
	</content>
	<section>
		<div class="container">
			<div class="row">
			<%@include file="/WEB-INF/views/manage/menu.jsp"%>
				<div class="col-sm-9 padding-right">
					<form:form method="POST" action="upload"
						enctype="multipart/form-data" modelAttribute="model">
						<div class="form-group">
							<label for="exampleFormControlInput1">Tên cây giống</label>
							<form:input type="text" class="form-control" id="name"
								placeholder="nhập tên" name="name" path="name" />
						</div>
						<div class="form-group">
							<label for="exampleFormControlSelect1">Loại giống</label>
							<form:select class="form-control" id="species" name="species"
								path="species">
								<option value="NONE">Chọn loại giống</option>
								<c:forEach var="item" items="${species }">
									<form:option value="${item.id }">${item.name}</form:option>
								</c:forEach>

							</form:select>
						</div>
						<div class="form-group">
							<label for="exampleFormControlSelect1">Thuộc trại</label>
							<form:select class="form-control" id="farm" name="farm"
								path="farm">
								<option value="0">Chọn nhà giống</option>
								<c:forEach var="item" items="${farm }">
									<form:option value="${item.id }">${item.name}</form:option>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-group">
							<label for="exampleFormControlInput1">Giá</label>
							<form:input type="number" class="form-control" id="price"
								placeholder="Nhập giá bán" name="price" path="price" />
						</div>
						<div class="form-group">
							<label for="exampleFormControlInput1">Ảnh chính</label>
							<form:input type="file" class="form-control" id="img"
								placeholder="Chọn file" multiple="multiple" name="img"
								path="image" />
						</div>
						<div class="form-group">
							<label for="exampleFormControlInput1">Các ảnh khác</label>
							<form:input type="file" class="form-control" id="moreImg"
								placeholder="Chọn file" name="moreImg" path="moreImage" />
							<form:input type="file" class="form-control" id="moreImg"
								placeholder="Chọn file" name="moreImg" path="moreImage" />
							<form:input type="file" class="form-control" id="moreImg"
								placeholder="Chọn file" name="moreImg" path="moreImage" />
							<form:input type="file" class="form-control" id="moreImg"
								placeholder="Chọn file" name="moreImg" path="moreImage" />
						</div>
						<div class="form-group">
							<label for="exampleFormControlTextarea1">Mô tả</label>
							<form:textarea class="form-control" id="characteristic" rows="3"
								placeholder="Mô tả" name="characteristic" path="characteristic"></form:textarea>
						</div>
						<div class="form-group">
							<label for="exampleFormControlTextarea1">Cách chăm sóc</label>
							<form:textarea class="form-control" id="care" rows="3"
								name="care" placeholder="Cách chăm sóc" path="care"></form:textarea>
						</div>
						<button type="submit" class="btn btn-primary">Thêm mới</button>
					</form:form>

				</div>
			</div>
		</div>
	</section>
</body>