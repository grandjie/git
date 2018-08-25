package com.xs1h.vendor.order.trans.sap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/*
接收SAP推送服务接口
 */
@WebService
public interface SapPushTransService {

    // 接收SAP商品主数据
//    @WebMethod
//    SapPushResponse addPushGoodsData(@WebParam(name = "goods") List<SapGoodsData> goodses);

    /*// TODO 仅用于测试
    @WebMethod
    String getPushGoodsData2(SapGoodsData goods);*/

    // 接收SAP门店主数据
    @WebMethod
    SapPushResponse addPushShopData(@WebParam(name = "shop") List<SapShopData> shops);

//    /*// TODO 统一请求接口
//    @WebMethod
//    String getPushData(@WebParam(name = "reqContent") String reqContent);*/
//
//    // 接收SAP供应商主数据
//    @WebMethod
//    SapPushResponse addPushSupplierData(@WebParam(name = "supplier") List<SapPushSupplierData> suppliers);
//
//    // 接收SAP配送单数据
//    @WebMethod
//    SapPushResponse addPushDeliveryData(@WebParam(name = "delivery") List<SapPushDeliveryData> deliveries);

}
