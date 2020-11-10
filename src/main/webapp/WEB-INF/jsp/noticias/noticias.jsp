<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri = "http://java.sun.com/jsp/jstl/core"
prefix = "c" %> <%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix =
"fmt" %>

<!DOCTYPE html>
<html>
  <head>
    <c:import url="../components/meta.jsp"></c:import>
  </head>
  <body>
   	<!-- Navbar  -->
	<c:import url="../components/header.jsp"></c:import>
	<!-- Navbar  -->
	
    <!-- Main -->
    <main>
      <div class="container">    
        <h1 class="text-center mt-4 mb-4">Últimas notícias</h1>
        <div class="row card-custom">
          <c:forEach var="noticia" items="${ principaisNoticias }">
            <div class="col-lg-4 col-md-6 col-sm-12 col-12 p-3">
              <div class="card h-100">
                <img
                  class="card-img-top"
                  src="${ noticia.urlImagem }"
                  width="100%"
                />
                <div
                  class="card-body d-flex flex-column"
                >
                  <h5 class="card-title">
                    <c:out value="${ noticia.titulo }"></c:out>
                  </h5>
                  <p class="card-text">
                    <c:out value="${ noticia.textoConteudo }"></c:out>
                  </p>
                  <button type="button" class="btn btn-primary w-100 mt-auto" data-toggle="modal" data-target="#noticia${noticia.id_noticia}">
                  	Detalhes
                  </button>
                  
                <!-- Modal -->
				<div class="modal fade" id="noticia${noticia.id_noticia}" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
				  <div class="modal-dialog modal-dialog-scrollable modal-lg">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title" id="staticBackdropLabel">${ noticia.titulo }</h5>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				      <div class="modal-body">
				      	<div class="row">
				      		<h2><span class="badge badge-danger ml-2">${ noticia.categoria }</span></h2>
				        	<small class="col-12 text-right font-weight-bold">Autor: <span class="font-weight-normal">${ noticia.autor }</span> / Publicado em: <span class="font-weight-normal">${ noticia.dataPublicacao }</span></small>
				        
				        </div>
				        <div class="row">
				        	<img class="col-12 h-100" alt="" src="${ noticia.urlImagem }">
				        </div>
				        <hr />
				        <div class="row">
				        	<p class="col-12 text-justify">
				        		${ noticia.textoConteudo }
				        	</p>
				        </div>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				        <c:choose>
				        	<c:when test="${ usuario.tipoUsuario == 'ADMIN' }">
						        <button type="button" class="btn btn-primary">Editar</button>
						        <button type="button" class="btn btn-danger">Excluir</button>
				        	</c:when>
				        	<c:otherwise>
				        		<button type="button" class="btn btn-primary" disabled="disabled">Editar</button>
				        		<button type="button" class="btn btn-danger" disabled="disabled">Excluir</button>
				        	</c:otherwise>
				        </c:choose>
				        
				      </div>
				    </div>
				  </div>
				</div>
				
                </div>
              </div>
            </div>
          </c:forEach>
        </div>
      </div>
    </main>
    <!-- Footer -->
    <c:import url="../components/footer.jsp"></c:import>
    <!-- Footer -->
  </body>
</html>
