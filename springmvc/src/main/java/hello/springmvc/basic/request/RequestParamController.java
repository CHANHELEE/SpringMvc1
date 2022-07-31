package hello.springmvc.basic.request;


import hello.springmvc.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response, @RequestParam String username,
                               @RequestParam int age) throws IOException {

        log.info("username={} age={}", username,age);
        response.getWriter().write("ok");

    }

    @ResponseBody // @RestController와 같은 기능
    @RequestMapping("/request-param-v2")
    public String requestParamV2(HttpServletRequest request, HttpServletResponse response, @RequestParam String username,
                               @RequestParam int age) {

        log.info("username={} age={}", username,age);
        return "ok";
    }

    @ResponseBody // @RestController와 같은 기능
    @RequestMapping("/request-param-v3")
    public String requestParamV3(HttpServletRequest request, HttpServletResponse response,String username, int age)
             {

        log.info("username={} age={}", username,age);
        return "ok";
    }

    /**
     *
     * @param request
     * @param response
     * @param username
     * @param age
     * @return
     *
     * localhost:8080/request-param-required?username=lee&age=20
     */
    @ResponseBody // @RestController와 같은 기능
    @RequestMapping("/request-param-required")
    public String requestParamRequired(HttpServletRequest request, HttpServletResponse response
            ,@RequestParam(required = true) String username// required= true 반드시 값이 넘어와야함, false = 값이 넘어오지 않아도 됨.
            ,@RequestParam(required = false) Integer age) // int 는 null 을 받지 못하기 때문에 Integer로 변경.
    {

        log.info("username={} age={}", username,age);
        return "ok";
    }


    @ResponseBody // @RestController와 같은 기능
    @RequestMapping("/request-param-default")
    public String requestParamDefault(HttpServletRequest request, HttpServletResponse response
            ,@RequestParam(required = true, defaultValue = "guest") String username// required= true 반드시 값이 넘어와야함, false = 값이 넘어오지 않아도 됨.
            ,@RequestParam(required = false, defaultValue = "-1") Integer age) // int 는 null 을 받지 못하기 때문에 Integer로 변경.
            //defuaultValue 가 있으면 required 가 필요가 없다.
    {

        log.info("username={} age={}", username,age);
        return "ok";
    }

    @ResponseBody // @RestController와 같은 기능
    @RequestMapping("/request-param-map")
    public String requestParamMap(HttpServletRequest request, HttpServletResponse response,
                                  @RequestParam Map<String,Object> paramMap)
    //defuaultValue 가 있으면 required 가 필요가 없다.
    {


        log.info("username={} age={}",paramMap.get("username"),paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttribute(@ModelAttribute HelloData helloData){
        log.info("helloData.username ={}",helloData.getUsername());
        log.info("helloData.age ={}",helloData.getAge());

        return  "ok";

    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2( HelloData helloData){ // @ModelAttribute 생략가능
        log.info("helloData.username ={}",helloData.getUsername());
        log.info("helloData.age ={}",helloData.getAge());

        return  "ok";

    }


    @ResponseBody
    @RequestMapping(value = "/post-request",method = RequestMethod.POST)
    public String requestParam( @ModelAttribute  HelloData helloData,@RequestParam String username, @RequestParam int age){ // @ModelAttribute 생략가능
        log.info("Request param username={}",username);
        log.info("Request param age={}",age);

        log.info("helloData.username ={}",helloData.getUsername());
        log.info("helloData.age ={}",helloData.getAge());

        return  "ok";

    }



}
