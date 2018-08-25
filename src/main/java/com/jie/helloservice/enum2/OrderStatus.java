package com.jie.helloservice.enum2;

/**
 * 商城订单
 */
public enum OrderStatus {
    PRE_ADD(8, "预下单"),
    UNPAID(10, "待支付"),
    PAYING(20, "支付中"),
    PAID(30, "已支付"),
    PENDING_ORDER(32, "待接单"),
    PENDING_PICK_UP(34, "待取货"),
    ARRIVED(40, "已到达"),
    DELIVERY(45, "配送中"),
    COMPLETED(50, "已完成"),
    FAIL(100, "已取消"),
    INIT(200, "初始化");//兼容老接口

    private int code;
    private String desc;

    OrderStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static OrderStatus byCode(int code) {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if (orderStatus.code == code) {
                return orderStatus;
            }
        }
        //兼容老接口
        switch (code) {
            case 0:
            case 1:
            case 2:
                return UNPAID;
            case 3:
                return PAID;
            case 4:
                return ARRIVED;
            case 5:
                return COMPLETED;
            case 6:
                return FAIL;
        }
        return null;
    }

    public String desc() {
        return desc;
    }

    public int code() {
        return code;
    }
}
