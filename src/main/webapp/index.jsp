<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        #tex{
            margin: auto;
            text-align: center;


            /*通过line-height与height的数值比例，调整位置*/
            height: 180px;
            line-height:100px;
            font-size-adjust: 1;
            color:white;
            font-size: 30px;

            font-family: sans-serif;
        }
        #tex2{
            margin: auto;
            text-align: center;


            /*通过line-height与height的数值比例，调整位置*/
            /*height: 100px;*/
            line-height:40px;
            font-size-adjust: 1;
            color:white;
            font-size: 21px;

            /*font-family: sans-serif;*/
            font-family: Microsoft YaHei, KaiTi, STKaiti, sans-serif;
        }

    </style>
    <style type="text/css">
        .bg
        {
            background-image: url('coder.png');
            background-repeat: no-repeat;
            background-size:cover;
            /*刷新时，会先显示黑色，直到载入完成*/
            background-color: black;

            /*把背景图缩放的原点定位到viewport的中心。*/
            background-position: center center;
            /*背景图始终相对于viewport固定，即使用户滚动时也是一样*/
            background-attachment: fixed;
        }
    </style>
    <style>
        a{ text-decoration:none}
    </style>
    <title>欢 迎</title>
    <%
        String urlAddress = "SpringMVC/";
    %>
</head>
<body class="bg"><center>

    <%--<a href="logInForm1">测试 ModelAttribute(value="")注释返回具体类</a><br>--%>
    <%--<a href="logInForm2">@ModelAttribute注释void返回值的方法</a><br>--%>
    <div id="tex"> </div>
    <a href="<%=urlAddress%>logInForm3">

        <div id="tex2">点我，进入网盘</div>

    </a>
    <%--<img src="<%=request.getContextPath() %>/最厉害的人.jpg">--%>
</center>
</body>
</html>
