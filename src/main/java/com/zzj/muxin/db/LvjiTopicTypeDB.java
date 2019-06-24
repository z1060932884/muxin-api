package com.zzj.muxin.db;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 话题类型数据库表
 */
@Entity
@Table(name = "lvji_topic_type")
public class LvjiTopicTypeDB extends BaseEntity {

    @Column(nullable = false)
    private String typeTitle;

    @Column()
    private String typeDesc;
    @Column()
    private String typePicture;

    public String getTypePicture() {
        return typePicture;
    }

    public void setTypePicture(String typePicture) {
        this.typePicture = typePicture;
    }

    public String getTypeTitle() {
        return typeTitle;
    }

    public void setTypeTitle(String typeTitle) {
        this.typeTitle = typeTitle;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }
}
