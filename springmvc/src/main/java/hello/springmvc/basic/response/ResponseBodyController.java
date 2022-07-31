package hello.springmvc.basic.response;

import hello.springmvc.HelloData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ResponseBodyController {

    @GetMapping("/response-body-string-v1")
    public void  responseBody1(HttpServletResponse response) throws IOException{
        response.getWriter().write("ok");
    }

    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBody2()  {
            return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBody3()  {
        return "ok";
    }

    @GetMapping("/response-body-json-v1")
    public  ResponseEntity<HelloData> jsonv1(){
        HelloData helloData = new HelloData("userA",20);
        return new ResponseEntity<>(helloData,HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/response-body-json-v2")
    public  HelloData jsonv2(){
        HelloData helloData = new HelloData("userA",20);
        return  helloData;
    }







}
