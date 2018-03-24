<%-- 
    Document   : header
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%-- title of the Page--%>
        <title>AUTOwash</title>
        <%-- importing CSS --%>
        <link rel="stylesheet" href="styles/header.css">
        <script type="text/javascript" src="javascript/mainJavaScript.js"></script>
    </head>
    <body>
        <%-- Code to specify Header section of the page--%>
        <div id="header">
            <nav id="header_menu">
                <ul  class="left" >
                    <li>AUTOWASH CAR CLEANING SERVICE</li>
                </ul>
                <ul class="right">
                     <li><a href="about.jsp">About Us</a></li>
                        <li><a href="abouthowit.jsp">How it Works</a></li>
                   <%-- User login to be displayed in every page--%>
                    <c:choose>
                                <c:when test="${sessionScope.theUser != null}">
                                <li>Hello, ${sessionScope.theUser.name}</li>
                                <li><a href="usercontroller?action=logout">Logout</a></li>
                                </c:when>
                                <c:when test="${sessionScope.theAdmin != null}">
                                <li>Hello, ${sessionScope.theAdmin.name}</li>
                                <li><a href="usercontroller?action=logout">Logout</a></li>
                                </c:when>
                                
                            </c:choose>    
                    </form>
                </ul>

            </nav>
        </div>


               
             

            