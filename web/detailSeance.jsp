<%@ page import="java.util.List" %>
<%@ page import="fr.epsi.asso.model.Adherent" %>
<%@ page import="fr.epsi.asso.model.Seance" %>
<%@include file="header.jsp"%>

<%
    Seance s = (Seance) request.getAttribute("SeanceForSeance");
%>
<div class="jumbotron">
    <h1 class="display-4"><%=s.getName()%></h1>
    <p class="lead">La s&eacute;ance est le : <%=s.getStartDate()%> et commence &agrave; <%=s.getStartTime()%></p>
    <br>
    Les adh&eacute;rents :
    <hr class="my-4">
<%
    List<Adherent> adherents = (List<Adherent>) request.getAttribute("AdherentForSeance");
    for(Adherent a : adherents){ %>
            <p class="lead">
                <a class="btn btn-primary btn-lg" role="button"><%=a.getNom()%>></a>
            </p>
    <%}%>
</div>
<%@include file="footer.jsp"%>
