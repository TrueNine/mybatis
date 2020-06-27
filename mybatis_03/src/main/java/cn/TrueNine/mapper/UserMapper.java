package cn.TrueNine.mapper;

import cn.TrueNine.pojo.User;

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
}