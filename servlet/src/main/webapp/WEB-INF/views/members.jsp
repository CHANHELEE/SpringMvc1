<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h2>회원 목록</h2>
  <table>
    <thead>
      <td>이름</td>
      <td>나이</td>
    </thead>

    <tbody>
    <c:forEach var="item" items="${memberList}">
      <tr>
        <td>${item.username}</td>
        <td>${item.age}</td>

      </tr>


    </c:forEach>


    </tbody>



  </table>



</body>
</html>
