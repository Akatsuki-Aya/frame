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

    @Before//用于测试方法执行之前执行
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
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
            System.out.println(user.getAccounts());

        }
    }
    @Test
    public void testFindAllRoles(){
        List<User> users = userDao.findAllRoles();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getRoles());

        }
    }


    @Test
    public void testfindOne() throws IOException {

    }




}
