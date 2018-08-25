package com.jie.helloservice.xs1h;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FlowUpdateTest {


    //update `flow`.`flow_lock` set `remain`='320.1' where `id`='5078c862-5964-4e44-b677-58332e59b839';
//    public static void main(String[] args) {
//                        // TODO 最后一笔流水ID
//        String flowId = "a73db278-a56e-49c9-8b87-6089003fd63b";
//                            // TODO 最后一笔流水余额
//        BigDecimal b1 = BigDecimal.valueOf(907.50);
//                                // TODO 应打金额
//        BigDecimal b2 = BigDecimal.valueOf(2465);
//        BigDecimal b3 = b1.add(b2);
//        //巴比杭州地铁景芳站店
//        String storeId1 = "5078c862-5964-4e44-b677-58332e59b839";
//        //巴比锦江乐园店
//        String storeId2 = "57033597-0ce9-493b-83fc-a6817077ed81";
//        System.out.println("巴比杭州地铁景芳站店");
//        StringBuilder sb = new StringBuilder();
//        sb.append("update `flow`.`capital_flow` set `remain`='").append(b3).append("' where `id`='").append(flowId).append("';");
//        System.out.println(sb.toString());
//        StringBuilder sb2 = new StringBuilder();
//        sb2.append("update `flow`.`flow_lock` set `remain`='").append(b3).append("' where `id`='").append(storeId1).append("';");
//        System.out.println(sb2.toString());
//        StringBuilder sb3 = new StringBuilder();
//        System.out.println("巴比锦江乐园店");
//        sb3.append("update `flow`.`capital_flow` set `remain`='").append(b3).append("' where `id`='").append(flowId).append("';");
//        System.out.println(sb3.toString());
//        StringBuilder sb4 = new StringBuilder();
//        sb4.append("update `flow`.`flow_lock` set `remain`='").append(b3).append("' where `id`='").append(storeId1).append("';");
//        System.out.println(sb4.toString());
//    }

    public static void main(String[] args) {
        String str = "1200";
        double b1 = 1000;
        int b2 = 21;
        System.out.println(b1 / b2);
        System.out.println(str.substring(0, 2));
        System.out.println(str.substring(2, 4));
//        SimpleDateFormat sdf = new SimpleDateFormat();
//        System.out.println(date);
//        String s = autoGenericCode("17", 2);
//        System.out.println(s);
    }

    @Test
    public void test() {
//        this.printToConsole(autoGenericCode("10011"));
//        this.printToConsole(autoGenericCode("000",3));
    }

    /**
     * 不够位数的在前面补0，保留code的长度位数字
     *
     * @param code
     * @return
     */
    private String autoGenericCode(String code) {
        String result = "";
        // 保留code的位数
        result = String.format("%0" + code.length() + "d", Integer.parseInt(code) + 1);

        return result;
    }

    /**
     * 不够位数的在前面补0，保留num的长度位数字
     *
     * @param code
     * @return
     */
    private static String autoGenericCode(String code, int num) {
        String result = "";
//        保留num的位数
//    　　 0 代表前面补充0
//        num 代表长度为4
//        d 代表参数为正数型
        result = String.format("%0" + num + "d", Integer.parseInt(code));

        return result;
    }

}