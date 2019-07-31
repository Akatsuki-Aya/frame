package cn.aya.test;


import cn.aya.dao.UserDao;
import cn.aya.domain.QueryVo;
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
import java.util.Date;
import java.util.List;

/**
 * Mybatis入门
 */
public class MybatisTest {
    private InputStream is;
    private SqlSession session;
    private UserDao userDao;

    @Before//用于测试方法执行之前执行
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        session = factory.openSession();
        userDao = session.getMapper(UserDao.class);
    }
    @After//用于测试方法执行之后执行
    public void destory() throws IOException {
        //提交事务
        session.commit();
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
    @Test
    public void testSave() throws IOException {
        User user = new User();
        user.setUsername("mybatis last insertid");
        user.setAddress("上海");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存操作之前: " + user);
        userDao.saveUser(user);
        System.out.println("保存操作之后: " + user);
    }
    @Test
    public void testUpdate() throws IOException {
        User user = new User();
        user.setId(49);
        user.setUsername("mybatis Saveuser");
        user.setAddress("上海");
        user.setSex("女");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }
    @Test
    public void testDel() throws IOException {
        User user = new User();
        user.setId(49);
        userDao.delUser(48);
    }

    @Test
    public void testfindOne() throws IOException {
        User user = userDao.findById(49);
        System.out.println(user);
    }

    /**
     * 模糊查询
     * @throws IOException
     */
    @Test
    public void testfindByName() throws IOException {
        List<User> users = userDao.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testfindTotal() throws IOException {
        int total = userDao.findTotal();
        System.out.println(total);
    }

    /**
     * 测试使用QueryVo作为查询条件
     * @throws IOException
     */
    @Test
    public void testfindByVo() throws IOException {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> users = userDao.findUserByVo(vo);
        for (User u : users) {
            System.out.println(u);
        }
    }

}
