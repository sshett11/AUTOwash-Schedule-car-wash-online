<%-- 
    Document   : header1
--%>
<%-- Header for all pages --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<center><h1><u>AUTOWASH ONLINE CAR CLEANING SERVICE</h1></u></center><br>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%-- Linking style sheet--%>
    <link rel="stylesheet" href="styles/main2.css">
    <div id="header">
            <nav id="header_menu">
                <ul  class="right" >
                    <%-- User login to be displayed in every page--%>
                    <c:choose>
                                <c:when test="${sessionScope.theUser != null}">
                                <li>Hello, ${sessionScope.theUser.name}</li>
                                <li><a href="controller?action=logout">Logout</a></li>
                                </c:when>
                                <c:when test="${sessionScope.theAdmin != null}">
                                <li>Hello, ${sessionScope.theAdmin.name}</li>
                                <li><a href="controller?action=logout">Logout</a></li>
                                </c:when>
                                
                    </c:choose>   
                </ul>
            </nav>
        </div>
</head>
</html>  
                  
             

            