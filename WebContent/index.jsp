<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>

<link rel="stylesheet" type="text/css" href="css/index.css"/>

<%@ include file="import-head.jsp" %>

</head>
<body>

<%@ include file="nav-bar.jsp" %>

	<div class="container">
	
		<div class="jumbotron">
			<h1>Promoção na Show Shoes!</h1>
		</div>
		
		<div id="carouselExampleControls" class="carousel slide" data-interval="5000" data-ride="carousel">
		  <div class="carousel-inner" role="listbox">
		  	<c:forEach var="p" items="${listaPagina}">
		  		<c:if test="${p.index eq 1}">
			   		<div class="carousel-item active">
			    </c:if>
			    <c:if test="${p.index ne 1}">
			   		<div class="carousel-item">
			    </c:if>
					<div class="row">
			  			<c:forEach var="i" items="${p.listaProdutos}">
								<%@ include file="main-view.jsp" %>
			      		</c:forEach>
					</div>
			    </div>
		   	</c:forEach>
		  </div>
		  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
		</div>
		
	</div>
	
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; SHOES SHOW - 2017</p>
		</div>
	</footer>

<%@ include file="import-footer.jsp" %>

</body>

</html>
