package com.zzj.muxin.vo;

public class UsersVO {


    private String id;

    private String username;

    private String faceImage;

    private String faceImageBig;

    private String nickname;

    private String qrcode;

    private String description;

    private String phone;

    private Integer chatSex;

    private String professional;

    private Integer bswAge;

    private Integer pictureNum;

    private String bswConstellation;


    private String bswAddress;

    private double bswLongitude;

    private double bswLatitude;

    private String bswCity;
    private int bswLike;

    private int bswFollow;

    private int bswFans;

    public String getBswAddress() {
        return bswAddress;
    }

    public void setBswAddress(String bswAddress) {
        this.bswAddress = bswAddress;
    }

    public double getBswLongitude() {
        return bswLongitude;
    }

    public void setBswLongitude(double bswLongitude) {
        this.bswLongitude = bswLongitude;
    }

    public double getBswLatitude() {
        return bswLatitude;
    }

    public void setBswLatitude(double bswLatitude) {
        this.bswLatitude = bswLatitude;
    }

    public String getBswCity() {
        return bswCity;
    }

    public void setBswCity(String bswCity) {
        this.bswCity = bswCity;
    }

    public int getBswLike() {
        return bswLike;
    }

    public void setBswLike(int bswLike) {
        this.bswLike = bswLike;
    }

    public int getBswFollow() {
        return bswFollow;
    }

    public void setBswFollow(int bswFollow) {
        this.bswFollow = bswFollow;
    }

    public int getBswFans() {
        return bswFans;
    }

    public void setBswFans(int bswFans) {
        this.bswFans = bswFans;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public Integer getBswAge() {
        return bswAge;
    }

    public void setBswAge(Integer bswAge) {
        this.bswAge = bswAge;
    }

    public String getBswConstellation() {
        return bswConstellation;
    }

    public void setBswConstellation(String bswConstellation) {
        this.bswConstellation = bswConstellation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFaceImage() {
        return faceImage;
    }

    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage;
    }

    public String getFaceImageBig() {
        return faceImageBig;
    }

    public void setFaceImageBig(String faceImageBig) {
        this.faceImageBig = faceImageBig;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getChatSex() {
        return chatSex;
    }

    public void setChatSex(Integer chatSex) {
        this.chatSex = chatSex;
    }

    public Integer getPictureNum() {
        return pictureNum;
    }

    public void setPictureNum(Integer pictureNum) {
        this.pictureNum = pictureNum;
    }
}