package com.zzj.muxin.vo;

import java.util.Date;

public class LvjiPublishTopicCard {
    private String id;

    private Date createAt;

    private Date updateAt;

    private String topicContent;

    private String topicKind;

    private String topicLocation;

    private String topicPicture;

    private String topicTitle;

    private String typeId;

    private String type;

    private String userId;

    private String userName;



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent == null ? null : topicContent.trim();
    }

    public String getTopicKind() {
        return topicKind;
    }

    public void setTopicKind(String topicKind) {
        this.topicKind = topicKind == null ? null : topicKind.trim();
    }

    public String getTopicLocation() {
        return topicLocation;
    }

    public void setTopicLocation(String topicLocation) {
        this.topicLocation = topicLocation == null ? null : topicLocation.trim();
    }

    public String getTopicPicture() {
        return topicPicture;
    }

    public void setTopicPicture(String topicPicture) {
        this.topicPicture = topicPicture == null ? null : topicPicture.trim();
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle == null ? null : topicTitle.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}