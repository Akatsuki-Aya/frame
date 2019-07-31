package cn.aya.dao;

import cn.aya.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有账户，并且获取每个账户所属的用户信息
     * @return
     */
    @Select("select * from account")
    @Results(id = "accountMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(property = "user",column = "uid",one = @One(select = "cn.aya.dao.UserDao.findById"))
    })
    List<Account> findAll();

    /**
     * 查询用户，通过uid
     * @param uid
     * @return
     */
    @Select("select * from account where uid=#{uid}")
    List<Account> findByUid(Integer uid);
}
