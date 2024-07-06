public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello World!");
//        内存溢出
        int money = 1_000_000_000;
        int years = 20;
        int total = money * years;
        long total2 = money * years;
        long total3 = (long)money * years;
        System.out.println(total3);
    }
}