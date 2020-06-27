package cn.TrueNine.mapper;

import cn.TrueNine.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 测试使用注解开发
 *
 * @author TrueNine
 * @version 1.0
 * @date 2020/6/19
 */
public interface UserMapper {
    @Select("select * from mybatis.`user`;")
    List<User> getUserList();

    /**
     * 方法存在多个参数,必须加上 @Param 参数名
     *
     * @param id   id
     * @param name name
     * @return 映射对象
     */
    @Select("select * from mybatis.`user` where id = #{id} and name = #{name};")
    User getUserById(@Param("id") Integer id, @Param("name") String name);
}