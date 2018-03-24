<%-- 
    Document   : page9
--%>

<%@ include file="header2.jsp" %>

 <%-- Code to go Back to the Main Page  --%>
<a href="controller?action=main" id="back_to_page">&laquo;Back to the Main Page</a>
 <body>
<body background="images/12.jpg">
 <%--page which displays all org details based on the input selected --%>
<section id="studies_section">
        <table id="my_studies_table" >
        <tr>
            <th>Center Name</th>
            <th>Car type</th>		
            <th>Time required (IN MINUTES)</th>
            <th>Amount Required (IN $)</th>
            <th>Phone Number</th>
        </tr>
        <tr>            
            <c:forEach items="${theOrganisation}" var="entry">
            <td>${entry.cname}</td>
            <td>${entry.car_type}</td>
            <td>${entry.time_required}</td>
            <td>${entry.amount}</td>
            <td>
                <form action="controller" method="post">
                    <input type="hidden" name="action" value="customer">        
                    <input type="hidden" name="cname" value="${entry.cname}"> 
                    <input type ="text"  onkeypress="return validateNumber(event);" required minlength="10" maxlength="10" id ="spamount" name="spamount" value="">
                    <input type ="hidden" name="name" value="${sessionScope.theUser.name}">
                    <input type ="hidden" name="email" value="${sessionScope.theUser.email}">
                    <button type="submit" onclick="validate(getElementById('spamount').innerHTML)">Order</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </table>    
</section>
 </body>
 
 
 <script>
 function validate(amount){
	 if(amount.match(/\d/g).length===10){
		return true;
	 } else {
		 alert('Enter 10 digit phone number');
		 return false;
	 }
 }
 function validateNumber(e){
	    e = e || window.event;
	    var myCharCode = e.which ? e.which : e.keyCode;
	    return /\d/.test(String.fromCharCode(myCharCode));
}
 </script>
 
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>

