package com.zzj.muxin.serviceImp;

import com.zzj.muxin.bo.GroupCreateModel;
import com.zzj.muxin.db.Group;
import com.zzj.muxin.db.GroupMember;
import com.zzj.muxin.domain.ChatUsers;
import com.zzj.muxin.service.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class GroupServiceImp implements GroupService {



    @Override
    public Group findByName(String groupName) {
        return null;
    }

    @Override
    public Group create(ChatUsers user, GroupCreateModel createModel, List<ChatUsers> chatUsers) {
        return null;
    }

    @Override
    public GroupMember getMember(String userId, String groupId) {
        return null;
    }

    @Override
    public Set<GroupMember> getMembers(Group group) {
        return null;
    }
}
