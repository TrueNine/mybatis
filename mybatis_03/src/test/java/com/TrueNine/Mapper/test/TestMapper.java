package com.TrueNine.Mapper.test;

import cn.TrueNine.mapper.UserMapper;
import cn.TrueNine.pojo.User;
import cn.TrueNine.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 用于测试 Mybatis 的环境搭建状况
 *
 * @author TrueNine
 * @version 1.0
 * @date 2020/6/19
 */
public class TestMapper {

    /**
     * 测试使用别名查询
     */
    @Test
    public void test1() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User userOneLine = mapper.getUserOneLine(1);
            System.out.println(userOneLine);
        }
    }
}