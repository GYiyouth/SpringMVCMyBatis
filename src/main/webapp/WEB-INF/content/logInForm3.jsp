<%@ page import="java.util.ArrayList" %><%--
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
    <title>Title</title>
</head>
<body>
<form action="fileUpLoad" enctype="multipart/form-data" method="post">
    文件描述
    <input type="text" id="description" name="description">
    <input type="file" id="file" name="file">
    <input type="submit" value="上传">
</form>

${requestScope.fileList}<br>

<%
    ArrayList<String> fileNameList = (ArrayList<String>) request.getAttribute("fileNameList");
%>
<form action="download" >
    <br>
    <input type="text" name="fileName"><br>
    <input type="submit" value="下载"><br>
</form>

<%for (String fileName : fileNameList){%>
<a href="http://localhost:8080/download?fileName=<%=fileName%>" ><%=fileName%></a><br>
<%}%>
</body>
</html>
