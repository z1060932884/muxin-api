package com.zzj.muxin.jersey.service;

import com.zzj.muxin.db.User;
import com.zzj.muxin.jersey.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/hello")
public class Endpoint {

    @Autowired
    private UserRepository userRepository;

    @GET
    @Path("hello")
    public String message() {
        User user = new User();
        user.setName("zzj");
        user.setAge("22");
        userRepository.save(user);
        return "Hello 111111111奥术大师大回复大家说了空间大幅大家啊开发垃圾堆里看风景的手法来看即可多拉几个了大家索拉卡倒计时卡的减肥了空间大福利卡机的记录卡进来看撒娇地方看了多少积分李会计法拉多少积分开" +
                "阿伏伽德罗卡萨解放路口都是打开附近溜达佛塑科技" +
                "萨克了电视剧加快了就散了开关夸奖对方考虑将大力开发基拉肯德基法兰克福的" +
                "打卡机弗兰克的积分考虑到双方尽快了解啊阿卡丽飞机离开大是积分卡开的房间卡了多少积分看大神解放路口撒地方" +
                "机撒垃圾收费了肯定撒娇仿安静地方看了电视剧咖啡店家连锁店仿咖啡机肯定撒六块腹肌拉丝粉" ;
    }
}
