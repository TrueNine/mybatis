package cn.TrueNine.mapper;

import cn.TrueNine.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author TrueNine
 * @version 1.0
 * @date 2020/6/21
 */
public interface TeacherMapper {
    /**
     * 获得老师列表
     *
     * @return 老师列表
     */
    List<Teacher> getTeacherList();


    Teacher getTeacherAndStudent(@Param("tid") Integer id);

    Teacher getTeacherAndStudent2(@Param("tid") Integer id);
}