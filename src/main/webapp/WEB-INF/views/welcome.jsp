<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Welcome page</title>
</head>
<body>
	<section>
	<div class="jumbotron">
		<div class="container">
			<h1>${greeting }</h1>
			<p>${tagline }</p>
		</div>
	</div>
	</section>
	<section class="container">
	<div class="text-center">
	<div class="col-sm-3">
		<div class="thumbnail">

			<a href="products/add"> <span class="glyphicon glyphicon-plus"></span>
				ADD
			</a>
		</div>
		</div>
	</div>
	<div class="text-center">
			<div class="col-sm-3">
				<div class="thumbnail ">
					<a href="products"> <span class="glyphicon glyphicon-th"></span>All
						products
					</a>
				</div>
		</div>
	</div>
	</section>
</body>
</html>