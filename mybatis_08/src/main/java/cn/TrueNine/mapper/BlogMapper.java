package cn.TrueNine.mapper;

import cn.TrueNine.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author TrueNine
 * @version 1.0
 * @date 2020/6/24
 */
public interface BlogMapper {
    /**
     * 用于测试环境搭建
     *
     * @return List 列表
     */
    List<Blog> getAllBlog();

    /**
     * 向表内加入数据
     *
     * @param blog 映射对象
     * @return 修改行数
     */
    int addBlog(Blog blog);

    /**
     * 查询博客
     *
     * @return 筛选列表
     */
    List<Blog> queryBlogIf(Map<String, Object> map);

    /**
     * 测试 Choose
     *
     * @param map 参数列表
     * @return 筛选列表
     */
    List<Blog> queryBlogChoose(Map<String, Object> map);

    /**
     * 测试更新博客,使用 set 标签
     *
     * @param map 参数列表
     * @return 修改行数
     */
    int updateBlogTestSet(Map<String, Object> map);

    /**
     * 循环查询列表
     *
     * @param map 参数列表
     * @return 结果集
     */
    List<Blog> queryBlogForEach(Map<String, Object> map);
}
