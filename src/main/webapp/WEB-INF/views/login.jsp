<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
	<section>
	<div class="jumbotron">
		<div class="container">
			<h1>Product</h1>
			<p>Add product</p>
		</div>
	</div>
	</section>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-title">
					<div class="panel-heading">
						<h3 class="panel-heading">Log in</h3>
					</div>
					<div class="panel-body">
						<c:if test="${not empty error}">
							<div class="alert alert-danger">
								<spring:message
									code="AbstractUserDetailErrorAuthentitaction.badCredentials" />
								<br>
							</div>
						</c:if>
						<form action="<c:url value="/j_spring_security_check"></c:url>"
							method="post">
							<fileset>
							<div class="form-group">
								<input class="form-control" placeholder="Username" type="text"
									name="j_username">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Password"
									type="password" name="j_password">
							</div>
							<input class="btn btn-lg btn-succes btn-block" type="submit"
								value="Log in">
					</div>
				</div>
			</div>
		</div>
</body>
</html>