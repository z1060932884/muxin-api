package com.zzj.muxin.controller;

import com.zzj.muxin.domain.ChatUsers;
import com.zzj.muxin.domain.LvjiPublishList;
import com.zzj.muxin.domain.LvjiPublishTopic;
import com.zzj.muxin.domain.LvjiPublishTopicExample;
import com.zzj.muxin.service.LvJiService;
import com.zzj.muxin.service.UserService;
import com.zzj.muxin.utils.FastDFSClient;
import com.zzj.muxin.utils.IMoocJSONResult;
import com.zzj.muxin.vo.LvjiPublishCard;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
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
    public IMoocJSONResult getTopicList(){

        return IMoocJSONResult.ok(lvJiService.getTopicList());
    }


    /**
     * 创建话题
     * @return
     */
    @PostMapping("/createTopic")
    public IMoocJSONResult createTopic(@RequestBody LvjiPublishTopic topic){

        return IMoocJSONResult.ok(lvJiService.createTopic(topic));
    }

}
