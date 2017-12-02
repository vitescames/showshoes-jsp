<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>

<%@ include file="import-head.jsp"%>
<link rel="stylesheet" type="text/css" href="css/carrinho.css"/>	

</head>
<body>

<%@ include file="nav-bar.jsp" %>

	<div class="container">	
		<c:if test="${listaLinhas eq null}">
			<p>N�o h� itens no carrinho!</p>
		</c:if>
		<c:if test="${listaLinhas ne null}">
						<table class="col-sm-12">
							<thead>
								<th>Produto</th>
								<th>Quantidade</th>
							</thead>
						<tbody>
			<c:forEach items="${listaLinhas}" var="l">
					<tr>
						<td class="produto-table">
							<div class="row">
								<div class="col-md-3 col-sm-5">
									<img src="${l.produto.urlImg}"/>
								</div>
								<div class="col-md-4 col-sm-6">
									<p>${l.produto.desc}</p>
								</div>
							</div>
						</td>
						<td class="quantidade-table">
							<input type="number" value="${l.quantidade}" name="q">
						</td>
					</tr>			
			</c:forEach>			
				</tbody>	
			</table>					
			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#compra">Realizar Compra</button>			
			<div class="modal fade" id="compra" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Confirma��o de Compra</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        Deseja confirmar a compra? O total a pagar � de: ${precoTotal}
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">N�o</button>
			        <form method="post" action="admin">
			        	<input type="hidden" name="id" value="7">
	       				<button type="submit" class="btn btn-primary">Comprar</button>
			        </form>
			      </div>
			    </div>
			  </div>
			</div>	
				
		</c:if>	
	</div>

<%@ include file="import-footer.jsp" %>
	
	<script src="vendor/jquery/jquery.js"></script>
	<script src="vendor/popper/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.js"></script>	
	
</body>
</html>