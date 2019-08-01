package com.zzj.muxin.serviceImp;

import com.zzj.muxin.bo.NearbyUserBo;
import com.zzj.muxin.domain.*;
import com.zzj.muxin.mapper.*;
import com.zzj.muxin.service.LvJiService;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
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
    @Autowired
    private ChatUsersMapper usersMapper;
    @Autowired
    private LvjiCommentMapper commentMapper;
    @Autowired
    private LvjiLikeMapper likeMapper;


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public String addImage(String userId,String publishId, String imageUrl) {
        ZzjImageManager manager = new ZzjImageManager();
        try {
            manager.setId(sid.nextShort());
            manager.setCreateAt(new Date());
            manager.setUpdateAt(new Date());
            manager.setPicture(imageUrl);
            manager.setUserId(userId);
            manager.setPushId(publishId);
            imageManagerMapper.insert(manager);
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
        return manager.getId();
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
        publishList.setLikeNum(0);
        publishList.setCommentNum(0);
        lvjiPublishListMapper.insert(publishList);
        //处理图片上传
        if(StringUtils.isNotBlank(imageUrlList)){
            String subUrlList = imageUrlList.substring(1,imageUrlList.length()-1);
            ArrayList<String> arrayList = new ArrayList<>();
            //处理图片
            if(subUrlList.contains(",")){
                String[] splitUrlList =  subUrlList.split(",");
                arrayList.addAll(Arrays.asList(splitUrlList));
            }else {
                arrayList.add(subUrlList);
            }
            for(String imageUrl : arrayList){
               addImage(userId,publishList.getId(),imageUrl);
            }
        }
        return publishList;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<LvjiPublishList> getPublishList(int page,int pagesize,String topicTitle) {
        LvjiPublishListExample example = new LvjiPublishListExample();
        //按时间倒叙  desc   正序ASC
        example.setOrderByClause("create_at desc");
        example.setPageSize(pagesize);
        example.setStartRow(page);
        if(StringUtils.isNotBlank(topicTitle)){
           LvjiPublishListExample.Criteria criteria =  example.createCriteria();
           criteria.andPublishTopicEqualTo(topicTitle);
        }
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

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ChatUsers> queryNearbyPerson(NearbyUserBo userBo) {
        ChatUsersExample usersExample = new ChatUsersExample();
        ChatUsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andBswCityEqualTo(userBo.getAddress());
        criteria.andIdNotEqualTo(userBo.getUserId());
        return usersMapper.selectByExample(usersExample);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ChatUsers queryUserById(String userId){
        ChatUsersExample usersExample = new ChatUsersExample();
        ChatUsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andIdEqualTo(userId);
        List<ChatUsers> chatUsers = usersMapper.selectByExample(usersExample);
        if(chatUsers!=null&&chatUsers.size()!=0){
            return chatUsers.get(0);
        }
        return null;
    }

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public LvjiComment addComment(LvjiComment comment) {

        try {
            commentMapper.insert(comment);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return comment;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<LvjiComment> queryCommentListByPublishId(String publishId) {
        LvjiCommentExample example = new LvjiCommentExample();
        LvjiCommentExample.Criteria criteria =  example.createCriteria();
        criteria.andPublishIdEqualTo(publishId);
        return commentMapper.selectByExample(example);
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public LvjiPublishList queryPublishById(String publishId) {
        LvjiPublishListExample example = new LvjiPublishListExample();
        LvjiPublishListExample.Criteria criteria =  example.createCriteria();
        criteria.andIdEqualTo(publishId);
        List<LvjiPublishList> publishLists = lvjiPublishListMapper.selectByExampleWithBLOBs(example);
        if(publishLists !=null && publishLists.size()!=0 ){
            return publishLists.get(0);
        }
        return null;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void updatePublish(LvjiPublishList lvjiPublishList) {
        LvjiPublishListExample example = new LvjiPublishListExample();
        LvjiPublishListExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(lvjiPublishList.getId());
        lvjiPublishListMapper.updateByExample(lvjiPublishList,example);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public LvjiLike addLikePublish(LvjiLike lvjiLike) {
        try {
            likeMapper.insert(lvjiLike);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return lvjiLike;
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void deleteLikePublish(LvjiLike lvjiLike) {
        LvjiLikeExample example = new LvjiLikeExample();
        LvjiLikeExample.Criteria criteria = example.createCriteria();
        criteria.andLikeUserIdEqualTo(lvjiLike.getLikeUserId());
        criteria.andPublishIdEqualTo(lvjiLike.getPublishId());
        likeMapper.deleteByExample(example);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public LvjiLike queryLikeByUserId(String userId, String publishId) {
        LvjiLikeExample example = new LvjiLikeExample();
        LvjiLikeExample.Criteria criteria = example.createCriteria();
        criteria.andLikeUserIdEqualTo(userId);
        criteria.andPublishIdEqualTo(publishId);
        List<LvjiLike> lvjiLikes = likeMapper.selectByExample(example);

        if(lvjiLikes!=null&&lvjiLikes.size()!=0){
            return  lvjiLikes.get(0);
        }
        return null;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<LvjiPublishList> queryPublishCityByUserId(int pagesize,int page,String userId) {
        LvjiPublishListExample example = new LvjiPublishListExample();
        LvjiPublishListExample.Criteria criteria =  example.createCriteria();
        //按时间倒叙  desc   正序ASC
        example.setOrderByClause("create_at desc");
        example.setPageSize(pagesize);
        example.setStartRow(page);
        example.setDistinct(true);
        criteria.andUserIdEqualTo(userId);
        criteria.andPublishCityIsNotNull();

        return lvjiPublishListMapper.selectByExampleWithBLOBs(example);
    }


}
