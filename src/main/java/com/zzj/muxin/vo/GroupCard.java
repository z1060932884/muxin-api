package com.zzj.muxin.vo;

import com.google.gson.annotations.Expose;
import com.zzj.muxin.db.Group;
import com.zzj.muxin.db.GroupMember;
import com.zzj.muxin.domain.TbGroup;
import com.zzj.muxin.domain.TbGroupMember;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 群信息Model
 *
 * @author qiujuer Email:qiujuer.live.cn
 */
public class GroupCard {
    @Expose
    private String id;// Id
    @Expose
    private String name;// 名称
    @Expose
    private String desc;// 描述
    @Expose
    private String picture;// 群图片
    @Expose
    private String ownerId;// 创建者Id
    @Expose
    private int notifyLevel;// 对于当前用户的通知级别
    @Expose
    private Date joinAt;// 加入时间
    @Expose
    private Date modifyAt;// 最后修改时间



    public GroupCard(TbGroup group) {
        this(group, null);
    }

    public GroupCard(TbGroup group, TbGroupMember member) {
        this.id = group.getId();
        this.name = group.getName();
        this.desc = group.getDescription();
        this.picture = group.getPicture();
        this.ownerId = group.getOwnerId();
        this.notifyLevel = member != null ? member.getNotifyLevel() : 0;
        this.joinAt = member != null ? member.getCreateAt() : null;
        this.modifyAt = group.getUpdateAt();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public int getNotifyLevel() {
        return notifyLevel;
    }

    public void setNotifyLevel(int notifyLevel) {
        this.notifyLevel = notifyLevel;
    }

    public Date getJoinAt() {
        return joinAt;
    }

    public void setJoinAt(Date joinAt) {
        this.joinAt = joinAt;
    }

    public Date getModifyAt() {
        return modifyAt;
    }

    public void setModifyAt(Date modifyAt) {
        this.modifyAt = modifyAt;
    }
}
