<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="hello.servlet.domain.member.Member" %><%
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> memberList=memberRepository.findAll();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>회원 목록</h1>
<table>
    <thead>
        <td>이름</td>
        <td>나이</td>
    </thead>

    <tbody>
        <%
           for(Member member:memberList){
               out.write(" <tr>");
               out.write(" <td>"+member.getUsername()+"</td>");
               out.write(" <td>"+member.getAge()+"</td>");
               out.write(" </tr>");
           }
        %>
    </tbody>
</table>
</br>
</br>
<a href="/index.html">메인</a>
</body>
</html>
