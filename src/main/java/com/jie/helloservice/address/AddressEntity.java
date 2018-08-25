package com.jie.helloservice.address;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "address")
public class AddressEntity {
    @Id
    @Column(name = "id", length = 64)
    private String id = UUID.randomUUID().toString();

    @Column(name = "receiver_name", length = 64)
    private String receiverName;

    @Column(name = "phone_number", length = 32)
    private String phoneNumber;

    @Column(name = "province", length = 64)
    private String province;

    @Column(name = "city", length = 64)
    private String city;

    @Column(name = "area", length = 64)
    private String area;

    @Column(name = "detail", length = 128)
    private String detail;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "citycode", length = 32)
    private String citycode;    //城市编码,例如：010

    @Column(name = "adcode", length = 32)
    private String adcode;  //区域编码,例如：110101

    @Column(name = "user_id", length = 64)
    private String userId; // 用户

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate = new Date();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "id='" + id + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", detail='" + detail + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", citycode='" + citycode + '\'' +
                ", adcode='" + adcode + '\'' +
                ", userId='" + userId + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
