package com.zzj.muxin.mapper;

import com.zzj.muxin.domain.LvjiTopicType;
import com.zzj.muxin.domain.LvjiTopicTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LvjiTopicTypeMapper {
    long countByExample(LvjiTopicTypeExample example);

    int deleteByExample(LvjiTopicTypeExample example);

    int insert(LvjiTopicType record);

    int insertSelective(LvjiTopicType record);

    List<LvjiTopicType> selectByExample(LvjiTopicTypeExample example);

    int updateByExampleSelective(@Param("record") LvjiTopicType record, @Param("example") LvjiTopicTypeExample example);

    int updateByExample(@Param("record") LvjiTopicType record, @Param("example") LvjiTopicTypeExample example);
}