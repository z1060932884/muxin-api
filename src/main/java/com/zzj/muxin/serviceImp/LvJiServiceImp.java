package com.zzj.muxin.serviceImp;

import com.zzj.muxin.domain.*;
import com.zzj.muxin.mapper.*;
import com.zzj.muxin.service.LvJiService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LvJiServiceImp implements LvJiService {

    @Autowired
    private Sid sid;

    @Autowired
    private ZzjImageManagerMapper imageManagerMapper;

    @Autowired
    private LvjiPublishListMapper lvjiPublishListMapper;
    @Autowired
    private LvjiPublishTopicMapper topicMapper;
    @Autowired
    private LvjiTopicTypeMapper topicTypeMapper;


    @Override
    public String addImage(String userId, String imageUrl) {
        return null;
    }

    @Override
    public LvjiPublishList publish(String userId, String imageUrlList, String content,String location,String city,String topic) {
        String id = sid.nextShort();
        LvjiPublishList publishList = new LvjiPublishList();
        publishList.setId(id);
        publishList.setCreateAt(new Date());
        publishList.setUpdateAt(new Date());
        publishList.setUserId(userId);
        publishList.setPictureUrlList(imageUrlList);
        publishList.setPublishContent(content);
        publishList.setPublishLocation(location);
        publishList.setPublishCity(city);
        publishList.setPublishTopic(topic);
        lvjiPublishListMapper.insert(publishList);

        return publishList;
    }

    @Override
    public List<LvjiPublishList> getPublishList(int page,int pagesize) {
        LvjiPublishListExample example = new LvjiPublishListExample();
        //按时间倒叙  desc   正序ASC
        example.setOrderByClause("create_at desc");
        example.setPageSize(pagesize);
        example.setStartRow(page);
        List<LvjiPublishList> lvjiPublishLists = lvjiPublishListMapper.selectByExampleWithBLOBs(example);
        return lvjiPublishLists;
    }

    @Override
    public List<LvjiPublishTopic> getTopicList() {

        return topicMapper.selectByExample(new LvjiPublishTopicExample());
    }

    @Override
    public LvjiPublishTopic createTopic(LvjiPublishTopic topic) {
        topicMapper.insert(topic);
        return topic;
    }

    @Override
    public List<LvjiTopicType> getTopicTypeList() {

        return topicTypeMapper.selectByExample(new LvjiTopicTypeExample());
    }


}
