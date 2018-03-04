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
		<c:forEach var="pedido" items="${listaPedidos}">
			<div>${pedido.id}</div>
			<div>${pedido.usuario.user}</div>
			<c:forEach var="linhaItem" items="${pedido.listLinhaItens}">
				<div>${linhaItem.produto.desc}</div>
			</c:forEach>
		</c:forEach>
	</div>
	
<%@ include file="import-footer.jsp" %>

</body>
</html>