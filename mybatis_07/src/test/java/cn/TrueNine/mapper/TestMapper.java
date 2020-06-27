package cn.TrueNine.mapper;

import cn.TrueNine.pojo.Student;
import cn.TrueNine.pojo.Teacher;
import cn.TrueNine.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

/**
 * 测试 mapper
 *
 * @author TrueNine
 * @version 1.0
 * @date 2020/6/21
 */
public class TestMapper {

    Logger logger = Logger.getLogger(TestMapper.class);

    /**
     * 尝试获取所有的老师列表
     * 测试通过
     */
    @Test
    public void test() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            List<Teacher> teacherList = mapper.getTeacherList();
            for (Teacher teacher : teacherList) {
                logger.info(teacher);
            }
        }
    }

    /**
     * 测试一对多查询
     * 测试通过
     */
    @Test
    public void test2() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacherAndStudent = mapper.getTeacherAndStudent(1);

            logger.info(teacherAndStudent);
            logger.warn(teacherAndStudent.getStudents().toString());
        }
    }

    /**
     * 测试一对多查询嵌套
     */
    @Test
    public void test3() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacherAndStudent2 = mapper.getTeacherAndStudent2(1);
            logger.info(teacherAndStudent2);
            List<Student> students = teacherAndStudent2.getStudents();
            for (Student student : students) {
                logger.warn(student);
            }
        }
    }
}
