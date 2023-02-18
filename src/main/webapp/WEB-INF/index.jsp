<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Ninja Gold Game</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/sketchy.css" />
    <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
    <!-- change to match your file/naming structure -->
  </head>
  <body>
    <div class="container text-center mt-5 p-3">
      <h1>Ninja Gold Game</h1>
      <h1>Your Gold: <c:out value="${gold}" /></h1>
    </div>
    <div class="container d-flex justify-content-around mt-5 gap-3">
      <div class="card col">
        <div class="card-header text-center">
          <h2>Farm</h2>
        </div>
        <div class="card-body text-center p-5">
          <h5>(earns 10-20 gold)</h5>
          <form action="/" method="post">
            <input
              class="button mt-3"
              type="submit"
              value="Find Gold!"
              name="farm"
            />
          </form>
        </div>
      </div>
      <div class="card col">
        <div class="card-header text-center">
          <h2>Cave</h2>
        </div>
        <div class="card-body text-center p-5">
          <h5>(earns 5-10 gold)</h5>
          <form action="/" method="post">
            <input
              class="button mt-3"
              type="submit"
              value="Find Gold!"
              name="cave"
            />
          </form>
        </div>
      </div>
      <div class="card col">
        <div class="card-header text-center">
          <h2>House</h2>
        </div>
        <div class="card-body text-center p-5">
          <h5>(earns 2-5 gold)</h5>
          <form action="/" method="post">
            <input
              class="button mt-3"
              type="submit"
              value="Find Gold!"
              name="house"
            />
          </form>
        </div>
      </div>
      <div class="card col">
        <div class="card-header text-center">
          <h2>Quest</h2>
        </div>
        <div class="card-body text-center p-5">
          <h5>(earns/takes 0-50 gold)</h5>
          <form action="/" method="post">
            <input
              class="button mt-3"
              type="submit"
              value="Find Gold!"
              name="quest"
            />
          </form>
        </div>
      </div>
    </div>
    <div class="container mt-5">
      <div class="card">
        <div class="card-header text-center">
          <h2>Activities:</h2>
        </div>
        <div class="card-body p-5">
          <!-- <h4>(Activities will be listed here)</h4> -->
          <!-- <h4><c:out value = "${activities}" /></h4> -->
          <h4>
            <!-- ===vvv=== FOR LOOP using c:forEach ===vvv=== -->
            <c:forEach var="activity" items="${activities}">
              <!-- ====== IF STATEMENTS using c:if ====== -->
              <!-- Text color => green='earned' | red='lost' -->
              <c:if test="${activity.contains('earned')}">
                <p style="color: green"><c:out value="${activity}" /></p>
              </c:if>
              <c:if test="${activity.contains('lost')}">
                <p style="color: red"><c:out value="${activity}" /></p>
              </c:if>
            </c:forEach>
          </h4>
        </div>
      </div>
    </div>
  </body>
</html>
