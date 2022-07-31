package hello.springmvc.basic.request;


import hello.springmvc.HelloData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static java.awt.SystemColor.info;

/**
 * {"username":"lee","age":24}
 * content-type:application/json
 * 포스트맨 사용
 */
@Slf4j
@Controller
public class RequestBodyJsonController {

    @ResponseBody
    @RequestMapping("/request-body-json-v1")
    public String requestv1(@RequestBody HelloData helloData){// 컨버터가 json 형식을 알아서 HelloData 객체로 변환해준다.

        log.info("username={} age={}",helloData.getUsername(),helloData.getUsername());
        return "body";
    }

    @ResponseBody
    @RequestMapping("/request-body-json-v3")
    public HelloData requestv2(@RequestBody HelloData helloData){// 컨버터가 json 형식을 알아서 변환해 준다.

        log.info("username={} age={}",helloData.getUsername(),helloData.getUsername());
        return helloData; //json 으로 response
    }


    @ResponseBody
    @RequestMapping("/request-body-json-v2")
    public String requestv3(@RequestBody String username){// 컨버터가 json 형식을 string 으로 알아서 변환해 준다., username

        log.info("username={}",username );
        return "username= "+username; //string 으로 response
    }


    /**
     *
     * RequestBody는 객체를 받는데 , postman에서 html 형식으로 보낼결우 에러발생
     * mvc1-6번 pdf , 46page 참고
     * @param helloData
     * @return
     */
    @ResponseBody
    @RequestMapping("/request-body-json-v4")
    public String requestv4(@RequestBody HelloData helloData){// 컨버터가 json 형식을 알아서 변환해 준다.

        log.info("username={}",helloData );
        return "username= "+helloData.getUsername(); //json 으로 response
    }


}
