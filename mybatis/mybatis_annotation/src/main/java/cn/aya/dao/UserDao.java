package cn.aya.dao;

import cn.aya.domain.User;
import cn.aya.mybatis.annotation.Select;


import java.util.List;

public interface UserDao {
    /**
     * 查询所有操作
     * @return
     */
    @Select("select * from user")
    public List<User> findAll();
}
