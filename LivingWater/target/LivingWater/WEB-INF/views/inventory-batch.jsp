<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta name="description" content="" />
<meta name="author" content="" />
<!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
<title>Living Water</title>
<!-- BOOTSTRAP CORE STYLE  -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet">
<!-- BOOTSTRAP DATA TABLE STYLE  -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.datatables.net/1.10.13/css/dataTables.bootstrap.min.css"
	rel="stylesheet">
<!-- FONT AWESOME ICONS  -->
<link
	href="${pageContext.request.contextPath}/resources/css/font-awesome.css"
	rel="stylesheet" />
<!-- CUSTOM STYLE  -->
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" />

<!-- DROP DOWN MENU  -->
<link
	href="${pageContext.request.contextPath}/resources/css/drop-down.css"
	rel="stylesheet" />
<!-- HTML5 Shiv and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<header>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<strong>Email: </strong>info@yourdomain.com &nbsp;&nbsp; <strong>Support:
					</strong>+90-897-678-44
				</div>

			</div>
		</div>
	</header>
	<!-- HEADER END-->
	<div class="navbar navbar-inverse set-radius-zero">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href=""> <img
					src="${pageContext.request.contextPath}/resources/img/logo.png" />
				</a>

			</div>

			<div class="left-div">
				<div class="user-settings-wrapper">
					<ul class="nav">

						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#" aria-expanded="false"> <span
								class="glyphicon glyphicon-user" style="font-size: 25px;"></span>
						</a>
							<div class="dropdown-menu dropdown-settings">
								<div class="media">
									<a class="media-left" href="#"> <img
										src="/WEB-INF/views/assets/img/64-64.jpg" alt=""
										class="img-rounded" />
									</a>
									<div class="media-body">
										<h4 class="media-heading">Jhon Deo Alex</h4>
										<h5>Developer & Designer</h5>

									</div>
								</div>
								<hr />
								<h5>
									<strong>Personal Bio : </strong>
								</h5>
								Anim pariatur cliche reprehen derit.
								<hr />
								<a href="#" class="btn btn-info btn-sm">Full Profile</a>&nbsp; <a
									href="login.html" class="btn btn-danger btn-sm">Logout</a>

							</div></li>


					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- LOGO HEADER END-->
	<section class="menu-section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="navbar-collapse collapse ">
						<ul id="menu-top" class="nav navbar-nav navbar-right">
							<li><a class="menu-top-active" href=""
								class="dropdown-toggle" id="dropdownMenu1"
								data-toggle="dropdown">Inventory</a>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="dropdownMenu1">
									<li role="presentation"><a role="menuitem" tabindex="-1"
										href="${pageContext.request.contextPath}/inventory/bottles">Bottles</a></li>
									<li role="presentation"><a role="menuitem" tabindex="-1"
															   href="${pageContext.request.contextPath}/inventory/batch">Batch</a></li>
									<li role="presentation"><a role="menuitem" tabindex="-1"
										href="${pageContext.request.contextPath}/inventory/supplies">Supplies</a></li>
								</ul></li>
							<li><a href="" class="dropdown-toggle" id="dropdownMenu2"
								data-toggle="dropdown">Profiles</a>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="dropdownMenu2">
									<li role="presentation"><a role="menuitem" tabindex="-1"
										href="${pageContext.request.contextPath}/profiles/customers">Customer
											Profiles</a></li>
									<li role="presentation" class="divider"></li>
									<li role="presentation"><a role="menuitem" tabindex="-1"
										href="${pageContext.request.contextPath}/profiles/delivery-teams">Delivery
											Team Profiles</a></li>
									<li role="presentation"><a role="menuitem" tabindex="-1"
										href="${pageContext.request.contextPath}/profiles/employees">Employee
											Profiles</a></li>
								</ul></li>
							<li><a href="" class="dropdown-toggle" id="dropdownMenu3"
								data-toggle="dropdown">Sales</a>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="dropdownMenu3">
									<li role="presentation"><a role="menuitem" tabindex="-1"
										href="${pageContext.request.contextPath}/sales/delivery">Delivery</a></li>
									<li role="presentation"><a role="menuitem" tabindex="-1"
										href="${pageContext.request.contextPath}/sales/refilling">Refilling
											Team Profiles</a></li>
									<li role="presentation"><a role="menuitem" tabindex="-1"
										href="${pageContext.request.contextPath}/sales/dispensers">Dispensers</a></li>
								</ul></li>
							<li><a href="forms.html">Forms</a></li>
							<li><a href="login.html">Login Page</a></li>
							<li><a href="blank.html">Blank Page</a></li>

						</ul>
					</div>
				</div>

			</div>
		</div>
	</section>
	<!-- MENU SECTION END-->
	<div class="content-wrapper">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h4 class="page-head-line">Batch</h4>

				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-5"></div>
					<form action="${pageContext.request.contextPath}/addBatch"
						  method="POST">
						<input type="hidden" value="1" class="form-control" placeholder="Batch ID" name="batch_id" />
					<button type="submit" class="btn btn-success btn-default">
						Create Batch
					</button>
						<button type="button" class="btn btn-info btn-default" data-toggle="modal" data-target="#addBottleToBatch">
							Add Bottle To Batch
						</button>
					</form>
					<hr>
				</div>

				<div class="modal fade" id="addBottleToBatch" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
					 aria-hidden="true" style="display: none;">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel2">Add Bottle To Batch</h4>
							</div>
							<div class="modal-body">
								<form action="${pageContext.request.contextPath}/addBottleToBatch"
									  method="POST">
									<div class="form-group">
										<label>Batch ID</label>
										<select class="form-control" name="batch_id">
											<option value="001">001</option>
											<option value="002">002</option>
										</select>
									</div>
									<div class="form-group">
										<label>Bottle ID</label>
										<select class="form-control" name="bottle_id">
											<option value="1234">1234</option>
											<option value="5678">5678</option>
											<option value="91011">91011</option>
											<option value="121314">121314</option>
										</select>
									</div>

									<button type="submit" class="btn btn-success btn-default">Submit</button>

								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<table id="example"
						class="table table-hover table-condensed table-striped"
						cellspacing="0" width="100%">
						<thead>
							<tr>
								<th>Batch ID</th>
								<th>Status</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>#00001</td>
								<td>Special</td>
								<td><a href="#" class="btn btn-danger btn-xs">DELETE</a></td>
							</tr>
							<tr>
								<td>#00002</td>
								<td>Not</td>
								<td><a href="#" class="btn btn-danger btn-xs">DELETE</a></td>
							</tr>
							<tr>
								<td>#00003</td>
								<td>Special</td>
								<td><a href="#" class="btn btn-danger btn-xs">DELETE</a></td>
							</tr>
							<tr>
								<td>#00004</td>
								<td>Not</td>
								<td><a href="#" class="btn btn-danger btn-xs">DELETE</a></td>
							</tr>
						</tbody>
					</table>
				</div>

			</div>
		</div>
	</div>
	<!-- CONTENT-WRAPPER SECTION END-->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					&copy; 2015 YourCompany | By : <a
						href="http://www.designbootstrap.com/" target="_blank">DesignBootstrap</a>
				</div>

			</div>
		</div>
	</footer>
	<!-- FOOTER SECTION END-->
	<!-- JAVASCRIPT AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
	<!-- CORE JQUERY SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.js"></script>
	<!-- BOOTSTRAP SCRIPTS  -->
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	<!-- BOOTSTRAP DATA TABLE SCRIPTS  -->
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.13/js/dataTables.bootstrap.min.js"></script>

	<!-- LIVINGWATER SCRIPTS  -->
	<script
			src="${pageContext.request.contextPath}/resources/js/livingwaterscripts.js"></script>
</body>
</html>
