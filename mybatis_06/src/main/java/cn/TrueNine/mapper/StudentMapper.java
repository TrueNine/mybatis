package cn.TrueNine.mapper;

import cn.TrueNine.pojo.Student;

import java.util.List;

/**
 * @author TrueNine
 * @version 1.0
 * @date 2020/6/21
 */
public interface StudentMapper {
    /**
     * 查询所有学生的对应信息
     *
     * @return 学生列表
     */
    List<Student> getStudent();

    List<Student> getStudent2();
}
