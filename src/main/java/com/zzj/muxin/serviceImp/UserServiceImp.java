package com.zzj.muxin.serviceImp;

import com.zzj.muxin.domain.Users;
import com.zzj.muxin.domain.UsersExample;
import com.zzj.muxin.mapper.UsersMapper;
import com.zzj.muxin.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImp implements UserService {

    /**
     * 使用编译的mapper自动注入
     */
    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private Sid sid;
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {

        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Users> users = usersMapper.selectByExample(example);

        if(users.size()>0){
            System.out.println(users.size());
            return true;
        }

        return false;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users queryUsername(String username, String password) {
        Users users = null;
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        List<Users> usersList = usersMapper.selectByExample(example);
        if(usersList.size()>0){
            users = usersList.get(0);
        }
        return users;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users saveUser(Users users) {

        // TODO: 2018/11/2 为用户生成一个二维码
        users.setQrcode("");

        users.setId(sid.nextShort());

        usersMapper.insert(users);

        return users;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users updateUserInfo(Users users) {
        usersMapper.updateByPrimaryKeySelective(users);
        return queryUserById(users.getId());
    }


    private Users queryUserById(String userId){

        return usersMapper.selectByPrimaryKey(userId);
    }

}
