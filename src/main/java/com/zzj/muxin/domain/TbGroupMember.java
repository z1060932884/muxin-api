package com.zzj.muxin.domain;

import java.util.Date;

public class TbGroupMember {
    private String id;

    private String alias;

    private Date createAt;

    private String groupId;

    private Integer notifyLevel;

    private Integer permissionType;

    private Date updateAt;

    private String userId;

    public TbGroupMember(){

    }
    public TbGroupMember(String userId,String groupId){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public Integer getNotifyLevel() {
        return notifyLevel;
    }

    public void setNotifyLevel(Integer notifyLevel) {
        this.notifyLevel = notifyLevel;
    }

    public Integer getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(Integer permissionType) {
        this.permissionType = permissionType;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}