<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/21
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--常用注解--%>
    <a href="/anno/testRequestParam?name=哈哈" >RequestParam</a>

    <br>

    <form action="/anno/testRequestBody" method="post">
        用户姓名:<input type="text" name="username"><br/>
        用户年龄:<input type="text" name="age"><br/>
        <input type="submit" value="提交"><br/>
    </form>
    <br>

    <a href="/anno/testPathVariable/10" >testPathVariable</a>

    <br>

    <a href="/anno/testRequestHeader" >testRequestHeader</a>

    <br>

    <a href="/anno/testCookieValue" >CookieValue</a>

    <br>

    <form action="/anno/testModelAttribute" method="post">
        用户姓名:<input type="text" name="uname"><br/>
        用户年龄:<input type="text" name="age"><br/>
        <input type="submit" value="提交"><br/>
    </form>

    <br>
    <a href="/anno/testSessionAttributes" >testSessionAttributes</a>
    <br>
    <a href="/anno/getSessionAttributes" >getSessionAttributes</a>
    <br>
    <a href="/anno/delSessionAttributes" >delSessionAttributes</a>
</body>
</html>
