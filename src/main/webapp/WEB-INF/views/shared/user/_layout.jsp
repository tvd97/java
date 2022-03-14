<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglist.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title><decorator:title default="Trang chủ"></decorator:title></title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="<c:url value="/content/user/css/bootstrap.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/content/user/css/font-awesome.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/content/user/css/prettyPhoto.css"/>"
	rel="stylesheet">
<link href="<c:url value="/content/user/css/price-range.css"/>"
	rel="stylesheet">
<link href="<c:url value="/content/user/css/animate.css"/>"
	rel="stylesheet">
<link href="<c:url value="/content/user/css/main.css"/>"
	rel="stylesheet">
<link href="<c:url value="/content/user/css/responsive.css"/>"
	rel="stylesheet">
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<link rel="shortcut icon"
	href="<c:url value="/content/images/ico/favicon.ico"/>">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="<c:url value="/content/images/ico/apple-touch-icon-144-precomposed.png"/>">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="<c:url value="/content/images/ico/apple-touch-icon-114-precomposed.png"/>">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="<c:url value="/content/images/ico/apple-touch-icon-72-precomposed.png"/>">
<link rel="apple-touch-icon-precomposed"
	href="<c:url value="/content/images/ico/apple-touch-icon-57-precomposed.png"/>">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<decorator:head></decorator:head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="<c:url value="/content/js/action.js"/>"></script>
<script src='https://kit.fontawesome.com/a076d05399.js'
	crossorigin='anonymous'></script>
</head>
<!--/head-->

<body>
	<header id="header">
		<!--header-->
		<div class="header_top">
			<!--header_top-->
			<div class="container">
				<div class="row"></div>
			</div>
		</div>
		<!--/header_top-->

		<div class="header-middle">
			<!--header-middle-->
			<div class="container">
				<div class="row">
					<a href="<c:url value="/trang-chu"/>"><img alt=""
						src="<c:url value="/content/logo/Untitled.png"/>"></a>
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="index.html"><img src="images/home/logo.png" alt="" /></a>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<li></li>
								<li></li>
								<li></li>
								<li></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/header-middle-->

		<div class="header-bottom">
			<!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle"
								data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
						</div>
						<decorator:getProperty property="page.menuHead" />
					</div>
					<div class="col-sm-3">
						<decorator:getProperty property="page.Search" />
					</div>
				</div>
			</div>
		</div>
		<!--/header-bottom-->
	</header>
	<!--/header-->
	<!--/slider-->
	<decorator:body></decorator:body>
	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Đổi Mật Khẩu</h4>
				</div>
				<div class="modal-body">
					<form:form action="doi-mat-khau" method="POST">
						<div class="form-group">
							<label>Mật khẩu cũ:</label> <input type="password"
								class="form-control" id="oldpass" required="required"
								name="oldpass" onchange="checkPass(this)" /> <span
								class="field-validation-valid text-danger"
								data-valmsg-for="passWord" data-valmsg-replace="true"
								id="cf-msg"></span>
						</div>
						<div class="form-group">
							<label>Mật khẩu mới:</label> <input type="password"
								class="form-control" id="newpass" required="required"
								name="newpass" />
						</div>
						<div class="form-group">
							<label>Nhập lại mật khẩu mới:</label> <input type="password"
								class="form-control" id="renew" required="required"
								onchange="check(this)"> <span
								class="field-validation-valid text-danger"
								data-valmsg-for="passWord" data-valmsg-replace="true"
								id="confirm-msg"></span>
						</div>
						<button type="submit" class="btn btn-primary" id="smbtn">Đổi
							Mật Khẩu</button>
					</form:form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
				</div>
			</div>

		</div>
	</div>
	<footer id="footer">
		<!--Footer-->
		<div class="footer-top">
			<div class="container">
				<div class="row"></div>
			</div>
		</div>
		<div class="footer-widget">
			<div class="container">
				<div class="row">
					<div class="col-sm-3 col-sm-offset-1">
						<div class="single-widget">
							<h2>About Shopper</h2>
							<form action="#" class="searchform">
								<input type="text" placeholder="Your email address" />
								<button type="submit" class="btn btn-default">
									<i class="fa fa-arrow-circle-o-right"></i>
								</button>
								<p>
									Get the most recent updates from <br />our site and be updated
									your self...
								</p>
							</form>
						</div>
					</div>

				</div>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="container">
				<div class="row">
					<p class="pull-left">Copyright © 2013 E-SHOPPER Inc. All rights
						reserved.</p>
					<p class="pull-right">
						Designed by <span><a target="_blank"
							href="http://www.themeum.com">Themeum</a></span>
					</p>
				</div>
			</div>
		</div>

	</footer>
	<!--/Footer-->
	<decorator:getProperty property="page.Script"></decorator:getProperty>
	<script src="<c:url value="/content/user/js/jquery.js"/>"></script>
	<script src="<c:url value="/content/user/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/content/user/js/jquery.scrollUp.min.js"/>"></script>
	<script src="<c:url value="/content/user/js/price-range.js"/>"></script>
	<script src="<c:url value="/content/user/js/jquery.prettyPhoto.js"/>"></script>
	<script src="<c:url value="/content/user/js/main.js"/>"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
	<script type="text/javascript">
		function check(input) {
			if (input.value != document.getElementById('newpass').value) {
				$('#confirm-msg').html('Chưa khớp');
				$('#smbtn').prop('disabled', true);
			} else {
				$('#confirm-msg').html('');
				$('#smbtn').removeAttr('disabled');
			}
		}
	</script>
	<script type="text/javascript">
		function checkPass(input) {
			if (input.value != String('${login.password}')) {
				$('#cf-msg').html('Sai mật khẩu');
				$('#smbtn').prop('disabled', true);
			} else {
				$('#cf-msg').html('');
				$('#smbtn').removeAttr('disabled');
			}
		}
	</script>

</body>
</html>
