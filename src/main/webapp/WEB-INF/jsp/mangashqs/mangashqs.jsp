<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri = "http://java.sun.com/jsp/jstl/core"
prefix = "c" %> <%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix =
"fmt" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Meus Mangas e HQs</title>
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" type="text/css" href="/styles/mangashqs.css" />
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
       
	            <li class="nav-item">
	              <a class="nav-link" href="home">
	              	Home
	              </a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="noticias">Notícias</a>
	            </li>
	            <li class="nav-item active">
	              <a class="nav-link" href="mangashqs">Gerenciar Meus Mangas e HQs<span class="sr-only">(current)</span></a>
	            </li>
	            
            
            <c:if test="${ usuario.tipoUsuario == 'ADMIN' }">
	            <li class="nav-item">
	              <a class="nav-link" href="noticias/cadastro">Nova Notícia</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="mangashqs/cadastro">Novo Manga/HQ</a>
	            </li>
            </c:if>
          </ul>
        </div>
      </nav>
    </header>
    <!-- Main -->
    <main>
      <div class="container pt-3">
        <h1 class="text-sm-left text-center">Meus Mangas</h1>
        <ul class="list-group list-group-flush my-3">
	      	<c:forEach var="mangahq" items="${ listmangahq }">
	      		<li class="list-group-item">
		      		<div class="row">
						<div class="col-sm-6 col-12">
							<h5><c:out value="${ mangahq.titulo }"></c:out></h5>
							<p><c:out value="${ mangahq.resumo }"></c:out></p>
						</div>
						<div class="col-sm-6 col-12 d-flex justify-content-center">
							<img src="${ mangahq.urlCapa }" height="250px" />
						</div>
		      		</div>
      			</li>
	      	</c:forEach>
      	</ul>
      	
      	<c:if test="${ naoAdquiridos.size() != 0 }">
      		<h1 class="text-sm-left text-center" >Ainda não adquiridos:</h1>
      	</c:if>
      	<ul class="list-group list-group-flush my-3">
      	<c:forEach var="mangahq" items="${ naoAdquiridos }">
      		<li class="list-group-item">
	      		<form class="row" action="/mangahq/user/${ id }/mangashqs/adquirir/${ mangashq.id_mangahq }" method="get">
					<div class="col-sm-6 col-12">
						<h5><c:out value="${ mangahq.titulo }"></c:out></h5>
						<p><c:out value="${ mangahq.resumo }"></c:out></p>
					</div>
					<div class="col-sm-6 col-12 d-flex justify-content-center">
						<img src="${ mangahq.urlCapa }" height="250px" />
						<input type="hidden" name="id_manga_hq" value="${ mangahq.id_mangahq }">
	      				<button class="btn btn-primary px-3" style="height: 250px; position: relative; right: 5px; border-bottom-left-radius: 0px; border-top-left-radius: 0px" type="submit">Adquirir</button>
					</div>
	      		</form>
      		</li>
      	</c:forEach>
      	</ul>
      </div>
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
    <script>
      function showTitle(img) {
        document.getElementById("title-" + img.id).style.display = "flex";
      }

      function hideTitle(img) {
        document.getElementById(img.id).style.display = "none";
      }
    </script>
  </body>
</html>
