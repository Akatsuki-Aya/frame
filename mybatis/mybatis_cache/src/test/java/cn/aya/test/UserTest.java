package cn.aya.test;


import cn.aya.dao.UserDao;
import cn.aya.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Mybatis入门
 */
public class UserTest {
    private InputStream is;
    private SqlSession session;
    private UserDao userDao;
    private SqlSessionFactory factory;

    @Before//用于测试方法执行之前执行
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(is);
        session = factory.openSession(true);
        userDao = session.getMapper(UserDao.class);
    }
    @After//用于测试方法执行之后执行
    public void destory() throws IOException {
        //提交事务
        //session.commit();
        session.close();
        is.close();
    }
    /**
     * 入门案例
     */
    @Test
    public void findAll() throws Exception {

        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试一级缓存
     */
    @Test
    public void testFirstLevelCache(){
        User user1 = userDao.findById(41);
        System.out.println(user1);
        //session.close();
        //session = factory.openSession(true);
        session.clearCache();//此方法也可以清空缓存
        //userDao = session.getMapper(UserDao.class);
        User user2 = userDao.findById(41);
        System.out.println(user2);
        System.out.println(user1==user2);
    }

    /**
     * 测试缓存的同步
     */
    @Test
    public void testClearCache(){
        User user1 = userDao.findById(41);
        System.out.println(user1);
        //2. 更新用户信息
        user1.setUsername("update user clear cache");
        user1.setAddress("上海");
        userDao.updateUser(user1);
        //3.再次查询id为41的用户
        User user2 = userDao.findById(41);
        System.out.println(user2);
        System.out.println(user1==user2);
    }





}
