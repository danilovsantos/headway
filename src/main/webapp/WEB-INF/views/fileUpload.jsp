<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload de Arquivo</title>
<%-- <link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet" type="text/css"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet" type="text/css"></link> --%>
</head>
<body>

	<div class="form-container">
		<h1>Upload de Arquivo</h1>
		<form:form action="/headway/uploadFile" method="POST" modelAttribute="uploadFile" enctype="multipart/form-data">

			<form:input type="file" path="file" id="file"/>
			
			<div>
				<div>
					<input type="submit" value="Upload">
				</div>
			</div>

		</form:form>
		
		<c:if test="${filialMaiorFat.nome != null}">
			<div>
				<h3>Filial com maior faturamento:</h3>
				<c:out value="${filialMaiorFat.nome}"></c:out>
			</div>
		</c:if>
		
		<c:if test="${filialMenorFat.nome != null}">
			<div>
				<h3>Filial com menor faturamento:</h3>
				<c:out value="${filialMenorFat.nome}"></c:out>
			</div>
		</c:if>
		
		<c:if test="${mes != null}">
			<div>
				<h3>Mês de maior faturamento:</h3>
				<c:out value="${mes}"></c:out>
			</div>
		</c:if>
		
	</div>
</body>
</html>