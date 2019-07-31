package cn.aya.dao;

import cn.aya.domain.User;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有用户, 同时获取到用户下所有账号的信息
     * @return
     */
    //@Select("select * from user")
    List<User> findAll();

    User findById(Integer id);

    void updateUser(User user);


}
