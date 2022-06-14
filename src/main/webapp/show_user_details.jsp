<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>

    <head>
        <title>User Profile</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>

    <body>

  <hr>
     <div class="row center-block text-center">
          <h1> User Profile </h1>
     </div>

  <hr>

         <nav class="navbar navbar-light bg-light">
                <div class="container-fluid">
                    <div class="col-4">
                          <form action="user" method = "get" class="d-flex">
                              <input type="hidden" name="command" value="get_user_by_family_name">
                              <div class="col-8">
                                 <input class="form-control me-2" type="text" placeholder="Enter family name" name="family_name">
                              </div>
                              <div class="col-4">
                                  <button class="btn btn-outline-secondary btn-md btn-block" type="submit">Search</button>
                              </div>
                          </form>
                    </div>
                    <div class="col-4">
                        <form action="user/">
                              <div class="col-4">
                                  <input type="hidden" name="command" value="get_all_users">
                                  <button class="btn btn-outline-secondary btn-md btn-block" type="submit">All users</button>
                              </div>
                        </form>
                    </div>
                </div>
         </nav>


    <div class="row center-block text-center">
         <h4>${message}</h4>
    </div>


<form action="user" method="post">
    <table class="table table-striped table-hover">
        <tr>
            <th>Given name</th>
                <c:choose>
                   <c:when test="${user == null}">
                      <td>
                          <input type="text" name = "given_name"  placeholder="Enter given name" required>
                      </td>
                   </c:when>
                   <c:otherwise>
                     <td>
                           <input type="text" name = "given_name" value = ${user.givenName} required>
                     </td>
                   </c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr>
            <th>Family name</th>
                <c:choose>
                   <c:when test="${user == null}">
                      <td>
                          <input type="text" name = "family_name"  placeholder="Enter family name">
                      </td>
                   </c:when>
                   <c:otherwise>
                     <td>
                           <input type="text" name = "family_name" value = ${user.familyName}>
                     </td>
                   </c:otherwise>
                </c:choose>
        </tr>
        <tr>
            <th>Phone number</th>
                <c:choose>
                   <c:when test="${user == null}">
                      <td>
                          <input type="text" name = "phone_number"  placeholder="Enter phone number"/>
                      </td>
                   </c:when>
                   <c:otherwise>
                     <td>
                           <input type="text" name = "phone_number" value = ${user.phoneNumber}>
                     </td>
                   </c:otherwise>
                </c:choose>
        </tr>
        <tr>
            <th>Age</th>
             <c:choose>
                <c:when test="${user == null}">
                   <td>
                       <input type="number" name = "age"  min="0" step="1" placeholder="Enter age"/>
                   </td>
                </c:when>
                <c:otherwise>
                  <td>
                        <input type="number" name = "age" min="0" step="1" value = ${user.age}>
                  </td>
                </c:otherwise>
             </c:choose>
        </tr>
        </table>

    <hr>

    <c:choose>
          <c:when test="${user == null}">
               <input type="hidden" name="command" value = "create_user">
               <input type="hidden" name="id" value = "0">
                      <div class="d-grid gap-2 col-6 mx-auto">
                          <button class="btn btn-secondary btn-md btn-block" type="submit">Create user</button>
                      </div>
          </c:when>
          <c:otherwise>
                <input type="hidden" name="command" value = "update_user">
                <input type="hidden" name="id" value = ${user.id}>
                        <div class="d-grid gap-2 col-6 mx-auto">
                            <button class="btn btn-secondary btn-md btn-block" type="submit">Update user</button>
                        </div>
          </c:otherwise>
     </c:choose>
</form>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>

<c:remove var = "message" />