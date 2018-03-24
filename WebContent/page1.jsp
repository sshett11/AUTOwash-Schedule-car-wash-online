<%@ include file="header.jsp" %>

<body>
<body background="images/12.jpg">
<br><h3><marquee direction="left">Most convenient way to keep your car shining</marquee></h3><br>

<%-- Sign in forms--%>
<a href="page2.jsp"><h3>Click to login</h3></a>
<a href="page3.jsp"><h3>If you are a new user,click here to sign up</h3></font></a><br><br><br>
    

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
