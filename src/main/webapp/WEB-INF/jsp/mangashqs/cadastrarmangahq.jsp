<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri = "http://java.sun.com/jsp/jstl/core"
prefix = "c" %> <%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix =
"fmt" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Cadastrar novo Manga/HQ</title>
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" type="text/css" href="/styles/home.css" />
    <link rel="stylesheet" type="text/css" href="/styles/navbar.css" />
    <link rel="stylesheet" type="text/css" href="/styles/footer.css" />
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
       
	            <li class="nav-item active">
	              <a class="nav-link" href="../home">
	              	Home<span class="sr-only">(current)</span>
	              </a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="../noticias">Noticias</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="../mangashqs">Gerenciar Meus Mangas e HQs</a>
	            </li>
	     
            
            <c:if test="${ usuario.tipoUsuario == 'ADMIN' }">
	            <li class="nav-item">
	              <a class="nav-link" href="../noticias/cadastro">Nova Notícia</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="../mangashqs/cadastro">Novo Manga/HQ</a>
	            </li>
            </c:if>
          </ul>
        </div>
      </nav>
    </header>
    <!-- Main -->
    <main class="container my-5">
    	<h1 class="jumbotron text-center">Cadastrar novo Manga ou HQ</h1>
    	<c:if test="${ msg != null }">
			<div class="alert alert-success" role="alert">
			  <c:out value="${ msg }"></c:out>
			</div>
		</c:if>
        <form action="/mangahq/user/${ id }/mangashqs/cadastro" method="post">
		  <div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="titulo">Titulo</label>
		      <input type="text" name="titulo" class="form-control" id="titulo" placeholder="EX: Gantz">
		    </div>
		    <div class="form-group col-md-6">
		      <label for="autor">Autor</label>
		      <input type="text" name="autor" class="form-control" id="autor" placeholder="EX: Hiroya Oku">
		    </div>
		  </div>
		  <div class="form-row">
			<div class="form-group col-4">
			  <label for="urlImagem">URL da Imagem para Capa</label>
			  <input name="urlCapa" maxlength="500" type="text" class="form-control" id="urlImagem" placeholder="http://www...">
			</div>
			<fieldset class="form-group col-4 pl-5 align-self-end">
			  <div class="row">
			    <legend class="col-form-label col-sm-2 pt-0 mr-5">Categoria</legend>
			    <div class="col-sm-10">
			      <div class="form-check">
			        <input class="form-check-input" type="radio" name="categoria" id="manga" value="MANGA" checked>
			        <label class="form-check-label" for="manga">
			          Manga
			        </label>
			      </div>
			      <div class="form-check">
			        <input class="form-check-input" type="radio" name="categoria" id="hq" value="HQ">
			        <label class="form-check-label" for="hq">
			          HQ
			        </label>
			      </div>
			    </div>
			  </div>
			</fieldset>
		    <div class="form-group col-md-4">
		      <label for="volumes">Volumes</label>
		      <input name="volumes" type="number" class="form-control" id="volumes">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="resumo">Resumo do mangá</label>
		    <textarea maxlength="800" name="resumo" class="form-control" id="resumo" rows="10"></textarea>
		  </div>
		   
		  <button type="submit" class="btn btn-primary btn-block">Cadastrar</button>
		</form>
    </main>
    <!-- Footer -->
    <footer>
      <div class="row ml-0 mr-0">
        <div class="col-12 mt-4">
          <h3 class="text-center text-white">
            <strong>Conheça Nossas Redes Sociais</strong>
          </h3>
          <ul class="list-unstyled list-inline text-center mt-4">
            <a href="#" class="ml-1 mr-1" target="_blank"
              ><li class="list-inline-item facebook">
                <i class="fab fa-facebook-f fa-2x"></i></li
            ></a>
            <a href="#" class="ml-1 mr-1" target="_blank"
              ><li class="list-inline-item instagram">
                <i class="fab fa-instagram fa-2x"></i></li
            ></a>
            <a href="#" class="ml-1 mr-1" target="_blank"
              ><li class="list-inline-item whatsapp">
                <i class="fab fa-whatsapp fa-2x"></i></li
            ></a>
          </ul>
        </div>
        <hr />
      </div>
      <div class="row mt-2 ml-0 mr-0">
        <div class="col-12 text-center text-light">
          <p>Todos os direitos reservados MangáHQ!</p>
        </div>
      </div>
    </footer>

    <script
      src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
      integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
      integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
      integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://kit.fontawesome.com/c2a97b9eb3.js"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
