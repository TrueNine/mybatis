package cn.TrueNine.mapper;

import cn.TrueNine.pojo.User;
import cn.TrueNine.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

/**
 * @author TrueNine
 * @version 1.0
 * @date 2020/6/24
 */
public class TestMapper {

    private static final Logger logger = Logger.getLogger(TestMapper.class);

    /**
     * 测试查询所有用户,根据id,测试缓存
     */
    @Test
    public void test() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.queryUserById(1);

            for (User user : users) {
                logger.info(user);
            }
            // 两次同时查询一个用户
            List<User> users1 = mapper.queryUserById(1);
            logger.error("第二次查询,查询同样用户");
            for (User user : users1) {
                logger.warn(user);
            }
        }
    }
}
