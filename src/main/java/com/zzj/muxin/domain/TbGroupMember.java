package com.zzj.muxin.domain;

import java.util.Date;

public class TbGroupMember {
    private String id;

    private String alias;

    private Date createat;

    private String groupid;

    private Integer notifylevel;

    private Integer permissiontype;

    private Date updateat;

    private String userid;

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

    public Date getCreateat() {
        return createat;
    }

    public void setCreateat(Date createat) {
        this.createat = createat;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid == null ? null : groupid.trim();
    }

    public Integer getNotifylevel() {
        return notifylevel;
    }

    public void setNotifylevel(Integer notifylevel) {
        this.notifylevel = notifylevel;
    }

    public Integer getPermissiontype() {
        return permissiontype;
    }

    public void setPermissiontype(Integer permissiontype) {
        this.permissiontype = permissiontype;
    }

    public Date getUpdateat() {
        return updateat;
    }

    public void setUpdateat(Date updateat) {
        this.updateat = updateat;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
}