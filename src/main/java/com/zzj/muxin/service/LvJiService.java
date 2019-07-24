package com.zzj.muxin.service;

import com.zzj.muxin.bo.NearbyUserBo;
import com.zzj.muxin.domain.*;
import com.zzj.muxin.vo.LvjiPublishTopicCard;
import com.zzj.muxin.vo.UsersVO;

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
    List<LvjiPublishTopic> getTopicList(String topicKind);

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

    /**
     * 根据分类id查询话题分类
     * @param typeId
     * @return
     */
    LvjiTopicType queryTopicTypeByTypeId(String typeId);

    /**
     * 查询附近的人
     * @param userBo
     * @return
     */
    List<ChatUsers> queryNearbyPerson(NearbyUserBo userBo);

    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    ChatUsers queryUserById(String userId);


    /**
     * 添加评论
     * @param comment
     * @return
     */
    LvjiComment addComment(LvjiComment comment);
}

