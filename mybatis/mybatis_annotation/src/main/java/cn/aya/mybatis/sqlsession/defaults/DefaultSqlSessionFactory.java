package cn.aya.mybatis.sqlsession.defaults;

import cn.aya.mybatis.cfg.Configuration;
import cn.aya.mybatis.sqlsession.SqlSession;
import cn.aya.mybatis.sqlsession.SqlSessionFactory;

/**
 * sqlSessionFactory接口的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
