package cn.TrueNine.mapper;

import cn.TrueNine.pojo.Blog;
import cn.TrueNine.utils.IDUtils;
import cn.TrueNine.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.*;

/**
 * @author TrueNine
 * @version 1.0
 * @date 2020/6/24
 */
public class TestMapper {

    private static final Logger logger = Logger.getLogger(TestMapper.class);

    /**
     * 测试环境搭建
     * 测试通过
     */
    @Test
    public void test() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            List<Blog> allBlog = mapper.getAllBlog();
            for (Blog blog : allBlog) {
                logger.info(blog);
            }
        }
    }

    /**
     * 测试向表内添加数据
     * 测试通过
     */
    @Test
    public void test2() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

            int trueNine = mapper.addBlog(Blog.builder()
                    .id(IDUtils.getUUID())
                    .title("不知道该写些什么")
                    .author("yzdz")
                    .createTime(new Date(System.currentTimeMillis()))
                    .views(7000).build());
            logger.info(trueNine);

            List<Blog> allBlog = mapper.getAllBlog();
            for (Blog blog : allBlog) {
                logger.info(blog);
            }
        }
    }

    /**
     * 测试if
     * 测试通过
     */
    @Test
    public void test3() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

            Map<String, Object> argsMap = new HashMap<>();
            // 尝试添加参数
            argsMap.put("title", "不知道该写些什么");
            argsMap.put("author", "yzdz");

            List<Blog> blogs = mapper.queryBlogIf(argsMap);
            for (Blog blog : blogs) {
                logger.info(blog);
            }
        }
    }

    /**
     * 测试 choose
     * 测试通过
     */
    @Test
    public void test4() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

            Map<String, Object> argsMap = new HashMap<>();
            // 尝试添加参数
            argsMap.put("title", "不知道该写些什么");
            argsMap.put("author", "yzdz");
            argsMap.put("views", 7000);

            List<Blog> blogs = mapper.queryBlogChoose(argsMap);
            for (Blog blog : blogs) {
                logger.info(blog);
            }
        }
    }

    /**
     * 测试 set
     */
    @Test
    public void test5() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

            Map<String, Object> argsMap = new HashMap<>();
            argsMap.put("title", "震惊!!!!!喝水居然有这么多花样......");
//            argsMap.put("author", "赵日天");
            argsMap.put("id", "3c3f5c0cd3f24588b17194c756d0a5de");

            int i = mapper.updateBlogTestSet(argsMap);

            logger.info(i);
            List<Blog> allBlog = mapper.getAllBlog();
            for (Blog blog : allBlog) {
                logger.info(blog);
            }
        }
    }

    /**
     * 测试foreach
     */
    @Test
    public void test6() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

            Map<String, Object> argsMap = new HashMap<>();

            List<Integer> idsList = new LinkedList<>();
            idsList.add(1);
            idsList.add(2);
            idsList.add(3);

            argsMap.put("ids", idsList);

            List<Blog> blogs = mapper.queryBlogForEach(argsMap);
            for (Blog blog : blogs) {
                logger.info(blog);
            }
        }
    }
}
