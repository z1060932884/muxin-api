package com.zzj.muxin.service;

import com.zzj.muxin.domain.LvjiPublishList;

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
    LvjiPublishList publish(String userId,String imageUrlList,String content,String location);

    /**
     * 获取动态列表
     * @return
     */
    List<LvjiPublishList> getPublishList(int page,int pagesize);

}
