package hello.servlet.web.frontController.v1.controller;

import hello.servlet.web.frontController.v1.ControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1",urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerV1Map = new HashMap<>();

    public  FrontControllerServletV1(){
        //생성자로 매핑 정보 생성
        controllerV1Map.put("/front-controller/v1/members/new-form",new MemberFormControllerV1());
        controllerV1Map.put("/front-controller/v1/members/save",new MemberSaveControllerV1());
        controllerV1Map.put("/front-controller/v1/members",new MemberListControllerV1());
    }

    @Override // URI 호출 -> 클래스 호출 -> service 자동 호출
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        ControllerV1 controller = controllerV1Map.get(requestURI);

        if (controller ==null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);// 찾는 uri 가 없다면 404 에러를 보여줌
            return;
        }

        controller.process(request,response);


    }
}
