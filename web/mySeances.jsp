<%@ page import="fr.epsi.asso.model.Seance" %>
<%@ page import="java.util.List" %>
<%@include file="header.jsp"%>
<div class="row">
<%
    List<Seance> seances = (List<Seance>) session.getAttribute("seances");
    for(Seance s : seances){ %>
<br>
<div class="col-sm-6">
    <div class="d-flex justify-content-center">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title"><%=s.getName()%></h5>
                <p class="card-text">L'&eacute;v&egrave;nement commence le : <%=s.getStartDate()%> &agrave; : <br>
                    <%=s.getStartTime().toString()%></p>
            </div>
        </div>
    </div>
</div>
<%}%>
</div>
</body>
</html>
