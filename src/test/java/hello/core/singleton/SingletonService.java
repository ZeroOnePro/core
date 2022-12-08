package hello.core.singleton;

public class SingletonService {

    // 자기 자신을 내부에 private 으로 가지는데 static 이다
    // 이렇게하면 클래스 레벨에 올라가기 때문에 딱 1개만 존재하게 됨
   private static final SingletonService instance = new SingletonService();

   public static SingletonService getInstance(){
       return instance;
   }

   // private 생성자를 이용해서 외부에서 인스턴스 생성을 못하게 막는다
   private SingletonService(){

   }

   public void logic(){
       System.out.println("싱글톤 객체 로직 호출");
   }
}
