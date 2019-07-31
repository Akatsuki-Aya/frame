package cn.aya.dao;

import cn.aya.domain.User;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有操作
     * @return
     */
    public List<User> findAll();
}
