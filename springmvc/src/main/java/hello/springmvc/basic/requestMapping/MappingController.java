package hello.springmvc.basic.requestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.HelloData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());
    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value = {"/hello-basic","/hello-go"},method = RequestMethod.GET) //url mapping
    public  String helloBasic(){
        log.info("helloBasic");
        return "ok";
    }

    /**
     * pathVariable
     *@PathVariable("userId") 받을 변수 명과 variable 명이 같을 시 '()' 부분 생략 가능.
     */
    @GetMapping("/mapping/{userId}")
    public  String pathVariable(@PathVariable("userId") String userId){
        log.info("userId={}",userId);

        return "ok";
    }

    /**
     * 다중 pathVariable 사용
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mPathVariable(@PathVariable  String userId,@PathVariable String orderId){
        log.info("userId={}",userId);
        log.info("orderId={}",orderId);
        return "ok";
    }

    /**
     * parameter 조건부여
     * 쿼리 파라메터 mode =debug 일때만 실행 됨 .
     * http://localhost:8080/mapping/param?mode=debug 일때만 호출된다.
     * 다중 쿼리 파라메터: params = {"mode=debug","data=good"}
     */
    @GetMapping(value = "/mapping-param",params = "mode=debug")
    public String param(){
        return "ok";
    }

/**
 * Content-Type 헤더 기반 추가 매핑 Media Type * consumes="application/json"
 *     * consumes="!application/json"
 *    * consumes="application/*"
 *    * consumes="*\/*"
 *    * MediaType.APPLICATION_JSON_VALUE
 *    */

    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes() {
        log.info("mappingConsumes");

        return "ok";
 }

    /**
     * Accept 헤더 기반 Media Type * produces = "text/html"
     * produces = "!text/html" * produces = "text/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }

    /**
     * Accept 헤더 기반 Media Type * produces = "application/json"
     * json 으로 produce
     * postman 으로 test
     */
    @PostMapping(value = "/mapping-produce-json", produces = "application/json")
    public String mappingProducesJson() throws JsonProcessingException {
        log.info("mappingProduces");

        HelloData helloData = new HelloData("lee",27);
        String result = objectMapper.writeValueAsString(helloData);

        return result;
    }

}
