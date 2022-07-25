package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet" , urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override // 서블렛(url)이 호출되면 , 서비스가 자동 호출됨
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("helloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username"); // 클라이언트가 username 이라는 파라메터 쿼리로 날리게 되면 값을 받는다.
        System.out.println("username = " + username); // 클라이언트가 url 에 입력한 username의 값

        response.setContentType("text/plain"); // http 의 헤더에 들어갈 내용
        response.setCharacterEncoding("utf-8"); // http 의 헤더에 들어갈 내용
        response.getWriter().write("hello " + username); // 사용자의 request에 대응하는 response

        String usersex = request.getParameter("usersex");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(" hi " + usersex);

    }
}
