package com.zzj.muxin.domain;

public class ChatUsers {
    private String id;

    private String username;

    private String password;

    private String faceImage;

    private String faceImageBig;

    private String nickname;

    private String qrcode;

    private String cid;

    private String description;

    private String phone;

    private Integer chatSex;

    private String professional;

    private Integer bswAge;

    private Integer pictureNum;

    private String bswConstellation;

    private String bswAddress;

    private Double bswLongitude;

    private Double bswLatitude;

    private String bswCity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getFaceImage() {
        return faceImage;
    }

    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage == null ? null : faceImage.trim();
    }

    public String getFaceImageBig() {
        return faceImageBig;
    }

    public void setFaceImageBig(String faceImageBig) {
        this.faceImageBig = faceImageBig == null ? null : faceImageBig.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode == null ? null : qrcode.trim();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getChatSex() {
        return chatSex;
    }

    public void setChatSex(Integer chatSex) {
        this.chatSex = chatSex;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional == null ? null : professional.trim();
    }

    public Integer getBswAge() {
        return bswAge;
    }

    public void setBswAge(Integer bswAge) {
        this.bswAge = bswAge;
    }

    public Integer getPictureNum() {
        return pictureNum;
    }

    public void setPictureNum(Integer pictureNum) {
        this.pictureNum = pictureNum;
    }

    public String getBswConstellation() {
        return bswConstellation;
    }

    public void setBswConstellation(String bswConstellation) {
        this.bswConstellation = bswConstellation == null ? null : bswConstellation.trim();
    }

    public String getBswAddress() {
        return bswAddress;
    }

    public void setBswAddress(String bswAddress) {
        this.bswAddress = bswAddress == null ? null : bswAddress.trim();
    }

    public Double getBswLongitude() {
        return bswLongitude;
    }

    public void setBswLongitude(Double bswLongitude) {
        this.bswLongitude = bswLongitude;
    }

    public Double getBswLatitude() {
        return bswLatitude;
    }

    public void setBswLatitude(Double bswLatitude) {
        this.bswLatitude = bswLatitude;
    }

    public String getBswCity() {
        return bswCity;
    }

    public void setBswCity(String bswCity) {
        this.bswCity = bswCity == null ? null : bswCity.trim();
    }
}