<%@ include file="header1.jsp" %>

<link rel="stylesheet" href="styles/main.css">
<%--  Login form --%>
<a href="controller?action=home" id="back_to_page">&laquo;Back to the Home Page</a>

<body>
<body background="images/12.jpg">
<section id ="page2">
<form action="controller?action=login" method="post">
<span id="error"><c:out value="${msg}" /></span>
<br><br><center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color = "#008000">Email:<input type="email" name="email" required></font></center>
<br><br><center><font color = "#008000">Password:<input type="password" name="password" required minlength="6" maxlength="12"/></font></center><br><br>
<center><input type="submit" value="Login"></center><br><br>
</form>
</section>
</body>
  
<script>
(function (global) { 

    if(typeof (global) === "undefined") {
        throw new Error("window is undefined");
    }

    var _hash = "!";
    var noBackPlease = function () {
        global.location.href += "#";

        // making sure we have the fruit available for juice (^__^)
        global.setTimeout(function () {
            global.location.href += "!";
        }, 50);
    };

    global.onhashchange = function () {
        if (global.location.hash !== _hash) {
            global.location.hash = _hash;
        }
    };

    global.onload = function () {            
        noBackPlease();

        // disables backspace on page except on input fields and textarea..
        document.body.onkeydown = function (e) {
            var elm = e.target.nodeName.toLowerCase();
            if (e.which === 8 && (elm !== 'input' && elm  !== 'textarea')) {
                e.preventDefault();
            }
            // stopping event bubbling up the DOM tree..
            e.stopPropagation();
        };          
    }

})(window);
</script>
<%@ include file="footer.jsp" %>