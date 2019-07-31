package cn.aya.dao;

import cn.aya.domain.QueryVo;
import cn.aya.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有操作
     * @return
     */
    @Select("select * from user")
    public List<User> findAll();

    User findById(Integer id);

    /**
     * 根据name模糊查询
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查询总用户数
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入的参数条件
     * @param user 查询条件: 有可能有用户名, 有可能有性别, 也有可能有性别, 还有可能是都有,
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据queryVO中提供的id集合, 查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
