package cn.TrueNine.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Mybatis工具类
 *
 * @author TrueNine
 * @version 1.0
 * @date 2020/6/19
 */
public class MybatisUtils {

    private static final SqlSession sqlSession;

    static {
        String resourcePath = "mybatis-config.xml";
        InputStream is = ClassLoader.getSystemResourceAsStream(resourcePath);
        System.out.println(is);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        // 使得自动提交事务
        sqlSession = build.openSession(true);
    }

    /**
     * 通过静态加载,加载 Mybatis
     *
     * @return 返回一个SqlSession 对象
     */
    public static SqlSession getSqlSession() {
        return sqlSession;
    }
}