package hello.servlet.web.frontController.v3;

import hello.servlet.web.frontController.ModelView;
import hello.servlet.web.frontController.MyView;
import hello.servlet.web.frontController.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontController.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontController.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3",urlPatterns = "/front-controller/v3/*")
public class FrontControllerV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerV3Map = new HashMap<>();

    public FrontControllerV3(){
        //생성자로 매핑 정보 생성
        controllerV3Map.put("/front-controller/v3/members/new-form",new MemberFormControllerV3());
        controllerV3Map.put("/front-controller/v3/members/save",new MemberSaveControllerV3());
        controllerV3Map.put("/front-controller/v3/members",new MemberListControllerV3());
    }

    @Override // URI 호출 -> 클래스 호출 -> service 자동 호출
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        ControllerV3 controller = controllerV3Map.get(requestURI);

        if (controller ==null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);// 찾는 uri 가 없다면 404 에러를 보여줌
            return;
        }
        //paraMap
        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);


        String viewName = mv.getViewName();
        MyView view = viewResolver(viewName);

        view.render(mv.getModel(),request,response);


    }

    private MyView viewResolver(String viewName) {
        MyView view=new MyView("/WEB-INF/views/"+ viewName +".jsp");
        return view;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String,String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName ->paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}

