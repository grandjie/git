package com.jie.helloservice.enum2;

/**
 * 用户组合订单状态
 */
public enum UserOrderStatus {

    UNPAID(10, "待支付"),
    PAID(20, "已支付"),
    PENDING_DELIVERY(22, "待发货"),
    ARRIVED(24, "已到达"),
    PENDING_ORDER(25, "待骑手接单"),
    PENDING_PICK_UP(26, "待骑手取货"),
    DELIVERY(30, "待收货"),
    COMPLETED(40, "已完成"),
    CUSTOMER_SERVICE(50, "售后"),
    FAILED(100, "已取消");

    private int code;
    private String desc;

    UserOrderStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int code() {
        return code;
    }

    public String desc() {
        return desc;
    }

    public static UserOrderStatus byCode(int code) {
        for (UserOrderStatus compositeOrderStatus : UserOrderStatus.values()) {
            if (compositeOrderStatus.code == code) {
                return compositeOrderStatus;
            }
        }
        return null;
    }

    public static UserOrderStatus toUserOrderStatus(OrderStatus status) {
        switch (status) {
            case UNPAID:
                return UserOrderStatus.UNPAID;
            case PAYING:
                return UserOrderStatus.UNPAID;
            case PAID:
                return UserOrderStatus.PAID;
            case PENDING_ORDER:
                return UserOrderStatus.PENDING_ORDER;
            case PENDING_PICK_UP:
                return UserOrderStatus.PENDING_PICK_UP;
            case DELIVERY:
                return UserOrderStatus.DELIVERY;
            case ARRIVED:
                return UserOrderStatus.ARRIVED;
            case COMPLETED:
                return UserOrderStatus.COMPLETED;
            case FAIL:
                return UserOrderStatus.FAILED;
        }
        return null;
    }

}
