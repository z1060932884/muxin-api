package com.zzj.muxin.serviceImp;

import com.zzj.muxin.domain.*;
import com.zzj.muxin.mapper.*;
import com.zzj.muxin.service.LvJiService;
import com.zzj.muxin.vo.LvjiPublishTopicCard;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public String addImage(String userId, String imageUrl) {
        return null;
    }


    @Transactional(propagation = Propagation.SUPPORTS)
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

    @Transactional(propagation = Propagation.SUPPORTS)
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

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<LvjiPublishTopic> getTopicList(String topicKind) {
        LvjiPublishTopicExample example = new LvjiPublishTopicExample();
        LvjiPublishTopicExample.Criteria criteria = example.createCriteria();
        criteria.andTopicKindEqualTo(topicKind);
        List<LvjiPublishTopic> topicList = topicMapper.selectByExample(example);

        return topicList;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public LvjiPublishTopic createTopic(LvjiPublishTopic topic) {
        topicMapper.insert(topic);
        return topic;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<LvjiTopicType> getTopicTypeList() {

        return topicTypeMapper.selectByExample(new LvjiTopicTypeExample());
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public LvjiTopicType queryTopicTypeByTypeId(String typeId) {
        LvjiTopicTypeExample example = new LvjiTopicTypeExample();
        LvjiTopicTypeExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(typeId);
        List<LvjiTopicType> lvjiTopicTypes = topicTypeMapper.selectByExample(example);
        if(lvjiTopicTypes!=null&&lvjiTopicTypes.size()>0){
            return lvjiTopicTypes.get(0);
        }
        return null;
    }


}
