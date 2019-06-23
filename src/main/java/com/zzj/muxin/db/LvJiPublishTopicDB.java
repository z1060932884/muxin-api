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
}
