package hello.servlet.web.springMvc.v2;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV2 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/new-form")
    public ModelAndView form(){
        return new ModelAndView("new-forms"); //properties  세팅필요
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username,age);
        memberRepository.save(member);

        ModelAndView modelAndView = new ModelAndView("save-result");
        modelAndView.addObject("member",member);

        return modelAndView;
    }

    @RequestMapping("/members")
    public ModelAndView list(){
        List<Member> memberList = memberRepository.findAll();

        ModelAndView modelAndView = new ModelAndView("members");
        modelAndView.addObject("memberList",memberList);

        return modelAndView;
    }
}
