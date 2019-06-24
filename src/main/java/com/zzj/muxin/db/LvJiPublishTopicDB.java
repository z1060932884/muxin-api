package com.zzj.muxin.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 话题数据库表
 */
@Entity
@Table(name = "lvji_publish_topic")
public class LvJiPublishTopicDB extends BaseEntity {

    @Column()
    private String topicContent;
    @Column(nullable = false)
    private String topicTitle;
    @Column()
    private String topicPicture;

    @Column(nullable = false)
    private String typeId;

    /**
     * 话题是系统发起   还是用户发起的
     * sys 是系统    user 是 用户
     */
    @Column(nullable = false)
    private String topicKind;

    @Column()
    private String topicLocation;
    /**
     * 话题发起者
     */
    @Column(nullable = false)
    private String userId;

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public String getTopicPicture() {
        return topicPicture;
    }

    public void setTopicPicture(String topicPicture) {
        this.topicPicture = topicPicture;
    }

    public String getTopicKind() {
        return topicKind;
    }

    public void setTopicKind(String topicKind) {
        this.topicKind = topicKind;
    }

    public String getTopicLocation() {
        return topicLocation;
    }

    public void setTopicLocation(String topicLocation) {
        this.topicLocation = topicLocation;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}
