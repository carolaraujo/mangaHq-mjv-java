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

		.carousel-control-prev-icon,
		.carousel-control-next-icon{
			width: 25px;
			height: 25px;
		}

		.carousel-category-container-color{
			position: absolute;
			top:20px;
			left: 20px;
			padding-right: 15px;
			border-radius: 10px;
			background-color: blue;
		}

		.carousel-category-container{
			background-color: black;
			border-radius: 10px 0 0 10px;
			justify-content: center;
			align-items: center;
			display: flex;
		}

		.carousel-category{
			font-size: 22px;
			color: white;
		}

		.acessos{
			position: absolute;
			top: 10px;
			right: 10px;
			background-color: white;
			border-radius: 5px;
			border: 1px black solid;
			height: fit-content;
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
			width: 58px;
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

		<h1 class="text-center mt-2">Destaques</h1>
		<div id="carouselPrincipal" class="carousel slide mt-2" data-ride="carousel">
			<ol class="carousel-indicators">
			  <li data-target="#carouselPrincipal" data-slide-to="0" class="active"></li>
			  <li data-target="#carouselPrincipal" data-slide-to="1"></li>
			  <li data-target="#carouselPrincipal" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">
			  <div class="carousel-item active">
				<div class="carousel-category-container-color">
					<div class="carousel-category-container">
						<p class="carousel-category m-1 mr-4 ml-4">Categoria</p>
					</div>
				</div>
				<img src="https://i0.wp.com/sindicatonerd.com.br/wp-content/uploads/2016/04/Superman-BG-versions.jpg" class="d-block w-100" alt="...">
			  </div>
			  <div class="carousel-item">
				<div class="carousel-category-container-color">
					<div class="carousel-category-container">
						<p class="carousel-category m-1 mr-4 ml-4">Categoria</p>
					</div>
				</div>
				<img src="https://vingadoresbrasilcom.files.wordpress.com/2020/03/header.jpg?w=1000&h=400&crop=1" class="d-block w-100" alt="...">
			  </div>
			  <div class="carousel-item">
				<div class="carousel-category-container-color">
					<div class="carousel-category-container">
						<p class="carousel-category m-1 mr-4 ml-4">Categoria</p>
					</div>
				</div>
				<img src="https://i.pinimg.com/originals/42/d0/aa/42d0aa9293357e3850a50c654c75491f.png" class="d-block w-100" alt="...">
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
						<div class="acessos">
							<p class="mb-0 mr-1 ml-1"><i class="fas fa-eye mr-2"></i><c:out value="${ noticia.acessos }"></c:out></p>
						</div>
						<img src="${ noticia.urlImagem }" width="100%"/> 
						<div class="card-body d-flex flex-column justify-content-between">
						  <h5 class="card-title"><c:out value="${ noticia.titulo }"></c:out></h5>
						  <a href="" class="btn btn-dark w-100">Saiba mais</a>
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