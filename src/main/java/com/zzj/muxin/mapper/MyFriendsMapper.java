package com.zzj.muxin.mapper;

import com.zzj.muxin.domain.MyFriends;
import com.zzj.muxin.domain.MyFriendsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyFriendsMapper {
    long countByExample(MyFriendsExample example);

    int deleteByExample(MyFriendsExample example);

    int insert(MyFriends record);

    int insertSelective(MyFriends record);

    List<MyFriends> selectByExample(MyFriendsExample example);

    int updateByExampleSelective(@Param("record") MyFriends record, @Param("example") MyFriendsExample example);

    int updateByExample(@Param("record") MyFriends record, @Param("example") MyFriendsExample example);
}