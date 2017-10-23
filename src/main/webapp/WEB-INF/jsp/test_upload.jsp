<%--
  Created by IntelliJ IDEA.
  User: yzxdm
  Date: 2017/10/23
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试上传</title>
    <style>

    </style>
</head>
<body>
<form method="post" action="/upload" enctype="multipart/form-data">
    <input type="file" name="uploadFile"><br><br>
    <input type="file" name="uploadFile"><br><br>
    <input type="file" name="uploadFile"><br><br>
    <button type="submit">提交</button>
</form>
<a href="${pageContext.request.contextPath }/download">下载</a>
</body>
</html>
