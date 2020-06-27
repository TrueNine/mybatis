package cn.TrueNine.mapper;

import cn.TrueNine.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * 用户类映射接口 (Mapper)
 *
 * @author TrueNine
 * @version 1.0
 * @date 2020/6/19
 */
public interface UserMapper {
    /**
     * 根据用户 id 返回对应的映射对象
     *
     * @param id 用户 id
     * @return 映射独享类型
     */
    User getUserOneLine(Integer id);

    /**
     * 使用 Mybatis 进行分页
     *
     * @param map 用于传递参数的 map
     * @return 用户列表
     */
    List<User> getUserByLimit(Map<String, Integer> map);
}