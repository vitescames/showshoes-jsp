<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>

<%@ include file="import-head.jsp"%>

</head>

<body>

	<%@ include file="nav-bar.jsp"%>

	<div class="container">

		<div class="row">

			<div class="col-lg-3">
				<h1 class="my-4">OUR TÊNIS</h1>
				<div class="list-group">
					<a href="admin?id=3&idProd=${selProd.id}" class="list-group-item active">COMPRAR</a>
				</div>
			</div>

			<div class="col-lg-9">

				<div class="card mt-4">
										<h3 class="card-title">${selProd.desc}</h3>
					<img class="card-img-top img-fluid"
						src="${selProd.urlImg}" alt="">
					<div class="card-body">
						<h4>R$ ${selProd.valor}</h4>
						<p class="card-text">${selProd.info}</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; OUR SHOES-2017</p>
		</div>
	</footer>

	<%@ include file="import-footer.jsp"%>
</body>

</html>