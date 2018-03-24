<%@ include file="header1.jsp" %>

<a href="controller?action=home" id="back_to_page">&laquo;Back to the Home Page</a>
<%--  Sign Up form --%>

<body>
<body background="images/12.jpg">
<section id ="page2">
<form action="controller?action=signup" method="post">
<span id="error"><c:out value="${msg}" /></span>
<br><br><center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color = "#228B22">Name:  <input type="text" name="name" required/></font></center>
<br><br><center>&nbsp;&nbsp;&nbsp;<font color = "#228B22">Email:    <input type="email" name="email" required></font></center>
<br><br><center><font color = "#228B22">Password:<input type="password" name="password" required minlength="6" maxlength="12"/></font></center>
<br><br><center><font color = "#228B22">Re-Enter:<input type="password" name="confirm_password" required minlength="6" maxlength="12"/></font></center>
<br><br><center><input type="submit" value="Sign Up"></center><br><br>
</form>
</section>
</body>
  

 <%@ include file="footer.jsp" %>
