package cn.aya.dao.Impl;

import cn.aya.dao.UserDao;
import cn.aya.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        //1. 根据factory获取SQLSession对象
        SqlSession session = factory.openSession();
        //2. 调用SQLSession中的方法, 实现查询列表
        List<User> users = session.selectList("cn.aya.dao.UserDao.findAll");//参数就是能获取到配置信息的key
        session.close();
        return users;
    }

    public void saveUser(User user) {
        SqlSession session = factory.openSession();
        int insert = session.insert("cn.aya.dao.UserDao.saveUser",user);
        session.commit();
        session.close();
    }

    public void updateUser(User user) {
        SqlSession session = factory.openSession();
        session.update("cn.aya.dao.UserDao.updateUser",user);
        session.commit();
        session.close();
    }

    public void delUser(Integer id) {
        SqlSession session = factory.openSession();
        session.update("cn.aya.dao.UserDao.delUser",id);
        session.commit();
        session.close();
    }

    public User findById(Integer id) {
        SqlSession session = factory.openSession();
        User user = session.selectOne("cn.aya.dao.UserDao.findById", id);
        session.close();
        return user;
    }

    public List<User> findByName(String username) {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("cn.aya.dao.UserDao.findByName", username);
        session.close();
        return users;
    }

    public int findTotal() {
        SqlSession session = factory.openSession();
        int i = session.selectOne("cn.aya.dao.UserDao.findTotal");
        session.close();
        return i;
    }
}
