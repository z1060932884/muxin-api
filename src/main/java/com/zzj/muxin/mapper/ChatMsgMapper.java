package com.zzj.muxin.mapper;

import com.zzj.muxin.domain.ChatMsg;
import com.zzj.muxin.domain.ChatMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChatMsgMapper {
    long countByExample(ChatMsgExample example);

    int deleteByExample(ChatMsgExample example);

    int insert(ChatMsg record);

    int insertSelective(ChatMsg record);

    List<ChatMsg> selectByExampleWithBLOBs(ChatMsgExample example);

    List<ChatMsg> selectByExample(ChatMsgExample example);

    int updateByExampleSelective(@Param("record") ChatMsg record, @Param("example") ChatMsgExample example);

    int updateByExampleWithBLOBs(@Param("record") ChatMsg record, @Param("example") ChatMsgExample example);

    int updateByExample(@Param("record") ChatMsg record, @Param("example") ChatMsgExample example);
}