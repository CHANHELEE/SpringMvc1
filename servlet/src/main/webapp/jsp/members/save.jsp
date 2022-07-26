<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //request , response 는 그냥 사용 가능함 . (jsp 가 자동으로 서블릿으로 변환됨)
    MemberRepository memberRepository = MemberRepository.getInstance();
    String name=request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(name,age);
    memberRepository.save(member);


%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>id=<%=member.getUsername()%></li>
    <li>id=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
