<%@ page import="fr.epsi.asso.model.Adherent" %>
<%@include file="header.jsp"%>

<%
    Adherent a = new Adherent();
    a = (Adherent) session.getAttribute("User");
    if(a.isAdmin()){ %>
        <br>
        <div class="container">
            <form action="newadherent" method="post">
                <div class="form-label-group">
                    <label for="nameA">Nom : <br/></label>
                    <input type="text" id="nameA" name="nomAdherent" class="form-control" placeholder="nom" required autofocus>
                </div>
                <div class="form-label-group">
                    <label for="login">Login : <br/> </label>
                    <input type="text" id="login" name="loginA" class="form-control" placeholder="login" required>
                </div>
                <div class="form-label-group">
                    <label for="mdpA">Mot de passe : <br/></label>
                    <input type="login" id="mdpA" name="mdpA" class="form-control" placeholder="mot de passe" required autofocus>
                </div>
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1" name="checkAdmin">
                    <label class="form-check-label" for="exampleCheck1">Est administrateur ?</label>
                </div>
                <hr class="my-4">
                <button type="submit" class="btn btn-success">Ajouter</button>
            </form>
        </div>
        <%}
        else{%>
        <div class="alert alert-danger" role="alert">
            Vous n'&ecirc;tes pas administrateur !
        </div>
<%}%>

<%@include file="footer.jsp"%>
