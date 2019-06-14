package com.zzj.muxin.serviceImp;

import com.zzj.muxin.domain.LvjiPublishList;
import com.zzj.muxin.domain.LvjiPublishListExample;
import com.zzj.muxin.mapper.LvjiPublishListMapper;
import com.zzj.muxin.mapper.TbGroupMapper;
import com.zzj.muxin.mapper.ZzjImageManagerMapper;
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


    @Override
    public String addImage(String userId, String imageUrl) {
        return null;
    }

    @Override
    public LvjiPublishList publish(String userId, String imageUrlList, String content,String location) {
        String id = sid.nextShort();
        LvjiPublishList publishList = new LvjiPublishList();
        publishList.setId(id);
        publishList.setCreateAt(new Date());
        publishList.setUpdateAt(new Date());
        publishList.setUserId(userId);
        publishList.setPictureUrlList(imageUrlList);
        publishList.setPublishContent(content);
        publishList.setPublishLocation(location);
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

}
