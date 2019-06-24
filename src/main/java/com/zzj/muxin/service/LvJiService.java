package com.zzj.muxin.service;

import com.zzj.muxin.domain.LvjiPublishList;
import com.zzj.muxin.domain.LvjiPublishTopic;
import com.zzj.muxin.domain.LvjiTopicType;

import java.util.List;

public interface LvJiService {

    /**
     * 插入图片
     * @param userId 用户id
     * @param imageUrl 图片地址
     * @return 图片id
     */
    String addImage(String userId,String imageUrl);

    /**
     * 发布动态
     * @param userId
     * @param imageUrlList
     * @param content
     * @return
     */
    LvjiPublishList publish(String userId,String imageUrlList,String content,String location,String city,String topic);

    /**
     * 获取动态列表
     * @return
     */
    List<LvjiPublishList> getPublishList(int page,int pagesize);
    /**
     * 获取话题列表
     * @return
     */
    List<LvjiPublishTopic> getTopicList();

    /**
     * 创建话题
     * @param topic
     * @return
     */
    LvjiPublishTopic createTopic(LvjiPublishTopic topic);


    /**
     * 获取话题类型数据
     */
    List<LvjiTopicType> getTopicTypeList();

}
