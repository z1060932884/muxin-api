package com.zzj.muxin.factory;

import com.zzj.muxin.db.GroupMember;
import com.zzj.muxin.domain.TbGroupMember;
import com.zzj.muxin.vo.GroupMemberCard;

import java.util.List;
import java.util.Set;

/**
 * 推送工具
 */
public class PushFactory {

    /**
     * 推送添加群的通知
     * @param groupMembers 群成员
     */
    public static void pushGroupAdd(Set<TbGroupMember> groupMembers) {

    }

    /**
     * 通知新成员  您加入了xxx群
     * @param insertMembers 新增成员集合
     */
    public static void pushJoinGroup(Set<TbGroupMember> insertMembers) {
    }

    /**
     * 通知老成员   xxx，xxx加入了群
     * @param oldMember 老的成员
     * @param insertCards 新成员信息
     */
    public static void pushGroupMemberAdd(Set<TbGroupMember> oldMember, List<GroupMemberCard> insertCards) {
    }
}
