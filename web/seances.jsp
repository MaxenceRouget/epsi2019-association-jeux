<%@ page import="fr.epsi.asso.model.Seance" %>
<%@ page import="java.util.List" %>
<%@include file="header.jsp"%>
<%
    if(request.getAttribute("error") != null){
        out.println(request.getAttribute("error"));
    }
%>
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
                                <p class="card-text">L'&eacute;v&egrave;nement commence le : <%=s.getStartDate()%> &agrave; : <br>
                                    <%=s.getStartTime().toString()%></p>
                                <form action="in" method="post">
                                    <input name="id"type="hidden" value="<%=s.getId()%>">
                                    <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">s'inscrire</button>
                                </form>
                                <form action="details" method="post">
                                    <input name="id"type="hidden" value="<%=s.getId()%>">
                                    <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Details :)</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
    <%}%>
</div>
<%@include file="footer.jsp"%>

