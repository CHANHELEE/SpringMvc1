package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. 파라메터 전송기능
 * http://localhost:8080/request-param?username=hello&age=20&username=hello2
 */

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(" 전체 파라메터 조회 - start ");

        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + " = " + req.getParameter(paramName)));

        System.out.println(" 전체파라메터 조회-end");
        System.out.println("-----------------------");

        System.out.println(" 단일 파라메터 조회 -start");
        String username= req.getParameter("username");
        String age = req.getParameter("age");
        System.out.println(" username = " + username);
        System.out.println(" age = " + age);
        System.out.println(" 단일 파라메터 조회 -end");

        System.out.println("---------------------------");
        System.out.println(" 이름이 같은 복수 파라메터 조회 -start"); // 쿼리 파라메터에 username이 두번 들어올 때
        String [] usernames = req.getParameterValues("username");
        for (String name:usernames){
            System.out.println("username = " + name);
        }
        System.out.println(" 이름이 같은 복수 파라메터 조회 -end");

        resp.getWriter().write("done");
    }
}
