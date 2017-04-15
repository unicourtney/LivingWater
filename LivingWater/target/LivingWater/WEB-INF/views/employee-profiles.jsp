<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	rel="stylesheet" />
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
				<a class="navbar-brand" href="index.html"> <img
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
										src="${pageContext.request.contextPath}/resources/img/64-64.jpg"
										alt="" class="img-rounded" />
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
							<li><a href="" class="dropdown-toggle" id="dropdownMenu1"
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
							<li><a class="menu-top-active" href=""
								class="dropdown-toggle" id="dropdownMenu2"
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
					<h1 class="page-head-line">Employees</h1>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-5"></div>
				<button class="btn btn-success btn-default" data-toggle="modal" data-target="#addEmployeeModal">
					Add Employee
				</button>
				<hr>
			</div>

			<div class="modal fade" id="addEmployeeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
				 aria-hidden="true" style="display: none;">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">Add Employee</h4>
						</div>
						<div class="modal-body">
							<form action="${pageContext.request.contextPath}/addUser"
								  method="POST">
								<div class="form-group">
									<label>Name</label>
									<input type="text" class="form-control" placeholder="Name" name="user_name"/>
								</div>
								<div class="form-group">
									<label>Username</label>
									<input type="text" class="form-control" placeholder="Username" name="username"/>
								</div>
								<div class="form-group">
									<label>Password</label>
									<input type="password" class="form-control" placeholder="" name="user_password"/>
								</div>
								<div class="form-group">
									<label>Role</label>
									<select class="form-control" name="user_role">
										<option value="Superadmin">Superadmin</option>
										<option value="Admin">Admin</option>
										<option value="Regular">Regular</option>
									</select>
								</div>

								<button type="submit" class="btn btn-default">Submit</button>

							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

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
								<th>Employee ID</th>
								<th>Name</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>001</td>
								<td>Cherry</td>
								<td><a href="${pageContext.request.contextPath}/profiles/employees/info"
									   class="btn btn-info btn-xs">VIEW</a>
									<a href="#" class="btn btn-danger btn-xs">DELETE</a></td>
							</tr>
							<tr>
								<td>002</td>
								<td>Angelo</td>
								<td><a href="${pageContext.request.contextPath}/profiles/employees/info"
									   class="btn btn-info btn-xs">VIEW</a>
									<a href="#" class="btn btn-danger btn-xs">DELETE</a></td>
							</tr>
							<tr>
								<td>003</td>
								<td>Yhen</td>
								<td><a href="${pageContext.request.contextPath}/profiles/employees/info"
									   class="btn btn-info btn-xs">VIEW</a>
									<a href="#" class="btn btn-danger btn-xs">DELETE</a></td>
							</tr>
							<tr>
								<td>004</td>
								<td>Leah</td>
								<td><a href="${pageContext.request.contextPath}/profiles/employees/info"
									   class="btn btn-info btn-xs">VIEW</a>
									<a href="#" class="btn btn-danger btn-xs">DELETE</a></td>
							</tr>
						</tbody>
					</table>
				</div>

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

	<script>
		$(document).ready(function() {
			$('#example').DataTable();
		});
	</script>
</body>
</html>
