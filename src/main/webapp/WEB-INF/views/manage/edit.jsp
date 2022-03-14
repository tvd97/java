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
					<form:form method="POST" modelAttribute="edit"
						action="/quan-ly/san-pham/chinh-sua">
						<div class="form-group">
							<label for="exampleFormControlInput1">Tên cây giống</label>
							<form:input type="text" class="form-control"
								id="exampleFormControlInput1" placeholder="name@example.com"
								path="name" />
						</div>
						<div class="form-group">
							<label for="exampleFormControlSelect1">Loại giống</label>
							<form:select class="form-control" id="exampleFormControlSelect1"
								path="species">
								<c:forEach var="item" items="${species }">
									<form:option value="${item.id }">${item.name}</form:option>
								</c:forEach>

							</form:select>
						</div>
						<div class="form-group">
							<label for="exampleFormControlInput1">Giá mới</label> <input
								type="text" class="form-control" id="exampleFormControlInput1"
								placeholder="name@example.com">
						</div>
						<div class="form-group">
							<label for="exampleFormControlInput1">Giá cũ</label> <input
								type="text" class="form-control" id="exampleFormControlInput1"
								placeholder="name@example.com">
						</div>
						<div class="form-group">
							<label for="exampleFormControlTextarea1">Mô tả</label>
							<textarea class="form-control" id="exampleFormControlTextarea1"
								rows="3"></textarea>
						</div>
						<div class="form-group">
							<label for="exampleFormControlTextarea1">Cách chăm sóc</label>
							<textarea class="form-control" id="exampleFormControlTextarea1"
								rows="3"></textarea>
						</div>
						<button type="submit" class="btn btn-primary">Lưu</button>
					</form:form>

				</div>
			</div>
		</div>
	</section>
</body>