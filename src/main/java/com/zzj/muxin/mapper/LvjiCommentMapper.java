package com.zzj.muxin.mapper;

import com.zzj.muxin.domain.LvjiComment;
import com.zzj.muxin.domain.LvjiCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LvjiCommentMapper {
    long countByExample(LvjiCommentExample example);

    int deleteByExample(LvjiCommentExample example);

    int insert(LvjiComment record);

    int insertSelective(LvjiComment record);

    List<LvjiComment> selectByExample(LvjiCommentExample example);

    int updateByExampleSelective(@Param("record") LvjiComment record, @Param("example") LvjiCommentExample example);

    int updateByExample(@Param("record") LvjiComment record, @Param("example") LvjiCommentExample example);
}