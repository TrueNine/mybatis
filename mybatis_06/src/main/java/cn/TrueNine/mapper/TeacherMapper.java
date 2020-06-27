package cn.TrueNine.mapper;

import cn.TrueNine.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author TrueNine
 * @version 1.0
 * @date 2020/6/21
 */
public interface TeacherMapper {
    /**
     * 测试是否环境搭建成功
     *
     * @param id 学生 id
     * @return 学生映射对象
     */
    @Select("select * from mybatis.`teacher` where `id` = #{id}")
    Teacher getTeacher(@Param("id") Integer id);
}
