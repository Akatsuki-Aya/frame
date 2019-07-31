package cn.aya.test;


import cn.aya.dao.RoleDao;
import cn.aya.dao.UserDao;
import cn.aya.domain.Role;
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
public class RoleTest {
    private InputStream is;
    private SqlSession session;
    private RoleDao roleDao;

    @Before//用于测试方法执行之前执行
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        session = factory.openSession(true);
        roleDao = session.getMapper(RoleDao.class);
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

        List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }



    @Test
    public void testfindOne() throws IOException {

    }




}
