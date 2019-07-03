package com.zzj.muxin.bo;

public class NearbyUserBo {

    private String userId;

    /**
     * 经度
     */
    private double longitude;

    /*
    纬度
     */
    private double latitude;

    /**
     * 当前具体位置
     */
    private String address;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
