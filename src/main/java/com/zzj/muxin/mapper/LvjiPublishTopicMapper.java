package com.zzj.muxin.mapper;

import com.zzj.muxin.domain.LvjiPublishTopic;
import com.zzj.muxin.domain.LvjiPublishTopicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LvjiPublishTopicMapper {
    long countByExample(LvjiPublishTopicExample example);

    int deleteByExample(LvjiPublishTopicExample example);

    int insert(LvjiPublishTopic record);

    int insertSelective(LvjiPublishTopic record);

    List<LvjiPublishTopic> selectByExample(LvjiPublishTopicExample example);

    int updateByExampleSelective(@Param("record") LvjiPublishTopic record, @Param("example") LvjiPublishTopicExample example);

    int updateByExample(@Param("record") LvjiPublishTopic record, @Param("example") LvjiPublishTopicExample example);
}