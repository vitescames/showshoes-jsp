<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">SHOW SHOES</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="admin?id=1">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="admin?id=4">Produtos</a>
					</li>					
					<c:if test="${login != true}">
						<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
					</c:if>
					<c:if test="${login == true}">
						<li class="nav-item"><a class="nav-link" href="admin?id=3">Sair</a></li>
					</c:if>
					<li class="nav-item"><a class="nav-link" href="admin?id=8">Meus Pedidos</a>
					</li>	
					<a href="admin?id=5">
						<li style="padding-top: 8px; padding-bottom: 8px;"> 
							<i style="color: white;" class="fa fa-search fa-shopping-cart" aria-hidden="true"></i>
							<c:if test="${quantCarrinho eq null}">
								<span class="badge">0</span></a>
							</c:if>
							<c:if test="${quantCarrinho ne null}">
								<span class="badge">${quantCarrinho}</span></a>
							</c:if>
						</li>			
					</a>
					</ul>
					<ul class="navbar-nav ml-auto">
						<li>
							<form class="form-inline">
							    <input class="form-control mr-sm-2" type="text">
					    		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Procurar</button>
						  </form>
						</li>
					</ul>
			</div>
		</div>
	</nav>
	