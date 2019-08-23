package cn.aya.test;

import cn.aya.dao.AccountDao;
import cn.aya.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class testMybatis {
    /**
     * 测试查询
     * @throws IOException
     */
    @Test
    public void run1() throws IOException {
        // 加载Mybatis配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        // 查询所有数据
        List<Account> accounts = dao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
        // 关闭资源
        session.close();
        in.close();
    }

    /**
     * 测试保存
     *
     * @throws IOException
     */
    @Test
    public void run2() throws IOException {
        Account account = new Account();
        account.setName("王五");
        account.setMoney(400d);
        // 加载Mybatis配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //保存
        dao.saveAccount(account);
        // 提交事务
        session.commit();
        // 关闭资源
        session.close();
        in.close();
    }
}
