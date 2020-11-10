<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html>
<head>
	<c:import url="../components/meta.jsp"></c:import>
</head>
<body>
	<!-- Navbar  -->
	<c:import url="../components/header.jsp"></c:import>
	<!-- Navbar  -->
	
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
    <c:import url="../components/footer.jsp"></c:import>
    <!-- Footer -->
</body>
</html>