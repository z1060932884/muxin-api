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
    public IMoocJSONResult getPublishList(int page,int pagesize){

        List<LvjiPublishList> publishLists = lvJiService.getPublishList(page,pagesize);

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
        return IMoocJSONResult.ok(lvjiComment);

    }

}
