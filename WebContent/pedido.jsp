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
		<c:forEach items="${listaPedidos}">
			<div>Oi</div>
		</c:forEach>
	</div>
	
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; SHOES SHOW - 2017</p>
		</div>
	</footer>

<%@ include file="import-footer.jsp" %>
	
	<script src="vendor/jquery/jquery.js"></script>
	<script src="vendor/popper/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.js"></script>	
</body>
</html>