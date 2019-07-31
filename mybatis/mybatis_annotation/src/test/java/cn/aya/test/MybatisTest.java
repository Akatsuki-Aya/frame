package cn.aya.test;


import cn.aya.dao.UserDao;
import cn.aya.domain.User;
import cn.aya.mybatis.io.Resources;
import cn.aya.mybatis.sqlsession.SqlSession;
import cn.aya.mybatis.sqlsession.SqlSessionFactory;
import cn.aya.mybatis.sqlsession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * Mybatis入门
 */
public class MybatisTest {
    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args) throws Exception {
//        //1. 读取配置文件
//        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
//        //2. 创建SqlSessionFactory工厂
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory factory = builder.build(is);
//        //3. 使用工厂生产SqlSession对象
//        SqlSession session = factory.openSession();
//        //4. SqlSession创建dao接口的代理对象
//        UserDao userDao = session.getMapper(UserDao.class);
//        //5. 使用代理对象执行方法
//        List<User> users = userDao.findAll();
//        for (User user : users) {
//            System.out.println(user);
//        }
//        //6. 释放资源
//        session.close();
//        is.close();


        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession session = factory.openSession();
        UserDao userDao = session.getMapper(UserDao.class);
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
        is.close();
    }
}
