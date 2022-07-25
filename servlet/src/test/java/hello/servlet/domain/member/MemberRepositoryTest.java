package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("kim",20);
        //when
        memberRepository.save(member);
        //then
        Member findMember = memberRepository.findById(member.getId());
        Assertions.assertEquals(findMember,member);
    }


    @Test
    void findAll() {
        //given
        Member member = new Member("kim",20);
        Member member2 = new Member("hello",30);
        memberRepository.save(member);
        memberRepository.save(member2);
        //when
        List<Member> memberList = memberRepository.findAll();

        //then

        Assertions.assertEquals(memberList.size(),2);

    }

}