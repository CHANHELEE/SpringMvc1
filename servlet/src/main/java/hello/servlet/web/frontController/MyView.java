package hello.servlet.web.frontController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MyView {
    private  String viewPath;

    public  MyView(String viewPath){
        this.viewPath=viewPath;
    }


    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }

    public void render(Map<String,Object> mv, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        mv.forEach((key2,value2) -> System.out.println(key2 +" " + value2));

        mv.forEach((key,value) -> request.setAttribute(key,value));
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }
}