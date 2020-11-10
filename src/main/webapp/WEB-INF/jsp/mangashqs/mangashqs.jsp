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
    <!-- Main -->
    
    <!-- Footer -->
    <c:import url="../components/footer.jsp"></c:import>
    <!-- Footer -->
  </body>
</html>
