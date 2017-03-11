<%@ page import="java.util.ArrayList" %>
<%@ page import="java.net.UnknownHostException" %>
<%@ page import="java.net.InetAddress" %><%--
  Created by IntelliJ IDEA.
  User: geyao
  Date: 2017/3/8
  Time: 下午7:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <style>
        #tex1{
            margin: auto;
            text-align: center;


            /*通过line-height与height的数值比例，调整位置*/
            /*height: 180px;*/
            line-height:10px;
            font-size-adjust: 1;
            color:saddlebrown;
            font-size: 14px;

            font-family: Microsoft YaHei, KaiTi, STKaiti, sans-seri;
        }
        #tex2{
            margin: auto;
            text-align: center;


            /*通过line-height与height的数值比例，调整位置*/
            /*height: 100px;*/
            line-height:40px;
            font-size-adjust: 1;
            color:saddlebrown;
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
            background-color: lightyellow;

            /*把背景图缩放的原点定位到viewport的中心。*/
            background-position: center center;
            /*背景图始终相对于viewport固定，即使用户滚动时也是一样*/
            background-attachment: fixed;
        }
    </style>
    <style>
        a{ text-decoration:none}
    </style>
    <title>简易网盘</title>
</head>
<body class="bg"><center>
<%
    String urlAddress = "SpringMVC/";

    InetAddress hostAndIP = null;
    try { hostAndIP = InetAddress.getLocalHost(); }
    catch (UnknownHostException e) { e.printStackTrace(); }
    String ip = hostAndIP.getHostAddress();
%>
<div id="tex2">
    选择文件上传<<br
<form action="fileUpLoad" enctype="multipart/form-data" method="post"><input type="file" id="file" name="file"><input type="submit" value="上传"></form>

<%--${requestScope.fileNameList}<br>--%>

<%
    ArrayList<String> fileNameList = (ArrayList<String>) request.getAttribute("fileNameList");
%>
    点击链接，或者 输入文件名 以下载
</div>
<form action="download" >
    <br>
    <input type="text" name="fileName"><br>
    <input type="submit"  value="下载"><br>
</form>

<%for (String fileName : fileNameList){%>
<a href="download?fileName=<%=fileName%>" ><div id="tex1"><%=fileName%></div></a><br>
<%}%>

</center>
</body>
</html>
