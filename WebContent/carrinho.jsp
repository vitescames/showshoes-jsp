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
		<c:if test="${listaLinhas eq null}">
			<p>Não há itens no carrinho!</p>
		</c:if>
		<c:if test="${listaLinhas ne null}">
			<c:forEach items="${listaLinhas}" var="l">
				<p>${l.produto.desc}</p>
				<p>${l.quantidade}</p>
			</c:forEach>
		</c:if>
	</div>

</body>
</html>