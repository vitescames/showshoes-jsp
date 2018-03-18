<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html lang="en">

<head>

<link rel="stylesheet" type="text/css" href="css/filtro.css"/>

<%@ include file="import-head.jsp" %>

</head>
<body>

<%@ include file="nav-bar.jsp" %>

	<div class="row principal">

		<div class="col-sm-3">
			
			<div class="card mt-4" style="margin-top: 0 !important; margin-bottom: 390px;">
				<div class="card-body">
				
					<form action="admin" method="post">
					
						<input type="hidden" value="9" name="id"/>
							
						<h4>Marca</h4>
					
						  <label class="radio-inline"><input type="radio" value="puma" name="marca">Puma</label>
						
						  <label class="radio-inline"><input type="radio" value="adidas" name="marca">Adidas</label>
						
						  <label class="radio-inline"><input type="radio" value="reebok" name="marca">Reebok</label>
						  
					  	<h4>Preço</h4>
					  	
					  	<div class="radio">
						  <label><input type="radio" value="200,300" name="preco">R$200,00 - R$300,00</label>
						</div>
						<div class="radio">
						  <label><input type="radio" name="preco" value="300,400">R$300,00 - R$400,00</label>
						</div>
						<div class="radio">
						  <label><input type="radio" name="preco" value="400,500">R$400,00 - R$500,00</label>
						</div>
						<div class="radio">
						  <label><input type="radio" name="preco" value="500,600">R$500,00 - R$600,00</label>
						</div>
						<div class="radio">
						  <label><input type="radio" name="preco" value="600,700">R$600,00 - R$700,00</label>
						</div>
						<div class="radio">
						  <label><input type="radio" name="preco" value="700,800">R$700,00 - R$800,00</label>
						</div>
						
						<div>
							<button type="submit" class="btn btn-primary">Procurar</button>
						</div>
					
					</form>
					
				</div>
			</div>
			
		</div>

		<div class="col-sm-9">
			<c:if test="${quant eq 1}">
				<c:forEach var="p" items="${listaPagina}">
					<div class="row">
			  			<c:forEach var="i" items="${p.listaProdutos}">
								<%@ include file="main-view.jsp" %>
			      		</c:forEach>
					</div>
		   		</c:forEach>
			</c:if>
			<c:if test="${quant eq 0}">
				Sem Resultados!
			</c:if>
			<c:if test="${quant > 1}">
				<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
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
				  <a class="carousel-control-prev" style="left: -90px;" href="#carouselExampleControls" data-slide="prev">
				    <span class="carousel-control-prev-icon"></span>
				  </a>
				  <a class="carousel-control-next" style="right: -29px; " href="#carouselExampleControls" data-slide="next">
				    <span class="carousel-control-next-icon"></span>
				  </a>
				</div>
			</c:if>
		
		</div>
	
	</div>		

<%@ include file="import-footer.jsp" %>

</body>

</html>
