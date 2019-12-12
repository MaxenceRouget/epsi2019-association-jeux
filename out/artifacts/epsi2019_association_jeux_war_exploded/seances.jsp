<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PRFJ847
  Date: 10/12/2019
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des séances</title>
</head>
<body>
<ul>
 <c:forEach items="${requestScope.seances}" var="seance">

     <li>Séance du <c:out value="${seance.startDateTimeAsString}"/></li>
     <ul>
     <c:forEach items="${seance.inscrits}" var="adherent">
         <li><c:out value="${adherent.nom}"/></li>
     </c:forEach>
     </ul>
 </c:forEach>
</ul>
</body>
</html>
