<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastro MangaHQ</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="/styles/cadastro.css">
	<link rel="stylesheet" type="text/css" href="/styles/navbar.css">
	<link rel="stylesheet" type="text/css" href="/styles/footer.css">
</head>
<body>
	<!-- Navbar  -->
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="#">MangáHQ!</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item active">
						<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">Sobre</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">Noticias</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">Login</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">Contato</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>
	<!-- Main -->
	<main>
		<form>
			<div class="form-group">
			  <label for="login">Login</label>
			  <input type="login" class="form-control" id="login">
			</div>
			<div class="form-group">
			  <label for="senha">Senha</label>
			  <input type="password" class="form-control" id="senha">
			</div>
			<!-- Fazer um for Each -->
			<div class="row">
				<div class="form-check col-xl-2 col-lg-3 col-md-4 col-sm-6 col-12">
			  		<input class="form-check-input" type="checkbox" value="" id="checkbox">
			  		<label class="form-check-label" for="checkbox">
			    		MangaHQ #1
			  		</label>
				</div>
			</div>
		    <button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>
	</main>
	<!-- Footer -->
	<footer>
		<div class="row ml-0 mr-0">
			<div class="col-12 mt-4">
				<h3 class="text-center text-white"><strong>Conheça Nossas Redes Sociais</strong></h3>
				<ul class="list-unstyled list-inline text-center mt-4">
					<a href="#" class="ml-1 mr-1" target="_blank"><li class="list-inline-item facebook"><i class="fab fa-facebook-f fa-2x"></i></li></a>
					<a href="#" class="ml-1 mr-1" target="_blank"><li class="list-inline-item instagram"><i class="fab fa-instagram fa-2x"></i></li></a>
					<a href="#" class="ml-1 mr-1" target="_blank"><li class="list-inline-item whatsapp"><i class="fab fa-whatsapp fa-2x"></i></li></a>
				</ul>
			</div>
			<hr>
		</div>
		<div class="row mt-2 ml-0 mr-0">
			<div class="col-12 text-center text-light">
				<p>Todos os direitos reservados MangáHQ!</p>
			</div>
		</div>
	</footer>
	
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	<script src="https://kit.fontawesome.com/c2a97b9eb3.js" crossorigin="anonymous"></script>
	
</body>
</html>