package com.TrueNine.Mapper.test;

import cn.TrueNine.mapper.UserMapper;
import cn.TrueNine.pojo.User;
import cn.TrueNine.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
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

    /**
     * 测试环境的搭建状况
     * 测试通过
     */
    @Test
    public void test() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();
            for (User user : userList) {
                System.out.println("user = " + user);
            }
        }
    }

    /**
     * 测试根据 id 查询用户
     * 测试通过
     */
    @Test
    public void test2() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User userOneLine = mapper.getUserOneLine(1);
            System.out.println(userOneLine);
        }
    }

    /**
     * 测试增加一个用户到表
     * 测试通过
     */
    @Test
    public void test3() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int addUser = mapper.addUser(User.builder().id(10).name("老十").pwd("1234").build());
            sqlSession.commit();
            System.out.println(addUser);

            List<User> userList = mapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        }
    }

    /**
     * 测试更改用户数据
     * 测试通过
     */
    @Test
    public void test4() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int i = mapper.updateUser(User.builder().id(9).name("老九").pwd("12345").build());
            sqlSession.commit();
            System.out.println(i);

            List<User> userList = mapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        }
    }

    /**
     * 测试删除用户数据
     * 测试通过
     */
    @Test
    public void test5() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int i = mapper.deleteUser(User.builder().id(8).name("老八").pwd("1234").build());
            sqlSession.commit();
            System.out.println(i);

            List<User> userList = mapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        }
    }
}