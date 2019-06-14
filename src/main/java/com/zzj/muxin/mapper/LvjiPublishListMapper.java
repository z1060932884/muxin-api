package com.zzj.muxin.mapper;

import com.zzj.muxin.domain.LvjiPublishList;
import com.zzj.muxin.domain.LvjiPublishListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LvjiPublishListMapper {
    long countByExample(LvjiPublishListExample example);

    int deleteByExample(LvjiPublishListExample example);

    int insert(LvjiPublishList record);

    int insertSelective(LvjiPublishList record);

    List<LvjiPublishList> selectByExampleWithBLOBs(LvjiPublishListExample example);

    List<LvjiPublishList> selectByExample(LvjiPublishListExample example);

    int updateByExampleSelective(@Param("record") LvjiPublishList record, @Param("example") LvjiPublishListExample example);

    int updateByExampleWithBLOBs(@Param("record") LvjiPublishList record, @Param("example") LvjiPublishListExample example);

    int updateByExample(@Param("record") LvjiPublishList record, @Param("example") LvjiPublishListExample example);
}