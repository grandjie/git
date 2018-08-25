package com.jie.helloservice.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {

    private static ExecutorService executor = Executors.newSingleThreadScheduledExecutor();

//    public static void main(String[] args) {
//        System.out.println("first");
//        System.out.println(test());
//        System.out.println("second");
//            executor.shutdown();
//
//    }
//
//    public static String test() {
//        executor.submit(() -> {
//            try {
//                Thread.sleep(5000);
//                System.out.println("it's good");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        return "yes";
//    }

    public static void main(String[] args) {

        String str = null;

        str = String.format("Hi,%s", "飞龙");          // 格式化字符串

        System.out.println(str);                             // 输出字符串变量str的内容

        System.out.printf("字母a的大写是：%c %n", 'A');

        System.out.printf("3>7的结果是：%b %n", 3 > 7);

        System.out.printf("100的一半是：%d %n", 100 / 2);

        System.out.printf("100的16进制数是：%x %n", 100);

        System.out.printf("100的8进制数是：%o %n", 100);

        System.out.printf("50元的书打8.5折扣是：%f 元%n", 50 * 0.85);

        System.out.printf("上面价格的16进制数是：%a %n", 50 * 0.85);

        System.out.printf("上面价格的指数表示：%e %n", 50 * 0.85);

        System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50 * 0.85);

        System.out.printf("上面的折扣是%d%% %n", 85);

        System.out.printf("字母A的散列码是：%h %n", 'A');

    }

}
