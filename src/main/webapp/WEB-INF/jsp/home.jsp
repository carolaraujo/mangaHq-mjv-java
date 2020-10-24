<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="noticia" items="${ noticias }">
		<p><c:out value="${ noticia.titulo }"></c:out></p>
		<img src="${ noticia.urlImagem }" width="200px"/> <span><c:out value="${ noticia.acessos }"></c:out></span>
	</c:forEach>
</body>
</html>