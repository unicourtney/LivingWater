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
            href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
            rel="stylesheet">
    <link
            href="${pageContext.request.contextPath}/resources/css/dataTables.bootstrap.min.css"
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
                    src="${pageContext.request.contextPath}/resources/img/Livingwater Minglanilla.jpg" />
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
                                                           href="${pageContext.request.contextPath}/sales/delivery">Transaction</a></li>
                                <li role="presentation"><a role="menuitem" tabindex="-1"
                                                           href="${pageContext.request.contextPath}/sales/refilling">Refilling
                                    Team Profiles</a></li>
                                <li role="presentation"><a role="menuitem" tabindex="-1"
                                                           href="${pageContext.request.contextPath}/sales/dispensers">Dispensers</a></li>
                            </ul></li>
                        <li><a href="">OTHER LINKS</a></li>
                        <li><a href="">OTHER LINKS</a></li>
                        <li><a href="">Log Out</a></li>

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
                <div class="col-md-4">

                    <div class="col-md-5">
                        <p>Select Batch ID</p>
                    </div>
                    <div class="col-md-7">
                        <div class="col-md-6">
                            <form method="post" action="${pageContext.request.contextPath}/inventory/getBatch">
                                <select name="showBatchID" class="form-control input-sm" onchange="this.form.submit();">
                                    <option value="-1">Select</option>
                                    <c:forEach items="${batchList}" var="batch" varStatus="status">
                                        <c:choose>
                                            <c:when test="${batch.batchID == batchSelected}">
                                                <option selected="selected" value="${batch.batchID}">${batch.batchID}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${batch.batchID}">${batch.batchID}</option>
                                            </c:otherwise>
                                        </c:choose>

                                    </c:forEach>
                                    <
                                </select>
                            </form>
                        </div>

                        <div class="col-md-6"></div>
                    </div>

                </div>
                <div class="col-md-5"></div>
                <form action="${pageContext.request.contextPath}/addBatch"
                      method="POST">
                    <input type="hidden" 	value="1" class="form-control" placeholder="Batch ID" name="batch_id" />
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
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">�</button>
                            <h4 class="modal-title" id="myModalLabel2">Add Bottle To Batch</h4>
                        </div>
                        <div class="modal-body">
                            <form action="${pageContext.request.contextPath}/addBottleToBatch"
                                  method="POST">
                                <div class="form-group">
                                    <label>Batch ID</label>
                                    <select class="form-control" name="batch_id">
                                        <c:forEach items="${batchList}" var="batch" varStatus="status">
                                            <option value="${batch.batchID}">${batch.batchID}</option>
                                        </c:forEach>

                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Bottle ID</label>
                                    <select class="form-control" name="bottle_id">
                                        <c:forEach items="${allBottlesList}" var="bottles" varStatus="status">
                                            <option value="${bottles.serialNumber}">${bottles.serialNumber}</option>
                                        </c:forEach>
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
                        <th>Serial Number</th>
                        <th>Bottle Type</th>
                        <th>Date Last Delivered</th>
                        <th>Status</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${bottlesList}" var="bottle" varStatus="status">
                        <tr>
                            <td>${bottle.serialNumber}</td>
                            <td>${bottle.bottleType}</td>
                            <td>${bottle.dateLastDelivered}</td>
                            <td>${bottle.status}</td>
                        </tr>


                    </c:forEach>
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
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.12.4.js"></script>
<script
        src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min.js"></script>
<script
        src="${pageContext.request.contextPath}/resources/js/dataTables.bootstrap.min.js"></script>

<!-- LIVINGWATER SCRIPTS  -->
<script
        src="${pageContext.request.contextPath}/resources/js/livingwaterscripts.js"></script>
<!-- HTML5 Shiv and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="${pageContext.request.contextPath}/resources/js/html5shiv.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/respond.min.js"></script>
<![endif]-->
</body>
</html>