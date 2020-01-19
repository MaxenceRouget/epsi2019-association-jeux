<%@ page import="fr.epsi.asso.model.Seance" %>
<%@ page import="java.util.List" %>
<%@ page import="fr.epsi.asso.model.Adherent" %>
<%@include file="header.jsp"%>
<div class="row">
<%
    Adherent ad = (Adherent)session.getAttribute("User");
    List<Seance> seances = (List<Seance>) session.getAttribute("seances");
    for(Seance s : seances){ %>
<br>
<div class="col-sm-6">
    <div class="d-flex justify-content-center">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title"><%=s.getName()%></h5>
                <p class="card-text">L'&eacute;v&egrave;nement commence le : <%=s.getStartDate()%> &agrave; : <br>
                    <%=s.getStartTime()%></p>
            </div>
            <form action="removeInscription" method="post">
                <input type="hidden" value="<%=ad.getAdherentId()%>" name="removeInscriptionAdherentId">
                <input type="hidden" value="<%=s.getId()%>" name="removeInscriptionSeanceId">

                &emsp;<button class="btn btn-danger" type="submit"> supprimer mon inscription</button>
            </form>
        </div>
    </div>
</div>
<%}%>
</div>
<%@include file="footer.jsp"%>

