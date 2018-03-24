<%-- 
    Document   : page5
--%>
<!DOCTYPE html>
<%@ include file="header2.jsp" %>

<a href="controller?action=main" id="back_to_page">&laquo;Back to the Main Page</a>

<%--  Display different species --%>
<body>
<body background="images/12.jpg">
<br><br><h3><center>WHAT WOULD YOU LIKE TO CHOOSE</center></h3>
<UL>
<br><LI><a href="controller?action=car_type&car_type=SUV"><h2>SUV/MUV</h2></LI></a>
<br><LI><a href="controller?action=car_type&car_type=SEDAN"><h2>SEDAN</h2></LI></a>
<br><LI><a href="controller?action=car_type&car_type=HATCHBACK"><h2>COUPE/HATCHBACK</h2></LI></a>
<br><LI><a href="controller?action=car_type&car_type=RV"><h2>RV/MINI TRUCK</h2></LI></a>
</UL>
</body>

<%@ include file="footer.jsp" %>
