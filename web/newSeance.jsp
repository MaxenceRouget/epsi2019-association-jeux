<%--
  Created by IntelliJ IDEA.
  User: maxencerouget
  Date: 13/01/2020
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="fr.epsi.asso.model.Adherent" %>
<%@ include file="header.jsp"%>
<%//add date for restrict html//
    LocalDate date = LocalDate.now();
    LocalDate date1 = date.plusYears(1);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String dateNow = date.format(formatter).toString();
    String datePlus1 = date1.format(formatter);

    Adherent a = new Adherent();
    try{
        a = (Adherent) session.getAttribute("User");
    } catch (Exception e){
        a.setLogin("Anonymous");
        a.setAdmin(false);
    }
    if(a.isAdmin()){ %>
<br>

<div class="container">
    <p>
        Entrez un jour et une heure pour votre s&eacute;ance :<br/>
        Et un nom !
    </p>
    <form action="addSeance" method="post">
        <div class="form-row">
            <div class="form-group">
                <input type="text" class="form-control" name="name" placeholder="Entrez un nom">
            </div>
            <div class="col-5">
                <input name="date" type="date" class="form-control" placeholder="Entrez une date" min="<%=date%>" max="<%=datePlus1%>">
            </div>
            <div class="col-5">
                 <input name="time" type="time" class="form-control" placeholder="State" min="09:30" max="20:30">
            </div>
        </div>
        <br>
            <button type="submit" class="btn btn-success">Valider !</button>
    </form>
</div>
    <%}
    else{%>
    <div class="alert alert-danger" role="alert">
        Vous n'&ecirc;tes pas administrateur !
    </div>
    <%}%>
</body>
</html>

