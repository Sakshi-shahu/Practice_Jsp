
<%@ page contentType="text/html ; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="k" uri="jakarta.tags.core" %>


<form action="addemp" method="post">

<input type="text" placeholder="enter your name"  name="uname">
<input type="number" name="salary">

<select  name="manager"  required>

<option value="" selected disabled > Select manager</option>
<k:forEach items="${manager}" var="m">
<option value="${m.mid}">
${m.mName}
</option>

</k:forEach>
</select >
<input type="submit" value="addEmp" />

</form>
<a href="emplist"><button> view epployeee</button></a>

