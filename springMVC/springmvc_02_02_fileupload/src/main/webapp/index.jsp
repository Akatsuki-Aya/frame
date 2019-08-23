<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/22
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>传统文件上传</h1>
    <form action="/user/fileupload1" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload" /><br/>
        <input type="submit" value="上传">
    </form>

    <h1>SpringMVC文件上传</h1>
    <form action="/user/fileupload2" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload" /><br/>
        <input type="submit" value="上传">
    </form>

    <h1>跨服务器文件上传</h1>
    <form action="/user/fileupload3" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload" /><br/>
        <input type="submit" value="上传">
    </form>
</body>
</html>
