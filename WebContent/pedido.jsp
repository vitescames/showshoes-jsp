<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="import-head.jsp"%>
</head>
<body>
	<%@ include file="nav-bar.jsp" %>

	<div class="container">	
		<div class="row">
			  <table class="table">
    			<thead class="thead-dark">
   				      <tr>
				        <th>Número do Pedido</th>
				        <th>Endereço</th>
				        <th>Itens</th>
				        <th>Valor</th>
				        <th>Visualizar</th>
				      </tr>
    			</thead>
    			<tbody>
			<c:forEach var="pedido" items="${listaPedidos}">
				<tr>
					<td>${pedido.id}</td> 
					<td>${pedido.usuario.endereco.logradouro}</td>
					<td>
					<c:forEach var="linhaItem" items="${pedido.listLinhaItens}">
						<div>${linhaItem.produto.desc}</div>
					</c:forEach>
					</td>
					<td>${pedido.valor}</td>
					<td>
						<a href="#">
							<i class="fa fa-eye" aria-hidden="true"></i>
						</a>
					</td>
				</tr>
			</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
<%@ include file="import-footer.jsp" %>

</body>
</html>