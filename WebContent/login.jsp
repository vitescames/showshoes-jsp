<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/login.css"/>
<title>SHOES SHOW</title>

<%@ include file="import-head.jsp" %>

</head>
<body>

<%@ include file="nav-bar.jsp" %>

	<div class="container">
	
		<div class="row">
			<div class="col-sm-6 opcao-login">
				<div class="card col-opcao">
					<div class="card-header">
					  <h4>Login</h4>
					</div>
					<div class="card-block">				
						<form method="post" action="admin">
						  <input type="hidden" name="id" value="3">
						  <div class="form-group">
						    <label for="exampleInputEmail1">Email</label>
						    <input type="email" name="user" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
						  </div>
						  
				    	  <div class="form-group">
						    <label for="exampleInputPassword1">Senha</label>
						    <input type="password" name="pass" class="form-control" id="exampleInputPassword1">
						  </div>						  
						  <button type="submit" class="btn btn-primary">Entrar</button>						  
						</form>
					</div>
				</div>
			</div>
			<div class="col-sm-6 opcao-registrar">
				<div class="card col-opcao">
					<div class="card-header">
					  <h4>Registrar</h4>
					</div>
					<div class="card-block">				
						<form>
						
						  <div class="form-group">
						    <label for="exampleInputEmail1">Email</label>
						    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
						  </div>
						  
				    	  <div class="form-group">
						    <label for="exampleInputPassword1">Senha</label>
						    <input type="password" class="form-control" id="exampleInputPassword1">
						  </div>
						  
						  <button type="submit" class="btn btn-primary">Quero me Cadastrar</button>
						  
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

<%@ include file="import-footer.jsp" %>

</body>

</html>
