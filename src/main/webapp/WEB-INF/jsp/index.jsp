<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Time-management: Home</title>

    <%--<link rel="stylesheet" href="/static/css/bootstrap/css/bootstrap.min.css">--%>
    <%--<link rel="stylesheet" href="/static/css/style.css">--%>
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

    <!--This is background-->
    <link rel="stylesheet" media="all"
          href="http://xfer-assets.s3.amazonaws.com/assets/application-183db160aec9c65aee73a1cf65198f90.css"/>

    <!--This is JS for header-->
    <!--<script src="//xfer-assets.s3.amazonaws.com/assets/application-653e9726a10c9e317ffaaf9402ad69b2.js"></script>-->
    <!--<script src="../js/jQuery JavaScript Library v1.12.1.js"></script>-->

    <!--Popup links-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<body>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class=""><a href="/">Time management</a></li>


                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                        Products <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li class=""><a href="/organisations">Organisations</a></li>
                        <li class=""><a href="/departments">Departments</a></li>
                        <li class=""><a href="/specialists">Specialists</a></li>
                    </ul>
                </li>

                <li class=""><a href="/contact">Contact</a></li>

            </ul>

            <!-- right side -->
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="/login">Log in</a>
                </li>
                <li>
                    <a href="/registration">Sign up</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<%--<div class="index_content">--%>
<%--<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">--%>
<%--<ol class="carousel-indicators">--%>
<%--<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>--%>
<%--<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>--%>
<%--<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>--%>
<%--</ol>--%>
<%--<div class="carousel-inner" role="listbox">--%>
<%--<div class="carousel-item active">--%>
<%--<img class="d-block img-fluid" src="..." alt="First slide">--%>
<%--</div>--%>
<%--<div class="carousel-item">--%>
<%--<img class="d-block img-fluid" src="..." alt="Second slide">--%>
<%--</div>--%>
<%--<div class="carousel-item">--%>
<%--<img class="d-block img-fluid" src="..." alt="Third slide">--%>
<%--</div>--%>
<%--</div>--%>
<%--<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">--%>
<%--<span class="carousel-control-prev-icon" aria-hidden="true"></span>--%>
<%--<span class="sr-only">Previous</span>--%>
<%--</a>--%>
<%--<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">--%>
<%--<span class="carousel-control-next-icon" aria-hidden="true"></span>--%>
<%--<span class="sr-only">Next</span>--%>
<%--</a>--%>
<%--</div>--%>
<%--</div>--%>

<!-- Content    --->

<div class="index_content">
    <div class="central">
        <c:if test="${currentUser!=null}">
            Welcome, ${currentUser.fullName}!
        </c:if>
        <h2>Please choose what you want to do:</h2>
        <!-- Trigger the modal with a button -->
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#modal_log">Login</button>
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#modal_reg">Registration
        </button>

        <!-- Modal login-->
        <div class="modal fade" id="modal_log" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Login</h4>
                    </div>
                    <div class="modal-body">

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Please sign in</h3>
                            </div>
                            <div class="panel-body">
                                <form accept-charset="UTF-8" role="form"
                                      action="${contextPath}/login" method="post">
                                    <fieldset>
                                        <div class="form-group">
                                            <input required class="form-control" placeholder="E-mail" name="email"
                                                   type="text">
                                        </div>
                                        <div class="form-group">
                                            <input required class="form-control" placeholder="Password" name="password"
                                                   type="password" value="">
                                        </div>
                                        <%--<div class="checkbox">--%>
                                        <%--<label>--%>
                                        <%--<input name="remember" type="checkbox" value="Remember Me"> Remember Me--%>
                                        <%--</label>--%>
                                        <%--</div>--%>
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                        <input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
                                    </fieldset>
                                </form>
                            </div>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>

        <!-- Modal registration-->
        <div class="modal fade" id="modal_reg" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Registration</h4>
                    </div>
                    <div class="modal-body">

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Please enter:</h3>
                            </div>
                            <div class="panel-body">
                                <form accept-charset="UTF-8" role="form" method="post"
                                      action="${contextPath}/register">
                                    <fieldset>
                                        <div class="form-group">
                                            <input required class="form-control" placeholder="Your name" name="userName"
                                                   type="text">
                                        </div>
                                        <div class="form-group">
                                            <input required class="form-control" placeholder="Contact phone"
                                                   name="phone"
                                                   type="text">
                                        </div>
                                        <div class="form-group">
                                            <input required class="form-control" placeholder="E-mail" name="email"
                                                   type="text">
                                        </div>
                                        <div class="form-group">
                                            <input required class="form-control" placeholder="Password" name="password"
                                                   type="password" value="">
                                        </div>
                                        <div class="form-group">
                                            <input required class="form-control" placeholder="Confirm password"
                                                   name="password_confirm"
                                                   type="password" value="">
                                        </div>

                                        <input class="btn btn-lg btn-success btn-block" type="submit"
                                               value="Registration">
                                    </fieldset>
                                </form>
                            </div>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>


</body>
</html>