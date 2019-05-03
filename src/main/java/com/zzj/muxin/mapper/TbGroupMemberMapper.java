package com.zzj.muxin.mapper;

import com.zzj.muxin.domain.TbGroupMember;
import com.zzj.muxin.domain.TbGroupMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbGroupMemberMapper {
    long countByExample(TbGroupMemberExample example);

    int deleteByExample(TbGroupMemberExample example);

    int insert(TbGroupMember record);

    int insertSelective(TbGroupMember record);

    List<TbGroupMember> selectByExample(TbGroupMemberExample example);

    int updateByExampleSelective(@Param("record") TbGroupMember record, @Param("example") TbGroupMemberExample example);

    int updateByExample(@Param("record") TbGroupMember record, @Param("example") TbGroupMemberExample example);
}