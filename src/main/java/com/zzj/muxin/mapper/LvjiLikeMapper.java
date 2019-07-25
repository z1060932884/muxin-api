package com.zzj.muxin.mapper;

import com.zzj.muxin.domain.LvjiLike;
import com.zzj.muxin.domain.LvjiLikeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LvjiLikeMapper {
    long countByExample(LvjiLikeExample example);

    int deleteByExample(LvjiLikeExample example);

    int insert(LvjiLike record);

    int insertSelective(LvjiLike record);

    List<LvjiLike> selectByExample(LvjiLikeExample example);

    int updateByExampleSelective(@Param("record") LvjiLike record, @Param("example") LvjiLikeExample example);

    int updateByExample(@Param("record") LvjiLike record, @Param("example") LvjiLikeExample example);
}