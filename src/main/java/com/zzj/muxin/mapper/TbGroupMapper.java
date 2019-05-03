package com.zzj.muxin.mapper;

import com.zzj.muxin.domain.TbGroup;
import com.zzj.muxin.domain.TbGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbGroupMapper {
    long countByExample(TbGroupExample example);

    int deleteByExample(TbGroupExample example);

    int insert(TbGroup record);

    int insertSelective(TbGroup record);

    List<TbGroup> selectByExample(TbGroupExample example);

    int updateByExampleSelective(@Param("record") TbGroup record, @Param("example") TbGroupExample example);

    int updateByExample(@Param("record") TbGroup record, @Param("example") TbGroupExample example);
}