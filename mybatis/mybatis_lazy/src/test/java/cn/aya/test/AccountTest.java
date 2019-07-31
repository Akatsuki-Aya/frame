package cn.aya.test;


import cn.aya.dao.AccountDao;
import cn.aya.domain.Account;
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
public class AccountTest {
    private InputStream is;
    private SqlSession session;
    private AccountDao accountDao;

    @Before//用于测试方法执行之前执行
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        session = factory.openSession(true);
        accountDao = session.getMapper(AccountDao.class);
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

        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

}
