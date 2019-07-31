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
public class SecondLevelCacheTest {
    private InputStream is;
    private SqlSessionFactory factory;

    @Before//用于测试方法执行之前执行
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(is);

    }
    @After//用于测试方法执行之后执行
    public void destory() throws IOException {
        is.close();
    }
    /**
     * 入门案例
     */
    @Test
    public void findAll() throws Exception {
        SqlSession sqlSession1 = factory.openSession(true);
        UserDao userDao = sqlSession1.getMapper(UserDao.class);
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
        SqlSession sqlSession1 = factory.openSession(true);
        UserDao dao1 = sqlSession1.getMapper(UserDao.class);
        User user1 = dao1.findById(41);
        System.out.println(user1);
        sqlSession1.close();//一级缓存消失

        SqlSession sqlSession2 = factory.openSession(true);
        UserDao dao2 = sqlSession2.getMapper(UserDao.class);
        User user2 = dao2.findById(41);
        System.out.println(user2);
        sqlSession2.close();
        System.out.println(user1==user2);
    }







}
