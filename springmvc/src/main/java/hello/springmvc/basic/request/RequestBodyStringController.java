package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.script.ScriptContext;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyStringController {

    @PostMapping("/request-body-string-v1")
    public  void requestBodyString(HttpServletRequest request , HttpServletResponse response) throws IOException {

        ServletInputStream inputStream = request.getInputStream(); // stream은 byteCode 이기 떄문에 문자로 받을 때는 인코딩을 해주어야 한다.
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}",messageBody);

        response.getWriter().write("ok");

    }

    @PostMapping("/request-body-string-v2")
    public  void requestBodyString1(InputStream inputStream,HttpServletResponse response) throws IOException {

        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}",messageBody);

        response.getWriter().write("ok");

    }

    @PostMapping("/request-body-string-v3")
    public  HttpEntity<String> requestBodyString3(HttpEntity<String> httpEntity,HttpServletResponse response) throws IOException {


        log.info("messageBody={}",httpEntity.getBody());

        return  new HttpEntity<String>("ok"); // ok를 메세지 바디에 포함하여 반환

    }

    @ResponseBody
    @PostMapping("/request-body-string-v4")
    public  String requestBodyString4(@RequestBody String messageBody) throws IOException {


        log.info("messageBody={}",messageBody);

        return "ok" ; // ok를 메세지 바디에 포함하여 반환

    }
}
