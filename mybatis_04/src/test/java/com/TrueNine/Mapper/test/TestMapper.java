package com.TrueNine.Mapper.test;

import cn.TrueNine.mapper.UserMapper;
import cn.TrueNine.pojo.User;
import cn.TrueNine.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        }
    }

    private static final Logger logger = Logger.getLogger(TestMapper.class);

    /**
     * 测试使用 log4j
     */
    @Test
    public void test2() {
        logger.info("普通消息");
        logger.debug("调试");
        logger.error("错误");
        logger.warn("警告");
        logger.trace("测试跟踪信息");
    }

    /**
     * 测试分页查询
     * 测试通过
     */
    @Test
    public void test3() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Integer> map = new HashMap<>();
            map.put("startIndex", 0);
            map.put("pageSize", 2);
            List<User> userByLimit = mapper.getUserByLimit(map);
            for (User user : userByLimit) {
                logger.info(user);
            }
        }
    }
}