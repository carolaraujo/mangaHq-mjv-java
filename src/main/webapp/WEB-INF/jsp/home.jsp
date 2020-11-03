<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri = "http://java.sun.com/jsp/jstl/core"
prefix = "c" %> <%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix =
"fmt" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>MangaHQ</title>
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
	              <a class="nav-link" href="home">
	              	Home<span class="sr-only">(current)</span>
	              </a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="noticias">Noticias</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="mangashqs">Gerenciar Meus Mangas e HQs</a>
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
      <div class="container">
        <section class="shadow mt-3 p-3">
          <div class="h2 bg-primary pl-2 pr-2 d-inline rounded text-light">
            Mais lidas da semana
          </div>
          <div class="row">
            <c:forEach var="noticia" items="${ maisLidas }">
              <div
                class="section-maislidas-content col-xl-2 col-md-4 col-sm-6 col-12 mt-1 mb-1"
              >
                <img
                  id="${ noticia.id_noticia }"
                  onmouseenter="showTitle(this)"
                  class="mt-1"
                  src="${ noticia.urlImagem }"
                  width="100%"
                  height="100%"
                />
                <div
                  id="title-${ noticia.id_noticia }"
                  onmouseleave="hideTitle(this)"
                  class="hover-titulo align-middle justify-content-center mt-1 h-100"
                >
                  <div class="m-auto text-center">${ noticia.titulo }</div>
                </div>
              </div>
            </c:forEach>
          </div>
        </section>

        <h1 class="text-center d-none d-md-block mt-4 mb-4">Destaques</h1>
        <div
          id="carouselPrincipal"
          class="carousel slide mt-2"
          data-ride="carousel"
        >
          <ol class="carousel-indicators d-none d-md-flex">
            <li
              data-target="#carouselPrincipal"
              data-slide-to="0"
              class="active"
            ></li>
            <li data-target="#carouselPrincipal" data-slide-to="1"></li>
            <li data-target="#carouselPrincipal" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner d-none d-md-block">
            <div class="carousel-item active">
              <img
                src="https://i0.wp.com/sindicatonerd.com.br/wp-content/uploads/2016/04/Superman-BG-versions.jpg"
                class="d-block w-100"
                alt="..."
              />
            </div>
            <div class="carousel-item">
              <img
                src="https://vingadoresbrasilcom.files.wordpress.com/2020/03/header.jpg?w=1000&h=400&crop=1"
                class="d-block w-100"
                alt="..."
              />
            </div>
            <div class="carousel-item">
              <img
                src="https://i.pinimg.com/originals/42/d0/aa/42d0aa9293357e3850a50c654c75491f.png"
                class="d-block w-100"
                alt="..."
              />
            </div>
          </div>
          <a
            class="carousel-control-prev"
            href="#carouselPrincipal"
            role="button"
            data-slide="prev"
          >
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a
            class="carousel-control-next"
            href="#carouselPrincipal"
            role="button"
            data-slide="next"
          >
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
        <h1 class="text-center mt-4 mb-4">Últimas notícias</h1>
        <div class="row card-custom">
          <c:forEach var="noticia" items="${ principaisNoticias }">
            <div class="col-md-4 col-sm-6 col-12 p-3">
              <div class="card h-100">
                <div class="acessos">
                  <p class="mb-0 mr-1 ml-1">
                    <i class="fas fa-eye mr-2"></i
                    ><c:out value="${ noticia.acessos }"></c:out>
                  </p>
                </div>
                <img
                  class="card-img-top"
                  src="${ noticia.urlImagem }"
                  width="100%"
                />
                <div
                  class="card-body d-flex flex-column justify-content-between"
                >
                  <h5 class="card-title">
                    <c:out value="${ noticia.titulo }"></c:out>
                  </h5>
                  <p class="card-text">
                    <c:out value="${ noticia.textoConteudo }"></c:out>
                  </p>
                  <a href="" class="btn btn-dark w-100">Saiba mais</a>
                </div>
              </div>
            </div>
          </c:forEach>
        </div>
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
