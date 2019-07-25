package com.zzj.muxin.db;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 点赞数据库
 */
@Entity
@Table(name = "lvji_like")
public class LvjiLikeDB extends BaseEntity {


    /**
     * 点赞人的id
     */
    @Column(nullable = false)
    private String likeUserId;

    /**
     * 点赞的动态id
     */
    @Column(nullable = false)
    private String publishId;

    @Column(nullable = false)
    private String faceImage;

    @Column(nullable = false)
    private String nickName;

    public String getLikeUserId() {
        return likeUserId;
    }

    public void setLikeUserId(String likeUserId) {
        this.likeUserId = likeUserId;
    }

    public String getPublishId() {
        return publishId;
    }

    public void setPublishId(String publishId) {
        this.publishId = publishId;
    }

    public String getFaceImage() {
        return faceImage;
    }

    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
