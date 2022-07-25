package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository { // cmd+shift+t -> 테스트 코드 작성 shortcut

    private static Map<Long,Member> store = new HashMap<>();
    private static  long sequence =0L;


    //싱글톤
    private static final MemberRepository instance = new MemberRepository();

    public  static  MemberRepository getInstance(){
        return  instance;
    }

    private MemberRepository(){}// 프라이빗으로 만들어서 싱글톤적용


    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public  Member findById(Long id){
        Member member=store.get(id);
        return  member;
    }

    public  List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
