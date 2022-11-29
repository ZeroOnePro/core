package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // spring container는 ApplicationContext
        // @Configuration이라는 annotation을 이용해서 애플리케이션의 구성정보를 등록했었다
        // 이 코드의 의미는 config에서 등록했던 bean들을 생성해서 컨테이너 담아놓고, 관리한다는 뜻
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 컨테이너에서 memberService를 꺼내고(bean으로 등록할 때 메서드 이름으로 관리됨), 그 타입은 MemberService이다
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        // soutv 스냅샷
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}
