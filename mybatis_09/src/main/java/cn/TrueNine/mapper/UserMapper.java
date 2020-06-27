package cn.TrueNine.mapper;

import cn.TrueNine.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表映射实现接口
 *
 * @author TrueNine
 * @version 1.0
 * @date 2020/6/26
 */
public interface UserMapper {

    /**
     * 查询所有用户,根据 id
     *
     * @param id 用户 id
     * @return 用户列表
     */
    List<User> queryUserById(@Param("id") Integer id);
}
