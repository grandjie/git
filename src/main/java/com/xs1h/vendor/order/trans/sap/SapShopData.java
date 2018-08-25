package com.xs1h.vendor.order.trans.sap;

import java.io.Serializable;

/*
接收SAP推送的 门店主数据
 */
public class SapShopData implements Serializable {

    private String KUNNR;    // 门店编码
    private String NAME1;    // 门店名称
    private String ZSELLING_AREA;    // 营业面积
    private String STRAS;    // 门店地址
    private String TELF2;    // 联系电话
    private String ZSTART_DAT;    // 开店日期
    private String ZCLOSE_DAT;    // 闭店日期
    private String VWERK;    // 交货工厂
    private String VKORG;    // 销售组织
    private String AUFSD;    // 禁用标识
    private String KTOKD;    // 账户组
    private String BRAN1;    // 商圈
    private String NAME2;    // 督导
    private String NAME4;    // 科室经理
    private String VTEXT;    // 车牌
    private String NIELS;    // 订货周期
    private String UDP1;    // 预留
    private String UDP2;    // 预留
    private String UDP3;    // 预留

    public String getKUNNR() {
        return KUNNR;
    }

    public void setKUNNR(String KUNNR) {
        this.KUNNR = KUNNR;
    }

    public String getNAME1() {
        return NAME1;
    }

    public void setNAME1(String NAME1) {
        this.NAME1 = NAME1;
    }

    public String getZSELLING_AREA() {
        return ZSELLING_AREA;
    }

    public void setZSELLING_AREA(String ZSELLING_AREA) {
        this.ZSELLING_AREA = ZSELLING_AREA;
    }

    public String getSTRAS() {
        return STRAS;
    }

    public void setSTRAS(String STRAS) {
        this.STRAS = STRAS;
    }

    public String getTELF2() {
        return TELF2;
    }

    public void setTELF2(String TELF2) {
        this.TELF2 = TELF2;
    }

    public String getZSTART_DAT() {
        return ZSTART_DAT;
    }

    public void setZSTART_DAT(String ZSTART_DAT) {
        this.ZSTART_DAT = ZSTART_DAT;
    }

    public String getZCLOSE_DAT() {
        return ZCLOSE_DAT;
    }

    public void setZCLOSE_DAT(String ZCLOSE_DAT) {
        this.ZCLOSE_DAT = ZCLOSE_DAT;
    }

    public String getVWERK() {
        return VWERK;
    }

    public void setVWERK(String VWERK) {
        this.VWERK = VWERK;
    }

    public String getVKORG() {
        return VKORG;
    }

    public void setVKORG(String VKORG) {
        this.VKORG = VKORG;
    }

    public String getAUFSD() {
        return AUFSD;
    }

    public void setAUFSD(String AUFSD) {
        this.AUFSD = AUFSD;
    }

    public String getKTOKD() {
        return KTOKD;
    }

    public void setKTOKD(String KTOKD) {
        this.KTOKD = KTOKD;
    }

    public String getBRAN1() {
        return BRAN1;
    }

    public void setBRAN1(String BRAN1) {
        this.BRAN1 = BRAN1;
    }

    public String getNAME2() {
        return NAME2;
    }

    public void setNAME2(String NAME2) {
        this.NAME2 = NAME2;
    }

    public String getNAME4() {
        return NAME4;
    }

    public void setNAME4(String NAME4) {
        this.NAME4 = NAME4;
    }

    public String getVTEXT() {
        return VTEXT;
    }

    public void setVTEXT(String VTEXT) {
        this.VTEXT = VTEXT;
    }

    public String getNIELS() {
        return NIELS;
    }

    public void setNIELS(String NIELS) {
        this.NIELS = NIELS;
    }

    public String getUDP1() {
        return UDP1;
    }

    public void setUDP1(String UDP1) {
        this.UDP1 = UDP1;
    }

    public String getUDP2() {
        return UDP2;
    }

    public void setUDP2(String UDP2) {
        this.UDP2 = UDP2;
    }

    public String getUDP3() {
        return UDP3;
    }

    public void setUDP3(String UDP3) {
        this.UDP3 = UDP3;
    }

    @Override
    public String toString() {
        return "SapShopData{" +
                "KUNNR='" + KUNNR + '\'' +
                ", NAME1='" + NAME1 + '\'' +
                ", ZSELLING_AREA='" + ZSELLING_AREA + '\'' +
                ", STRAS='" + STRAS + '\'' +
                ", TELF2='" + TELF2 + '\'' +
                ", ZSTART_DAT='" + ZSTART_DAT + '\'' +
                ", ZCLOSE_DAT='" + ZCLOSE_DAT + '\'' +
                ", VWERK='" + VWERK + '\'' +
                ", VKORG='" + VKORG + '\'' +
                ", AUFSD='" + AUFSD + '\'' +
                ", KTOKD='" + KTOKD + '\'' +
                ", BRAN1='" + BRAN1 + '\'' +
                ", NAME2='" + NAME2 + '\'' +
                ", NAME4='" + NAME4 + '\'' +
                ", VTEXT='" + VTEXT + '\'' +
                ", NIELS='" + NIELS + '\'' +
                ", UDP1='" + UDP1 + '\'' +
                ", UDP2='" + UDP2 + '\'' +
                ", UDP3='" + UDP3 + '\'' +
                '}';
    }
}

