package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // 아래는 시간 순서대로 일어난 상황

        // Thread A: A 사용자 10,000원 주문
        statefulService1.order("userA", 10000);

        // Thread B: B 사용자 20,000원 주문
        statefulService2.order("userB", 20000);

        // Thread A: 사용자 A가 주문 금액 조회
        int price = statefulService1.getPrice();

        assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }

    @Test
    void statelessServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatelessService statelessService1 = ac.getBean(StatelessService.class);
        StatelessService statelessService2 = ac.getBean(StatelessService.class);

        // 아래는 시간 순서대로 일어난 상황

        // Thread A: A 사용자 10,000원 주문
        int userAPrice = statelessService1.order("userA", 10000);

        // Thread B: B 사용자 20,000원 주문
        int userBPrice = statelessService2.order("userB", 20000);

        assertThat(userAPrice).isEqualTo(10000);
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }

        @Bean
        public StatelessService statelessService(){
            return new StatelessService();
        }
    }
}