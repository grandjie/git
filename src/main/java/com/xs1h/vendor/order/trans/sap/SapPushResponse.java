package com.xs1h.vendor.order.trans.sap;

import java.io.Serializable;

public class SapPushResponse implements Serializable {

    private String status = "OK"; // 只有OK和ERROR两种

    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SapPushResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
