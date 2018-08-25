package com.jie.helloservice.address;

import com.jie.helloservice.common.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressManager {

    @Value(value = "${xs.amap.key}")
    private String AMAP_KEY;      //个人
    //    private static final String AMAP_KEY = "6094da373341e55c603427699c75a371";      //个人
    //行政区域查询
    @Value("${xs.amap.configDistrict}")
    private String CONFIG_DISTRICT;
    //    private static final String CONFIG_DISTRICT = "http://restapi.amap.com/v3/config/district?key=" + AMAP_KEY;
    //地理编码
//    private static final String GEOCODE_GEO_URL = "http://restapi.amap.com/v3/geocode/geo?key=" + AMAP_KEY;
    //逆地理编码
//    private static final String GEOCODE_REGEO_URL = "http://restapi.amap.com/v3/geocode/regeo?key=" + AMAP_KEY;
    //周边搜索
//    private static final String PLACE_AROUND = "http://restapi.amap.com/v3/place/around?key=" + AMAP_KEY;
    //关键字搜索
//    private static final String PLACE_TEXT = "http://restapi.amap.com/v3/place/text?key=" + AMAP_KEY;
    //住宿服务-100100，商务住宅-120000，交通设施服务(机场相关-150100，火车站-150200)，公司企业-170000
    private static final String POI_TYPE = "100100|120000|150100|150200|170000";

    private Logger logger = LoggerFactory.getLogger(AddressManager.class);

    private AddressRepo repo;

    public AddressManager(AddressRepo addressRepo) {
        this.repo = addressRepo;
    }

    @GetMapping(value = "/add")
    @Transactional
    public String listByUser(@RequestParam(required = false) String area, @RequestParam(required = false) String city) {
//        INSERT INTO `address` (`id`, `adcode`, `area`, `city`, `citycode`, `create_date`, `detail`, `latitude`, `longitude`, `phone_number`, `province`, `receiver_name`, `user_id`)
//VALUES
//	('00cf9ece-7366-49ac-9815-c29a9aa9c640', '310105', '神州智慧天地', '上海市', '021', '2018-06-11 20:27:46', '5B', 31.218081, 121.356567, '13641728655', '上海市', '倪耀', '93c560de-f85f-4838-abd0-c2a45936658e');
        AddressEntity entity = new AddressEntity();
        entity.setArea(area);
        entity.setCity(city);
//        repo.save(entity);
        System.out.println(AMAP_KEY);
        System.out.println(CONFIG_DISTRICT);
        return "save success";
    }

    @GetMapping("/get")
    public AddressEntity get(@RequestParam String city) {
        AddressEntity entity = repo.findByCity(city).orElse(null);
        return entity;
    }

}