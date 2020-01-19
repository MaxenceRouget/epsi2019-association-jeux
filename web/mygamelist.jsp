<%@ page import="fr.epsi.asso.model.Jeu" %>
<%@ page import="java.util.List" %>
<%@ page import="fr.epsi.asso.model.Adherent" %>
<%@include file="header.jsp"%>
<div class="row">
<%
    Adherent a = (Adherent) session.getAttribute("User");
    List<Jeu> jeux = (List<Jeu>) request.getAttribute("MyGamesList");
    for(Jeu s : jeux){ %>
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title"><%=s.getNom()%></h5>
            <form method="post" action="remove">
                <input type="hidden" value="<%=s.getJeuId()%>" name="myIdGameToRemove">
                <input type="hidden" value="<%=a.getAdherentId()%>" name="myIdAdherentToRemove">
                <button type="submit" class="btn btn-danger">Remove</button>
            </form>
        </div>
    </div>
<%}%>
</div>
<a href="showGame" class="card-link">Ajouter un jeu</a>

<%@include file="footer.jsp"%>
