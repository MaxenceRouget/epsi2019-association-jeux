<%@ page import="fr.epsi.asso.model.Seance" %>
<%@ page import="java.util.List" %>
<%@include file="header.jsp"%>
<br>
<div class="row">
<%
List<Seance> seances = (List<Seance>) request.getAttribute("seances");
    for(Seance s : seances){ %>
            <div class="col-sm-6">
                <div class="d-flex justify-content-center">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title"><%=s.getName()%></h5>
                            <p class="card-text">L'&eacute;v&egrave;enement commence &agrave; : <%=s.getStartDateTimeAsString()%></p>
                            <a href="#" class="btn btn-primary">Allons voir !</a>
                        </div>
                    </div>
                </div>
            </div>
<%}
%>
</div>
</body>
</html>
