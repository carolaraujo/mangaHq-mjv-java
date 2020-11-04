<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastrar Noticia</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	<script src="https://kit.fontawesome.com/c2a97b9eb3.js" crossorigin="anonymous"></script>
	<link rel="stylesheet" type="text/css" href="/styles/navbar.css">
	<link rel="stylesheet" type="text/css" href="/styles/cadastrarnoticia.css">
	<link rel="stylesheet" type="text/css" href="/styles/footer.css">
</head>
<body>
<!-- Navbar  -->
	<header>
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">MangáHQ!</a>
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
       
	            <li class="nav-item">
	              <a class="nav-link" href="../home">
	              	Home
	              </a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="../noticias">Notícias</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="../mangashqs">Gerenciar Meus Mangas e HQs</a>
	            </li>
	            
            
            <c:if test="${ usuario.tipoUsuario == 'ADMIN' }">
	            <li class="nav-item active">
	              <a class="nav-link" href="cadastro">Nova Notícia<span class="sr-only">(current)</span></a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="../mangashqs/cadastro">Novo Manga/HQ</a>
	            </li>
            </c:if>
            <li class="nav-item">
              	<a class="nav-link" href="/mangahq/logout">Logout</a>
            </li>
          </ul>
        </div>
      </nav>
    </header>
    <!-- MAIN -->	
	<main class="container my-5">
		<h1 class="jumbotron text-center">Cadastrar Notícia</h1>
		<c:if test="${ errormsg != null }">
			<c:forEach var="msg" items="${ errormsg }">
				<div class="alert alert-danger" role="alert">
				  <c:out value="${ msg }"></c:out>
				</div>
			</c:forEach>
		</c:if>
		<form action="/mangahq/user/${ id }/noticias/cadastro" method="post">
		  <div class="form-group">
		    <label for="titulo">Título da notícia</label>
		    <input name="titulo" maxlength="100" type="text" class="form-control" id="titulo" placeholder="Título da notícia">
		  </div>
		  <div class="form-row">
			<div class="form-group col-6">
			  <label for="urlImagem">URL de Imagem para a notícia</label>
			  <input name="urlImagem" maxlength="500" type="text" class="form-control" id="urlImagem" placeholder="http://www...">
			</div>
			<fieldset class="form-group col-6 pl-5 align-self-end">
			    <legend class="col-form-label">Categoria</legend>
			    <div class="form-check">
			        <input class="form-check-input" type="radio" name="categoria" id="manga" value="MANGA" checked>
			        <label class="form-check-label" for="manga">
			          Mangá
			        </label>
			    </div>
			    <div class="form-check">
			        <input class="form-check-input" type="radio" name="categoria" id="hq" value="HQ">
			        <label class="form-check-label" for="hq">
			          HQ
			        </label>
			    </div>
			</fieldset>
		  </div>
		  <div class="form-group">
		    <label for="textoNoticia">Texto da notícia</label>
		    <textarea maxlength="800" name="textoConteudo" class="form-control" id="textoNoticia" rows="10"></textarea>
		  </div>
		  <button type="submit" class="btn btn-primary btn-block btn-lg mt-5">Cadastrar</button>
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
</body>
</html>