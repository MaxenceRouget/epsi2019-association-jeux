<%@ page import="fr.epsi.asso.model.Jeu" %>
<%@ page import="java.util.List" %>
<%@include file="header.jsp"%>

<%
    List<Jeu> jeux = (List<Jeu>) request.getAttribute("MyGamesList");
    for(Jeu s : jeux){ %>
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title"><%=s.getNom()%></h5>
            <a href="#" class="card-link" style="color:red">Remove</a>
        </div>
    </div>
<%}%>


<%@include file="footer.jsp"%>
