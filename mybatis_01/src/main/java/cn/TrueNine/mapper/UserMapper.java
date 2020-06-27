package cn.TrueNine.mapper;

import cn.TrueNine.pojo.User;

import java.util.List;

/**
 * 用户类映射接口 (Mapper)
 *
 * @author TrueNine
 * @version 1.0
 * @date 2020/6/19
 */
public interface UserMapper {

    /**
     * 返回整个用户表
     *
     * @return 列表 (List)
     */
    List<User> getUserList();

    /**
     * 根据用户 id 返回对应的映射对象
     *
     * @param id 用户 id
     * @return 映射独享类型
     */
    User getUserOneLine(Integer id);

    /**
     * 根据映射对象增加相应数据
     *
     * @param user 映射对象
     * @return 修改行数
     */
    int addUser(User user);

    /**
     * 根据映射对象更新用户数据
     *
     * @param user 映射对象
     * @return 修改行数
     */
    int updateUser(User user);

    /**
     * 根据映射对象删除对应数据
     *
     * @param user 映射独享
     * @return 修改行数
     */
    int deleteUser(User user);
}
