package hello.springmvc.basic.response;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView response1(){
        ModelAndView model = new ModelAndView("response/hello")
                .addObject("data","hello");

        return  model;

    }


    @RequestMapping("/response-view-v2")
    public String response2(Model model){
        String data ="hello";
        model.addAttribute("data",data);
        return  "/response/hello";

    }

    @RequestMapping("/response/hello") // Void 로 받으면 URL 을 그대로 논리적 뷰로 연결시켜 준다.
    public void response3(Model model){
        String data ="hello";
        model.addAttribute("data",data);

    }
}
