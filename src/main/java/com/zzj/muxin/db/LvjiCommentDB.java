package com.zzj.muxin.db;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 话题类型数据库表
 */
@Entity
@Table(name = "lvji_comment")
public class LvjiCommentDB extends BaseEntity {

    /**
     * 评论的内容
     */
    @Column(nullable = false)
    private String content;
    /**
     * 评论人的id
     */
    @Column(nullable = false)
    private String commentUserId;

    /**
     * 评论的动态id
     */
    @Column(nullable = false)
    private String publishId;

    @Column(nullable = false)
    private String faceImage;

    @Column(nullable = false)
    private String nickName;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(String commentUserId) {
        this.commentUserId = commentUserId;
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
