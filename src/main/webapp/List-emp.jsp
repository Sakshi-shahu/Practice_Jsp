<%@ page contentType="text/html ; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Slary</th>
      <th scope="col">Mid</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${emplist}" var="e">
    <tr>
      <th scope="row">${e.empid}</th>
      <td>${e.empname}</td>
      <td>${e.salary}</td>
      <td>${e.manager}</td>
    </tr>
   </c:forEach>
  </tbody>
</table>

