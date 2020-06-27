package com.TrueNine.Mapper.test;

import cn.TrueNine.mapper.UserMapper;
import cn.TrueNine.pojo.User;
import cn.TrueNine.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

/**
 * 用于测试 Mybatis 的环境搭建状况
 *
 * @author TrueNine
 * @version 1.0
 * @date 2020/6/19
 */
public class TestMapper {

    private static final Logger logger = Logger.getLogger(TestMapper.class);

    /**
     * 测试使用注解的Mapper
     */
    @Test
    public void test() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();
            for (User user : userList) {
                logger.info(user);
            }
        }
    }

    /**
     * 测试注解多参数查询
     */
    @Test
    public void test2() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User userById = mapper.getUserById(1, "老八");
            logger.info(userById);
        }
    }
}