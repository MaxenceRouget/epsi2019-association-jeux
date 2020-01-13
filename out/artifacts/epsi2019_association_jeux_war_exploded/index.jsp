<%--
  Created by IntelliJ IDEA.
  User: PRFJ847
  Date: 10/12/2019
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
  <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Sign In</h5>
            <form class="form-signin" action="login" method="post">
              <div class="form-label-group">
                <label for="login">Login : <br/></label>
                <input type="login" id="login" name="login" class="form-control" placeholder="login" required autofocus>
              </div>

              <div class="form-label-group">
                <label for="password">Password : <br/> </label>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
              </div>
              <hr class="my-4">
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign in</button>
              <hr class="my-4">
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  </body>
</html>
