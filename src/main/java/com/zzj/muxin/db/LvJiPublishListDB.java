package com.zzj.muxin.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lvji_publish_list")
public class LvJiPublishListDB extends BaseEntity{

    @Column()
    private String publishContent;
    @Column()
    private String pictureUrlList;
    @Column(nullable = false)
    private String userId;
    @Column()
    private int likeNum;
    @Column()
    private int commentNum;

    public String getPublishContent() {
        return publishContent;
    }

    public void setPublishContent(String publishContent) {
        this.publishContent = publishContent;
    }

    public String getPictureUrlList() {
        return pictureUrlList;
    }

    public void setPictureUrlList(String pictureUrlList) {
        this.pictureUrlList = pictureUrlList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }
}
