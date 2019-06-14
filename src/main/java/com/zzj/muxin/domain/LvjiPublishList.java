package com.zzj.muxin.domain;

import java.util.Date;

public class LvjiPublishList {
    private String id;

    private Date createAt;

    private Date updateAt;

    private Integer commentNum;

    private Integer likeNum;

    private String publishContent;

    private String userId;

    private String publishLocation;

    private String pictureUrlList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public String getPublishContent() {
        return publishContent;
    }

    public void setPublishContent(String publishContent) {
        this.publishContent = publishContent == null ? null : publishContent.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPublishLocation() {
        return publishLocation;
    }

    public void setPublishLocation(String publishLocation) {
        this.publishLocation = publishLocation == null ? null : publishLocation.trim();
    }

    public String getPictureUrlList() {
        return pictureUrlList;
    }

    public void setPictureUrlList(String pictureUrlList) {
        this.pictureUrlList = pictureUrlList == null ? null : pictureUrlList.trim();
    }
}