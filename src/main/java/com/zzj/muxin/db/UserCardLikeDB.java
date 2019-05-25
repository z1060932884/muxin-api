package com.zzj.muxin.db;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "zzj_like_user")
public class UserCardLikeDB  extends BaseEntity {

    // 成员的权限类型
    @Column(nullable = false)
    private String userId;

    // 成员的权限类型
    @Column(nullable = false)
    private String likeUserId;



}
