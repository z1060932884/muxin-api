package com.zzj.muxin.mapper;

import com.zzj.muxin.domain.FriendsRequest;
import com.zzj.muxin.domain.FriendsRequestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FriendsRequestMapper {
    long countByExample(FriendsRequestExample example);

    int deleteByExample(FriendsRequestExample example);

    int insert(FriendsRequest record);

    int insertSelective(FriendsRequest record);

    List<FriendsRequest> selectByExample(FriendsRequestExample example);

    int updateByExampleSelective(@Param("record") FriendsRequest record, @Param("example") FriendsRequestExample example);

    int updateByExample(@Param("record") FriendsRequest record, @Param("example") FriendsRequestExample example);
}