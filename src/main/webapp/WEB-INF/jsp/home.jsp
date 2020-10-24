<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MangaHQ</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	<script src="https://kit.fontawesome.com/c2a97b9eb3.js" crossorigin="anonymous"></script>

	<style type="text/css">
		* {
			box-sizing: border-box;
			margin: 0;
			padding: 0;
		}

		a {
			color: black;
			text-decoration: none;
			justify-content: center;
			align-items: center;
		}
		a:hover {
			color: black;
			text-decoration: none;
		}

		/* Main */

		.carousel-indicators li{
			width: 20px;
			height: 20px;
			border: none;
			margin: 0 .6rem;
			border-radius: 10px;
		}

		/* Footer */

		footer {
			background-color: black;
		}

		.instagram, .facebook, .whatsapp{
			transition: .4s;
			-webkit-transition: .4s;
			-o-transition: .4s;
			-moz-transition: .4s;
			padding-top: 15px;
			width: 60px;
			height: 60px;
			border-radius: 30px;
		}
		.instagram{
			background: linear-gradient(45deg,rgb(224,224,240),rgb(244,243,242)49%,#f09433 50%, #e6683c 62.5%, #dc2743 75%, #cc2366 87.5%, #bc1888 100%);
			background-size:250%;
		}
		.instagram:hover , .facebook:hover, .whatsapp:hover{
			background-position: right;
		}
		.facebook{
			background: linear-gradient(45deg, rgb(224,224,240),rgb(244,243,242)49%,rgb(25,175,255) 50%, rgba(0, 7, 224, 0.8) 100%);
			background-size:250%;
		}
		.whatsapp{
			background: linear-gradient(45deg, rgb(224,224,240),rgb(244,243,242)49%,rgb(97,253,125) 50%, rgba(37, 207, 67, 0.8) 100%);
			background-size:250%;
		}
		
	</style>
	
</head>
<body>
	<!-- Navbar  -->
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
	<!-- Main -->
	<main class="container">
		<div id="carouselPrincipal" class="carousel slide mt-4" data-ride="carousel">
			<ol class="carousel-indicators">
			  <li data-target="#carouselPrincipal" data-slide-to="0" class="active"></li>
			  <li data-target="#carouselPrincipal" data-slide-to="1"></li>
			  <li data-target="#carouselPrincipal" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">
			  <div class="carousel-item active">
				<img src="https://papodelouco.com/wp-content/uploads/2018/07/IMG_20180724_150416550-800x400.jpg" class="d-block w-100" alt="...">
			  </div>
			  <div class="carousel-item">
				<img src="data:image/jpeg;base64,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" class="d-block w-100" alt="...">
			  </div>
			  <div class="carousel-item">
				<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR56ZzCSk2Uqj8pl4S1VlghCgVEBJ0Bl3hAhQ&usqp=CAU" class="d-block w-100" alt="...">
			  </div>
			</div>
			<a class="carousel-control-prev" href="#carouselPrincipal" role="button" data-slide="prev">
			  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			  <span class="sr-only">Previous</span>
			</a>
			<a class="carousel-control-next" href="#carouselPrincipal" role="button" data-slide="next">
			  <span class="carousel-control-next-icon" aria-hidden="true"></span>
			  <span class="sr-only">Next</span>
			</a>
		</div>
		<div class="row">
			<c:forEach var="noticia" items="${ noticias }">
				<div class="col-4 p-3">
					<div class="card h-100">
						<img src="${ noticia.urlImagem }" width="100%"/> 
						<div class="card-body">
						  <h5 class="card-title"><c:out value="${ noticia.titulo }"></c:out></h5>
						  <c:out value="${ noticia.acessos }"></c:out>
						  <br>
						  <a href="#" class="btn btn-dark">Acessar Notícia</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</main>
<!-- Footer -->
	<footer>
		<div class="row">
			<div class="col-12 mt-4">
				<h3 class="text-center text-white"><strong>Conheça Nossas Redes Sociais</strong></h3>
				<ul class="list-unstyled list-inline text-center mt-4">
					<a href="" class="ml-1 mr-1" target="_blank"><li class="list-inline-item facebook"><i class="fab fa-facebook-f fa-2x"></i></li></a>
					<a href="" class="ml-1 mr-1" target="_blank"><li class="list-inline-item instagram"><i class="fab fa-instagram fa-2x"></i></li></a>
					<a href="" class="ml-1 mr-1" target="_blank"><li class="list-inline-item whatsapp"><i class="fab fa-whatsapp fa-2x"></i></li></a>
				</ul>
			</div>
			<hr>
		</div>
		<div class="row mt-2">
			<div class="col-12 text-center text-light">
				<p>Todos os direitos reservados MangáHQ!</p>
			</div>
		</div>
	</footer>
</body>
</html>