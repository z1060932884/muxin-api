package com.zzj.muxin.domain;

import com.zzj.muxin.bo.GroupCreateModel;

import java.util.Date;

public class TbGroup {
    private String id;

    private Date createAt;

    private String description;

    private String name;

    private String ownerId;

    private String picture;

    private Date updateAt;

    public TbGroup(){

    }
    public TbGroup(String userId, GroupCreateModel createModel){
        this.ownerId = userId;
        this.name = createModel.getName();
        this.description = createModel.getDesc();
        this.picture = createModel.getPicture();
        this.createAt = new Date();
        this.updateAt = new Date();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId == null ? null : ownerId.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}