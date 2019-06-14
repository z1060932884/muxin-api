package com.zzj.muxin.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author qiujuer Email:qiujuer@live.cn
 * @version 1.0.0
 */
@Entity
@Table(name = "TB_GROUP_MEMBER")
public class GroupMember extends BaseEntity{
    public static final int PERMISSION_TYPE_NONE = 0; // 默认权限，普通成员
    public static final int PERMISSION_TYPE_ADMIN = 1;  // 管理员
    public static final int PERMISSION_TYPE_ADMIN_SU = 100; // 创建者

    public static final int NOTIFY_LEVEL_INVALID = -1; // 默认不接收消息
    public static final int NOTIFY_LEVEL_NONE = 0; // 默认通知级别
    public static final int NOTIFY_LEVEL_CLOSE = 1; // 接收消息不提示


    // 别名
    @Column
    private String alias;

    // 消息通知级别
    @Column(nullable = false)
    private int notifyLevel = NOTIFY_LEVEL_NONE;


    // 成员的权限类型
    @Column(nullable = false)
    private int permissionType = PERMISSION_TYPE_NONE;



    @Column(nullable = false, updatable = false, insertable = false)
    private String userId;


    // 成员信息对应的群信息
    @Column(nullable = false, updatable = false, insertable = false)
    private String groupId;


    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getNotifyLevel() {
        return notifyLevel;
    }

    public void setNotifyLevel(int notifyLevel) {
        this.notifyLevel = notifyLevel;
    }

    public int getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(int permissionType) {
        this.permissionType = permissionType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
