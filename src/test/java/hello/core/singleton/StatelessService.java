package hello.core.singleton;

public class StatelessService {

    public int order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
        // 지역변수를 사용하여 문제가 없게 구성
        return price;
    }
}
