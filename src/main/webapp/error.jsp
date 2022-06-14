<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Error</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

 <!-- Page title -->
<hr>

   <div class="row center-block text-center">
        <h1>ERROR</h1>
    </div>



<div class="row center-block text-center">
<h2>${requestScope['javax.servlet.error.status_code']}</h2>
<p>${requestScope['javax.servlet.error.message']}</p>
</div>


  <div class="row center-block text-center">
        <h3>${message}</h3>
    </div>
<hr>

    <div class="col-6">
       <a href="index.jsp">
	      <div class="d-grid gap-2 col-8 mx-auto">
            <button type="submit" class="btn btn-secondary btn-lg btn-block">Home</button>
          </div>
       </a>
    </div>

 </div>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>

<c:remove var = "message" />