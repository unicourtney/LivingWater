<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <![endif]-->
    <title>Living Water</title>
    <!-- BOOTSTRAP CORE STYLE  -->
    <link
            href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
            rel="stylesheet"/>
    <!-- BOOTSTRAP DATA TABLE STYLE  -->
    <link
            href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
            rel="stylesheet">
    <link
            href="${pageContext.request.contextPath}/resources/css/dataTables.bootstrap.min.css"
            rel="stylesheet">
    <!-- FONT AWESOME ICONS  -->
    <link
            href="${pageContext.request.contextPath}/resources/css/font-awesome.css"
            rel="stylesheet"/>
    <!-- CUSTOM STYLE  -->
    <link href="${pageContext.request.contextPath}/resources/css/style.css"
          rel="stylesheet"/>
    <!-- DROP DOWN MENU  -->
    <link
            href="${pageContext.request.contextPath}/resources/css/drop-down.css"
            rel="stylesheet"/>

    <!-- BREADCRUMBS  -->
    <link
            href="${pageContext.request.contextPath}/resources/css/breadcrumbs.css"
            rel="stylesheet"/>

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
                    src="${pageContext.request.contextPath}/resources/img/Livingwater Minglanilla.png"/>
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
                                        alt="" class="img-rounded"/>
                                </a>
                                <div class="media-body">
                                    <h4 class="media-heading">Jhon Deo Alex</h4>
                                    <h5>Developer & Designer</h5>

                                </div>
                            </div>
                            <hr/>
                            <h5>
                                <strong>Personal Bio : </strong>
                            </h5>
                            Anim pariatur cliche reprehen derit.
                            <hr/>
                            <a href="#" class="btn btn-info btn-sm">Full Profile</a>&nbsp; <a
                                href="login.html" class="btn btn-danger btn-sm">Logout</a>

                        </div>
                    </li>


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
                                                           href="${pageContext.request.contextPath}/inventory/bottles">Bottles</a>
                                </li>
                                <li role="presentation"><a role="menuitem" tabindex="-1"
                                                           href="${pageContext.request.contextPath}/inventory/batch">Batch</a>
                                </li>
                                <li role="presentation"><a role="menuitem" tabindex="-1"
                                                           href="${pageContext.request.contextPath}/inventory/supplies">Supplies</a>
                                </li>
                                <li role="presentation"><a role="menuitem" tabindex="-1"
                                                           href="${pageContext.request.contextPath}/inventory/delivery">Delivery</a>
                                </li>
                            </ul>
                        </li>
                        <li><a class="menu-top-active"
                               href="" class="dropdown-toggle" id="dropdownMenu2"
                               data-toggle="dropdown">Profiles</a>
                            <ul class="dropdown-menu" role="menu"
                                aria-labelledby="dropdownMenu2">
                                <li role="presentation"><a role="menuitem" tabindex="-1"
                                                           href="${pageContext.request.contextPath}/profiles/customers">Customer
                                    Profiles</a></li>
                                <%session.getAttribute("session_login_user");%>
                                <c:choose>
                                    <c:when test="${sessionScope.session_login_user.role.roleID=='3'}">
                                        <c:set var="toDisplay" value="none;"/>

                                    </c:when>
                                    <c:otherwise>
                                        <c:set var="toDisplay" value=""/>

                                    </c:otherwise>
                                </c:choose>

                                <li role="presentation" class="divider" style="display: ${toDisplay}"></li>
                                <li role="presentation"><a style="display: ${toDisplay}" role="menuitem" tabindex="-1"
                                                           href="${pageContext.request.contextPath}/profiles/employees">Employee
                                    Profiles</a></li>
                            </ul>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/transaction">Transaction</a>

                        </li>
                        <li><a href="" class="dropdown-toggle" id="dropdownMenu4"
                               data-toggle="dropdown"><%session.getAttribute("session_login_user");%> ${sessionScope.session_login_user.username}</a>
                            <ul class="dropdown-menu" role="menu"
                                aria-labelledby="dropdownMenu4">
                                <li role="presentation"><a role="menuitem" tabindex="-1"
                                                           href="${pageContext.request.contextPath}/logout">Logout</a></li>
                            </ul></li>

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
                <h1 class="page-head-line">Supplies</h1>
            </div>
        </div>
        <ul class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/inventory/supplies">Supplies</a></li>
            <li>View Supply</li>
        </ul>

        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-5"></div>
            <button id="clicker" class="showBtn btn btn-warning btn-default">
                Edit Supply
            </button>
            <button class="btn btn-danger btn-default">
                Delete Supply
            </button>
            <hr>
        </div>

        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        SUPPLY INFO
                    </div>


                    <div class="panel-body">
                        <form action="${pageContext.request.contextPath}/editSupply"
                              method="POST">
                            <div class="form-group">
                                <label>Material</label>
                                <input type="text" class="form-control" placeholder="" name="supply_name" disabled/>
                            </div>
                            <div class="form-group">
                                <label>Quantity</label>
                                <input type="text" class="form-control" placeholder="" name="supply_quantity" disabled/>
                            </div>
                            <button type="submit" class="btn btn-success btn-default" style="display: none;">Submit
                            </button>
                            <button type="button" id="hide" class="btn btn-default toHideBtn" style="display: none;">
                                Cancel
                            </button>
                        </form>
                    </div>
                </div>
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
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.12.4.js"></script>
<script
        src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min.js"></script>
<script
        src="${pageContext.request.contextPath}/resources/js/dataTables.bootstrap.min.js"></script>

<!-- LIVINGWATER SCRIPTS  -->
<script
        src="${pageContext.request.contextPath}/resources/js/livingwaterscripts.js"></script>
</body>

<!-- HTML5 Shiv and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="${pageContext.request.contextPath}/resources/js/html5shiv.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/respond.min.js"></script>
<![endif]-->
</html>
