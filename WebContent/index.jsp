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

	<div class="col-sm-12">
	
		<div class="container">
		
			<div class="jumbotron jumb-index">
		        <h1>Bem-vindo à <span class="font-show">Show Shoes!</span></h1>
		        <p class="lead">A Show Shoes é uma loja virtual, dedicada à venda de tênis das marcas mais respeitadas internacionalmente. Somente trabalhamos com
		        produtos de qualidade, fique a vontade para escolher o que mais combina com você.</p>
		        <p><a class="btn btn-lg btn-outline-success" href="admin?id=4" role="button">Me leve aos produtos!</a></p>
     		</div>
			
			<div id="carousel-prop" class="carousel slide" data-ride="carousel">

				  <!-- Indicators -->
				  <ul class="carousel-indicators">
				    <li data-target="#carousel-prop" data-slide-to="0" class="active"></li>
				    <li data-target="#carousel-prop" data-slide-to="1"></li>
				    <li data-target="#carousel-prop" data-slide-to="2"></li>
				  </ul>
				
				  <!-- The slideshow -->
				  <div class="carousel-inner">
				    <div class="carousel-item active">
				      <img src="img/nike.jpg" alt="Los Angeles">
				    </div>
				    
				    <div class="carousel-item">
				      <img src="img/adidas.jpg" alt="Chicago">
				    </div>
				    
				    <div class="carousel-item">
				      <img src="img/puma.jpg" alt="Chicago">
				    </div>
				    
				  </div>
				
				  <!-- Left and right controls -->
				  <a class="carousel-control-prev" href="#carousel-prop" data-slide="prev">
				    <span class="carousel-control-prev-icon"></span>
				  </a>
				  <a class="carousel-control-next" href="#carousel-prop" data-slide="next">
				    <span class="carousel-control-next-icon"></span>
				  </a>
				
			</div>
			
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
				<div class="row col-sm-10" style="margin:auto;">
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
		
	
<%@ include file="import-footer.jsp" %>

</body>

</html>
