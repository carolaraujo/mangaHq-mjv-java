<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri = "http://java.sun.com/jsp/jstl/core"
prefix = "c" %> <%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix =
"fmt" %>

<!DOCTYPE html>
<html>
  <head>
    <c:import url="./components/meta.jsp"></c:import>
  </head>
  <body>
    <!-- Navbar  -->
    <c:import url="./components/header.jsp"></c:import>
    <!-- Navbar  -->
    
    <!-- Main -->
    <main>
      <div class="container">
      
		<!-- ULTIMOS MANGAS ADICIONADOS -->
        <section class="shadow mt-3 p-3">
          <div class="h2 bg-primary pl-2 pr-2 d-inline rounded text-light">
            Ultimos mangás e HQs adicionados
          </div>
          <div class="row">
            <c:forEach var="manga" varStatus="loop" begin="0" end="5" items="${ mangas }">
              <div
                class="section-maislidas-content col-xl-2 col-md-4 col-sm-6 col-12 mt-1 mb-1"
              >
                <img
                  class="mt-4"
                  src="${ manga.urlCapa }"
                  width="100%"
                  height="240px"
                />
                <div>
                	<h5> ${ manga.titulo } </h5>
                </div>
              </div>
            </c:forEach>
          </div>
        </section>
		<!-- ULTIMOS MANGAS ADICIONADOS -->
		
		<!-- CAROUSEL -->
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
	      <c:forEach var="noticia" varStatus="loop" begin="0" end="0" items="${ carousel }">
           		<div class="carousel-item active">
		              <img
		                src="${ noticia.urlImagem }"
		                class="d-block w-100"
		                alt="..."
		              />
            	</div>
	        </c:forEach>
	        <c:forEach var="noticia" varStatus="loop" begin="1" end="2" items="${ carousel }">
	            <div class="carousel-item">
	              <img
	                src="${ noticia.urlImagem }"
	                class="d-block w-100"
	                alt="..."
	              />
	            </div>
            </c:forEach>
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
        <!-- CAROUSEL -->
        
        <!-- LISTA DE NOTÍCIAS -->
        <h1 class="text-center mt-4 mb-4">Últimas notícias</h1>
        <div class="row card-custom">
          <c:forEach var="noticia" varStatus="loop" begin="3" end="9" items="${ principaisNoticias }">
            <div class="col-md-4 col-sm-6 col-12 p-3">
              <div class="card h-100">
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
                </div>
              </div>
            </div>
          </c:forEach>
          <a href="noticias" class="btn btn-lg btn-dark w-100 my-5 mb-2">Ver todas as notícias</a>
        </div>
        <!-- LISTA DE NOTÍCIAS -->
        
      </div>
    </main>
    <!-- Main -->
    
    <!-- Footer -->
    <c:import url="./components/footer.jsp"></c:import>
    <!-- Footer -->
  </body>
</html>
