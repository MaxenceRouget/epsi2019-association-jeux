<%@ page import="java.util.List" %>
<%@ page import="fr.epsi.asso.model.Adherent" %>
<%@ page import="fr.epsi.asso.model.Seance" %>
<%@include file="header.jsp"%>

<%
    Adherent current = (Adherent)session.getAttribute("User");
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

<%
    if(current.isAdmin()){%>
    <form action="removeSeance" method="post">
    <input type="hidden" value="<%=s.getId()%>" name="removeSeanceId">
    &emsp;<button class="btn btn-danger" type="submit"> Supprimer</button>
<%}
%>

<%@include file="footer.jsp"%>
