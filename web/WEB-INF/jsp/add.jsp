<%--
  Created by IntelliJ IDEA.
  User: liyu
  Date: 2018/1/27
  Time: 下午4:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/command.do" method="post">
        姓名： <input type="text" name="username" id="username">
        年龄： <input type="text" name="age" id="age">
        生日： <input type="text" name="birthday" id="birthday">
        地址： <input type="text" name="address" id="address">
        <input type="submit" value="提交">
    </form>
</body>
</html>
