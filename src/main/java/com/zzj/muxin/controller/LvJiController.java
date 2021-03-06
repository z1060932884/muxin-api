package com.zzj.muxin.controller;

import com.zzj.muxin.bo.NearbyUserBo;
import com.zzj.muxin.domain.*;
import com.zzj.muxin.service.LvJiService;
import com.zzj.muxin.service.UserService;
import com.zzj.muxin.utils.FastDFSClient;
import com.zzj.muxin.utils.IMoocJSONResult;
import com.zzj.muxin.vo.LvjiPublishCard;
import com.zzj.muxin.vo.LvjiPublishTopicCard;
import com.zzj.muxin.vo.UsersVO;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("lvji")
public class LvJiController {

    @Autowired
    private UserService userService;

    @Autowired
    private FastDFSClient fastDFSClient;

    @Autowired
    private LvJiService lvJiService;
    @Autowired
    private Sid sid;

    /**
     * 发布动态
     * @param userId
     * @param imageUrlList
     * @param content
     * @return
     */
    @PostMapping("/publish")
    public IMoocJSONResult publish(String userId, String imageUrlList
            , String content,String location,String city,String topic){
        if(imageUrlList.isEmpty()&&content.isEmpty()){
            return IMoocJSONResult.errorMsg("内容不能为空");
        }
        if(userId.isEmpty()){
            return IMoocJSONResult.errorMsg("用户Id为空");
        }
        ChatUsers users = userService.queryUserInfoByUserId(userId);
        if(users == null){
            return IMoocJSONResult.errorMsg("用户信息错误");

        }
        LvjiPublishList publishList = lvJiService.publish(userId,imageUrlList,content, location,city,topic);
        if(publishList == null){
            return IMoocJSONResult.errorMsg("服务器错误");
        }
        return IMoocJSONResult.ok(publishList);
    }

    /**
     * 获取动态列表
     * @return
     */
    @GetMapping("/getPublishList")
    public IMoocJSONResult getPublishList(int page,int pagesize,String topicId,String userId){

        List<LvjiPublishList> publishLists = lvJiService.getPublishList(page,pagesize,topicId);

        List<LvjiPublishCard> finalPublishLists =  publishLists.stream().map(new Function<LvjiPublishList, LvjiPublishCard>() {
            @Override
            public LvjiPublishCard apply(LvjiPublishList lvjiPublishList) {
                ChatUsers users = userService.queryUserInfoByUserId(lvjiPublishList.getUserId());
                //查询评论列表
                List<LvjiComment> comments = lvJiService.queryCommentListByPublishId(lvjiPublishList.getId());
                //查询是否点赞
                LvjiLike like = lvJiService.queryLikeByUserId(userId,lvjiPublishList.getId());
                LvjiPublishCard publishCard = new LvjiPublishCard();
                BeanUtils.copyProperties(lvjiPublishList, publishCard);
                publishCard.setUserName(users.getNickname());
                publishCard.setFaceImage(users.getFaceImage());
                publishCard.setComments(comments);
                if(like!=null){
                    publishCard.setLike(true);
                }else {
                    publishCard.setLike(false);
                }
                return publishCard;
            }
        }).collect(Collectors.toList());


       return IMoocJSONResult.ok(finalPublishLists);

    }

    /**
     * 获取话题列表
     * @return
     */
    @GetMapping("/getTopicList")
    public IMoocJSONResult getTopicList(String topicKind){
        List<LvjiPublishTopic> topicList = lvJiService.getTopicList(topicKind);
        List<LvjiPublishTopicCard> topicCards = topicList.stream().map(new Function<LvjiPublishTopic, LvjiPublishTopicCard>() {
            @Override
            public LvjiPublishTopicCard apply(LvjiPublishTopic topic) {
                LvjiPublishTopicCard topicCard = new LvjiPublishTopicCard();
                BeanUtils.copyProperties(topic,topicCard);
                ChatUsers users = userService.queryUserInfoByUserId(topic.getUserId());
                topicCard.setUserName(users.getNickname());
                LvjiTopicType topicType = lvJiService.queryTopicTypeByTypeId(topic.getTypeId());
                topicCard.setType(topicType.getTypeTitle());
                return topicCard;
            }
        }).collect(Collectors.toList());
        return IMoocJSONResult.ok(topicCards);
    }


    /**
     * 创建话题
     * @return
     */
    @PostMapping("/createTopic")
    public IMoocJSONResult createTopic(@RequestBody LvjiPublishTopic topic){

        if(topic.getUserId() == null||topic.getUserId().equals("")){
            return IMoocJSONResult.errorMsg("用户信息错误");
        }
        topic.setId(sid.nextShort());
        topic.setCreateAt(new Date());
        topic.setUpdateAt(new Date());
        return IMoocJSONResult.ok(lvJiService.createTopic(topic));
    }

    /**
     * 获取话题类型列表
     * @return
     */
    @GetMapping("/getTopicTypeList")
    public IMoocJSONResult getTopicTypeList(){

        return IMoocJSONResult.ok(lvJiService.getTopicTypeList());
    }

