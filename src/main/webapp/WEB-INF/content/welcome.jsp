<%--
  Created by IntelliJ IDEA.
  User: geyao
  Date: 2017/3/7
  Time: 下午10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.-1 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome</title>
</head>
<body><center>
${requestScope.message}<br>
${requestScope.user.userName}<br>
${sessionScope.user.userName}<br>
</center>
</body>
</html>
