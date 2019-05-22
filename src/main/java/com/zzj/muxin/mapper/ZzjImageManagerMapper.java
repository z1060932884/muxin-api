package com.zzj.muxin.mapper;

import com.zzj.muxin.domain.ZzjImageManager;
import com.zzj.muxin.domain.ZzjImageManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzjImageManagerMapper {
    long countByExample(ZzjImageManagerExample example);

    int deleteByExample(ZzjImageManagerExample example);

    int insert(ZzjImageManager record);

    int insertSelective(ZzjImageManager record);

    List<ZzjImageManager> selectByExample(ZzjImageManagerExample example);

    int updateByExampleSelective(@Param("record") ZzjImageManager record, @Param("example") ZzjImageManagerExample example);

    int updateByExample(@Param("record") ZzjImageManager record, @Param("example") ZzjImageManagerExample example);
}