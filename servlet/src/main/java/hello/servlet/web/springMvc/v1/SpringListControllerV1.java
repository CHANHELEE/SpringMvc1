package hello.servlet.web.springMvc.v1;


import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SpringListControllerV1 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @RequestMapping("/springmvc/v1/members")
    public ModelAndView process(){
        List<Member> memberList = memberRepository.findAll();

        ModelAndView modelAndView = new ModelAndView("members");
        modelAndView.addObject("memberList",memberList);

        return modelAndView;
    }
}
