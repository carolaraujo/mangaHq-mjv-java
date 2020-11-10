<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>

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
           <a class="nav-link" href="/mangahq/user/${ id }/home">
           	Home<span class="sr-only">(current)</span>
           </a>
         </li>
         <li class="nav-item active">
           <a class="nav-link" href="/mangahq/user/${ id }/noticias">Noticias</a>
         </li>
         <li class="nav-item active">
           <a class="nav-link" href="/mangahq/user/${ id }/mangashqs">Gerenciar Meus Mangas e HQs</a>
         </li>
         
        
        <c:if test="${ usuario.tipoUsuario == 'ADMIN' }">
         <li class="nav-item active">
           <a class="nav-link" href="/mangahq/user/${ id }/noticias/cadastro">Nova Notícia</a>
         </li>
         <li class="nav-item active">
           <a class="nav-link" href="/mangahq/user/${ id }/mangashqs/cadastro">Novo Manga/HQ</a>
         </li>
        </c:if>
        <li class="nav-item active">
          <a class="nav-link" href="/mangahq/logout">Logout</a>
        </li>
      </ul>
    </div>
  </nav>
</header>
