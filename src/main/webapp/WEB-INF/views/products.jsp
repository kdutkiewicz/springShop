<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<section>
	<div class="jumbotron">
		<h1>Products:</h1>
		<p>All products that's are avalible in shop</p>
	</div>
	</section>
	<section class="container">
	<div class="row">
	<c:forEach items="${products }" var="product">
		<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
			<div class="thumbnail">
				<div class="caption">
					<h3>${product.name }</h3>
					<p>${product.description }</p>
					<p>${product.unitPrice }PLN</p>
					<p>Amount in stock:${product.unitsInStock }</p>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
	</section>
</body>
</html>