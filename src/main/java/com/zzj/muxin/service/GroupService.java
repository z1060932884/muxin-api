package com.zzj.muxin.service;


import com.zzj.muxin.bo.GroupCreateModel;
import com.zzj.muxin.db.Group;
import com.zzj.muxin.db.GroupMember;
import com.zzj.muxin.domain.ChatUsers;

import java.util.List;
import java.util.Set;

public interface GroupService {

    /**
     * 查找群
     * @param groupName
     * @return
     */
    public Group findByName(String groupName);

    Group create(ChatUsers user, GroupCreateModel createModel, List<ChatUsers> chatUsers);

    GroupMember getMember(String userId, String groupId);

    Set<GroupMember> getMembers(Group group);
}
