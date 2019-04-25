package com.zzj.muxin.mapper;

import com.zzj.muxin.domain.ChatUsers;
import com.zzj.muxin.domain.ChatUsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChatUsersMapper {
    long countByExample(ChatUsersExample example);

    int deleteByExample(ChatUsersExample example);

    int insert(ChatUsers record);

    int insertSelective(ChatUsers record);

    List<ChatUsers> selectByExample(ChatUsersExample example);

    int updateByExampleSelective(@Param("record") ChatUsers record, @Param("example") ChatUsersExample example);

    int updateByExample(@Param("record") ChatUsers record, @Param("example") ChatUsersExample example);
}