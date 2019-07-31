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
import java.util.Date;
import java.util.List;

public class AnnotationCRUDTest {
    private SqlSession session;
    private SqlSessionFactory factory;
    private UserDao userDao;
    private InputStream in;
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession(true);
        userDao = session.getMapper(UserDao.class);
    }

    @After
    public void destory() throws IOException {
        session.close();
        in.close();
    }

    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println("---------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }
    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("mybatis annotation");
        user.setAddress("上海");
        userDao.addUser(user);
    }
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(54);
        user.setUsername("mybatis annotation update");
        user.setAddress("上海浦东区");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.updateUser(user);
    }
    @Test
    public void testDeleteUser() {
        userDao.deleteUser(50);
    }
    @Test
    public void testFindOne() {
        User user = userDao.findById(54);
        System.out.println(user);
        User user2 = userDao.findById(54);
        System.out.println(user);

        System.out.println(user == user2);

    }

    @Test
    public void testFindByName() {
        List<User> user = userDao.findUserByName("%王%");
        for (User u : user) {
            System.out.println(u);
        }

    }
    @Test
    public void testFindTotal() {
        int total = userDao.findTotal();
        System.out.println(total);

    }
}