    /**
     * 查询附近的人
     * @param userBo
     * @return
     */
    @PostMapping("/getNearbyPersonList")
    public IMoocJSONResult getNearbyPersonList(@RequestBody NearbyUserBo userBo){

        List<ChatUsers> usersList = lvJiService.queryNearbyPerson(userBo);


        return IMoocJSONResult.ok(usersList.stream().map(new Function<ChatUsers, UsersVO>() {
            @Override
            public UsersVO apply(ChatUsers chatUsers) {
                UsersVO usersVO = new UsersVO();
                BeanUtils.copyProperties(chatUsers,usersVO);
                return usersVO;
            }
        }).collect(Collectors.toList()));

    }

    /**
     * 查询人的信息
     * @param userId
     * @return
     */
    @GetMapping("/getUserInfo")
    public IMoocJSONResult getUserInfo(String userId){
        ChatUsers chatUsers = lvJiService.queryUserById(userId);
        if(chatUsers == null){
            return IMoocJSONResult.errorMsg("查询不到用户信息,用户信息为空");
        }
        UsersVO usersVO = new UsersVO();
        BeanUtils.copyProperties(chatUsers,usersVO);
        return IMoocJSONResult.ok(usersVO);
    }

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @PostMapping("/addComment")
    public IMoocJSONResult addComment(@RequestBody LvjiComment comment){
        if(StringUtils.isBlank(comment.getCommentUserId())
                ||StringUtils.isBlank(comment.getContent())
                ||StringUtils.isBlank(comment.getPublishId())){
            return IMoocJSONResult.errorMsg("评论信息有误");
        }
        comment.setId(sid.nextShort());
        comment.setCreateAt(new Date());
        comment.setUpdateAt(new Date());
        LvjiComment lvjiComment = lvJiService.addComment(comment);
        if(lvjiComment == null){
            return IMoocJSONResult.errorMsg("服务器错误");
        }
        LvjiPublishList lvjiPublishList = lvJiService.queryPublishById(comment.getPublishId());
        if(lvjiPublishList!=null){
            lvjiPublishList.setCommentNum(lvjiPublishList.getCommentNum()+1);
            lvJiService.updatePublish(lvjiPublishList);
        }
        return IMoocJSONResult.ok(lvjiComment);

    }
    /**
     * 点赞
     * @param lvjiLike
     * @return
     */
    @PostMapping("/addLike")
    public IMoocJSONResult addLike(@RequestBody LvjiLike lvjiLike){
        if(StringUtils.isBlank(lvjiLike.getPublishId())||StringUtils.isBlank(lvjiLike.getLikeUserId())){
            return IMoocJSONResult.errorMsg("参数错误");
        }
        lvjiLike.setId(sid.nextShort());
        lvjiLike.setCreateAt(new Date());
        lvjiLike.setUpdateAt(new Date());

        LvjiPublishList publish = lvJiService.queryPublishById(lvjiLike.getPublishId());
        if(publish!=null){
            LvjiLike like1 = lvJiService.queryLikeByUserId(lvjiLike.getLikeUserId(),lvjiLike.getPublishId());
            ChatUsers chatUsers = userService.queryUserInfoByUserId(lvjiLike.getLikeUserId());
            if(like1 == null){
                publish.setLikeNum(publish.getLikeNum()+1);
                lvJiService.updatePublish(publish);
                LvjiLike like = lvJiService.addLikePublish(lvjiLike);
                //个人获赞个数加 1
                if(like == null){
                    return IMoocJSONResult.errorMsg("服务器错误");
                }
                chatUsers.setBswLike(chatUsers.getBswLike()+1);
                userService.updateUserInfo(chatUsers);
                return IMoocJSONResult.build(0,"点赞成功",null);
            }else {
                publish.setLikeNum(publish.getLikeNum()-1);
                lvJiService.updatePublish(publish);
                lvJiService.deleteLikePublish(lvjiLike);
                chatUsers.setBswLike(chatUsers.getBswLike()-1);
                userService.updateUserInfo(chatUsers);
                return IMoocJSONResult.build(1,"取消点赞成功",null);
            }

        }
        return IMoocJSONResult.errorMsg("参数错误");

    }

    /**
     * 获取发布动态city
     * @param
     * @return
     */
    @GetMapping("/getPublishCityList")
    public IMoocJSONResult getPublishCityList(int pagesize,int page,String userId){
        List<LvjiPublishList> publishLists = lvJiService.queryPublishCityByUserId(pagesize,page,userId);
        List<LvjiPublishCard> finalPublishLists =  publishLists.stream().map(new Function<LvjiPublishList, LvjiPublishCard>() {
            @Override
            public LvjiPublishCard apply(LvjiPublishList lvjiPublishList) {
                ChatUsers users = userService.queryUserInfoByUserId(lvjiPublishList.getUserId());

                LvjiPublishCard publishCard = new LvjiPublishCard();
                BeanUtils.copyProperties(lvjiPublishList, publishCard);
                publishCard.setUserName(users.getNickname());
                publishCard.setFaceImage(users.getFaceImage());
                return publishCard;
            }
        }).collect(Collectors.toList());

        return IMoocJSONResult.ok(finalPublishLists);
    }

}
