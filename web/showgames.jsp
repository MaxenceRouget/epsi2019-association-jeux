<%@ page import="java.util.List" %>
<%@ page import="fr.epsi.asso.model.Jeu" %>
<%@include file="header.jsp"%>

<%
    List<Jeu> list = (List<Jeu>)request.getAttribute("AddListJeu");
%>
<form action="addjeutomygames" method="post">
<div class="form-group">
    <label for="exampleFormControlSelect1">Example select</label>
    <select class="form-control" id="exampleFormControlSelect1" name="JeuToAdd">
        <%
            for(Jeu jeu : list){ %>
            <option value="<%=jeu.getJeuId()%>"><%=jeu.getNom()%></option>
        <%}%>
    </select>
</div>
    <button class="btn btn-lg btn-primary btn-block text-lowercase" type="submit">Ajouter</button>*
</form>
<%@include file="footer.jsp"%>
