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
    <main class="container my-5">
    	<h1 class="jumbotron text-center">Cadastrar novo Manga ou HQ</h1>
    	<c:if test="${ errormsg != null }">
			<c:forEach var="msg" items="${ errormsg }">
				<div class="alert alert-danger" role="alert">
				  <c:out value="${ msg }"></c:out>
				</div>
			</c:forEach>
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
			<div class="form-group col-md-4 col-6">
			  <label for="volumes">Volumes</label>
		      <input name="volumes" type="number" class="form-control" id="volumes">
			</div>
			<fieldset class="form-group col-6 col-md-4 pl-5 align-self-end">
			    <legend class="col-form-label">Categoria</legend>
			    <div>
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
			</fieldset>
		    <div class="form-group col-md-4 col-12">
		      <label for="urlImagem">URL da Imagem para Capa</label>
			  <input name="urlCapa" maxlength="500" type="text" class="form-control" id="urlImagem" placeholder="http://www...">
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
    <c:import url="../components/footer.jsp"></c:import>
    <!-- Footer -->
  </body>
</html>
