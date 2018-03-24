<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<%@ include file="import-head.jsp" %>
		<link rel="stylesheet" type="text/css" href="css/cadastro.css"/>
	</head>
	<body>
	
		<%@ include file="nav-bar.jsp" %>
		
			<div class="container">
				<div class="row">
				
					<div class="col-sm-12">
						<div class="card col-opcao">
							<div class="card-header">
							  <h4>Cadastrar</h4>
							</div>
							
							<div class="card-block">
							
								<br/>
								
								<div class="col-sm-12">		
								
									<div class="col-sm-12">		
							
										<form id="form" class="form-inline" action="" method="post">
										  <div class="form-group mb-2">
										    <label for="logradouro">CEP</label>
										  </div>
										  <div class="form-group mx-sm-3 mb-2">
										    <input class="form-control" name="cep" id="cep">
										  </div>
										  <button type="submit" id="buscaCep" class="btn btn-primary mb-2">Pesquisar</button>	
										</form>
										
									</div>
									
									<div class="col-sm-12">
									
										<div class="row">
								
											<div class="col-sm-6">	
														
												<div class="form-group">
												    <label for="logradouro">Logradouro</label>
													<input disabled="true" class="form-control" id="logradouro">
												</div>
												
											</div>
											
											<div class="col-sm-6">	
														
												<div class="form-group">
												    <label for="bairro">Bairro</label>
													<input disabled="true" class="form-control" id="bairro">
												</div>
												
											</div>
										
										</div>
									
									</div>
									
								</div>
							
							</div>
						</div>
					</div>
						
				</div>
			</div>
		
		<%@ include file="import-footer.jsp" %>
		
		<script>
		
			$(document).ready(function() {
				
				var $form = $('#form');
				
				$form.submit(function() {
					$.ajax({
						url : 'http://localhost:8080/ShowShoes/admin?id=11',
						data : {
							cep : $('#cep').val()
						},
						success : function(resp) {
							$('#logradouro').val(resp.logradouro);
							$('#bairro').val(resp.bairro);
						}
					});
					return false;
				});
			});
		
		</script>
	
	</body>
</html>