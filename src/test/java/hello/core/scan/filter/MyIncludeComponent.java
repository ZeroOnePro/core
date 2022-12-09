package hello.core.scan.filter;

import java.lang.annotation.*;

// @Target 의 기능은 어노테이션을 붙일 수 있는 대상을 지정하는 것이다.
// ElementType.TYPE 은 클래스,인터페이스,열거타입에 어노테이션을 붙일 수 있다는 의미이다.
// https://seeminglyjs.tistory.com/249
@Target(ElementType.TYPE)
// @Retention 애노테이션은 애노테이션의 라이프 사이클 즉, 애노테이션이 언제까지 살아 남아 있을지를 정하는 것이다
// RetentionPolicy.RUNTIME은 런타임까지 애노테이션이 메모리에서 사라지지 않는다
// https://jeong-pro.tistory.com/234
@Retention(RetentionPolicy.RUNTIME)
// @Documented 는 javadoc2으로 api 문서를 만들 때 어노테이션에 대한 설명도 포함하도록 지정해주는 것이다
// https://blog.sunimos.me/12
@Documented
public @interface MyIncludeComponent {
}
