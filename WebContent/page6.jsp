<%-- 
    Document   : page6
--%>

<%@ include file="header2.jsp" %>

<a href="controller?action=main" id="back_to_page">&laquo;Back to the Main Page</a>
<body>
<body background="images/12.jpg">
<%-- Range of amount to be displayed forms--%>
<table id="my_studies_table" >
    <form action="controller?action=amount" method="post">
        <tr>
            <td>ENTER YOUR MAX BUDGET FOR WASH</td>
            <td>MAX VALUE</td>
        </tr>
        <tr>
            <td></td>
            <td><input type ="hidden" name="min" value="0"></td>
        </tr>
        <tr>
            <td>The Center should have amount required less than (in $):</td>
            <td><input type ="text" name="max" value="0"></td>
        </tr>
        <tr>
            <td></td>
            <td><button type="submit">Submit</button> </td>
        </tr>
      </form>
</table>
</body>

<%@ include file="footer.jsp" %>
