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

    /**
     * 话题发起者
     */
    @Column(nullable = false)
    private String userId;


}
