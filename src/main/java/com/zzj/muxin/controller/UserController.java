package com.zzj.muxin.controller;

import com.zzj.muxin.bo.UsersBo;
import com.zzj.muxin.domain.Users;
import com.zzj.muxin.service.UserService;
import com.zzj.muxin.utils.FastDFSClient;
import com.zzj.muxin.utils.FileUtils;
import com.zzj.muxin.utils.IMoocJSONResult;
import com.zzj.muxin.utils.MD5Utils;
import com.zzj.muxin.vo.UsersVO;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("u")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FastDFSClient fastDFSClient;

    @PostMapping("/registerOrLogin")
    public IMoocJSONResult registerOrLogin(@RequestBody Users users) throws Exception{

        if(Strings.isBlank(users.getUsername() )|| Strings.isBlank(users.getPassword())){

            return IMoocJSONResult.errorMsg("用户名或密码不能为空");
        }

        Users usersResult = null;
        //判断用户名是否存在，如果存在就登录，如果不存在则注册
        boolean usernameIsExist = userService.queryUsernameIsExist(users.getUsername());
        if(usernameIsExist){
            //登录
            usersResult = userService.queryUsername(users.getUsername(), MD5Utils.getMD5Str(users.getPassword()));
            if(usersResult == null){
                return IMoocJSONResult.errorMsg("用户名或密码不能为空");
            }

        }else {
            //注册

            users.setNickname(users.getUsername());
            users.setFaceImage("");
            users.setFaceImageBig("");
            users.setPassword(MD5Utils.getMD5Str(users.getPassword()));
            usersResult = userService.saveUser(users);

        }
        UsersVO usersVO = new UsersVO();
        BeanUtils.copyProperties(usersResult,usersVO);
        return IMoocJSONResult.ok(usersVO);
    }

    @PostMapping("/uploadFace")
    private IMoocJSONResult uploadFaceBase64(@RequestBody UsersBo usersBo) throws Exception{

        //获取前端传过来的base64字符串，然后转换成文件对象再上传
        String base64Image = usersBo.getFaceData();
        String userFacePath = "D:\\"+ usersBo.getUserId()+"userFace64.png";

        FileUtils.base64ToFile(userFacePath,base64Image);
        //上传文件到fastdfs
        MultipartFile file = FileUtils.fileToMultipart(userFacePath);

        String url = fastDFSClient.uploadBase64(file);
        System.out.println(url);

        //获取缩略图的url
        String thump = "_80*80.";
        String arr[]  = url.split("\\.");
        String thumpImageUrl = arr[0] + thump+arr[1];

        //更改用户头像
        Users users = new Users();
        users.setId(usersBo.getUserId());
        users.setFaceImageBig(url);
        users.setFaceImage(thumpImageUrl);

        return IMoocJSONResult.ok(userService.updateUserInfo(users));
    }
}
