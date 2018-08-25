package com.jie.helloservice.webservice;

import com.xs1h.vendor.order.trans.sap.SapPushResponse;
import com.xs1h.vendor.order.trans.sap.SapPushTransService;
import com.xs1h.vendor.order.trans.sap.SapShopData;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import java.util.ArrayList;
import java.util.List;

public class WebServiceTest {
//    public static void main(String[] args) throws Exception {
//        JaxWsDynamicClientFactory dcf =JaxWsDynamicClientFactory.newInstance();
//        Client client =dcf.createClient("http://localhost:8003/ws/sap/push?wsdl");
//        SapShopData sapShopData = new SapShopData();
//        sapShopData.setKUNNR("200068");
//        sapShopData.setNAME1("平南路店");
//        sapShopData.setZSELLING_AREA("15.000");
//        sapShopData.setSTRAS("平南路1号");
//        sapShopData.setTELF2("18516225864");
//        sapShopData.setZSTART_DAT("20170101");
//        sapShopData.setZCLOSE_DAT("20170731");
//        sapShopData.setVWERK("1200");
//        sapShopData.setVKORG("1200");
//        sapShopData.setKTOKD("Z020");
//        sapShopData.setBRAN1("1027");
//        sapShopData.setNAME2("督导");
//        sapShopData.setNAME4("科室经理");
//        sapShopData.setVTEXT("苏D1");
//        List<SapShopData> list = new ArrayList<>();
//        list.add(sapShopData);
//        Object[] objects = client.invoke("addPushShopData", list);
//        //输出调用结果
//        System.out.println("*****"+objects[0].toString());
//    }

    public static void main(String[] args) throws Exception {
        /*JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client = dcf.createClient("http://localhost:8003/ws/user?wsdl");
        //getUser 为接口中定义的方法名称  张三为传递的参数   返回一个Object数组
        Object[] objects = client.invoke("getUser", "411001");
        //输出调用结果
        System.out.println("*****" + ((User2)objects[0]).getUsername());*/


        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(SapPushTransService.class);
        factoryBean.setAddress("http://localhost:8003/ws/sap/push?wsdl");

        SapShopData sapShopData = new SapShopData();
        sapShopData.setKUNNR("200068");
        sapShopData.setNAME1("平南路店");
        sapShopData.setZSELLING_AREA("15.000");
        sapShopData.setSTRAS("平南路1号");
        sapShopData.setTELF2("18516225864");
        sapShopData.setZSTART_DAT("20170101");
        sapShopData.setZCLOSE_DAT("20170731");
        sapShopData.setVWERK("1200");
        sapShopData.setVKORG("1200");
        sapShopData.setKTOKD("Z020");
        sapShopData.setBRAN1("1027");
        sapShopData.setNAME2("督导");
        sapShopData.setNAME4("科室经理");
        sapShopData.setVTEXT("苏D1");
        List<SapShopData> list = new ArrayList<>();
        list.add(sapShopData);

        SapPushTransService sapPushTransService = (SapPushTransService) factoryBean.create();
        SapPushResponse sapPushResponse = sapPushTransService.addPushShopData(list);
        System.out.println("Response: " + sapPushResponse);
    }
}
