<%-- 
    Document   : page9
--%>

 <%-- Include header  --%>
<%@ include file="header2.jsp" %>

<body>
<body background="images/12.jpg">
<%-- Header to display the sponsor details --%>
<section id="studies_section">

        <table id="my_studies_table" >
        <tr>
            <th>Organization Name</th>
            <th>Name of the customer</th>		
            <th>Email</th>
            <th>Action</th>
        </tr>
        <tr>
            <%-- Details --%>
            <c:forEach items="${theOrganisation}" var="entry">
            <td>${entry.cname}</td>
            <td>${entry.name}</td>
            <td>${entry.email}</td>
            <td>
                <form action="controller" method="post">
                    <input type="hidden" name="action" value="received">        
                    <input type="hidden" name="cname" value="${entry.cname}"> 
                    <input type ="hidden" name="spamount" value="0">
                    <button type="submit">Amount received</button>
                </form>
            </td>
		</c:forEach>
        </tr>
    </table>
</section>
</body>

<%-- Include tag is used to import footer --%>
<%@ include file="footer.jsp" %>


