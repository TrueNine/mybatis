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
     * 测试是否可用
     */
    @Test
    public void test() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacher = mapper.getTeacher(1);
            logger.info(teacher);
        }
    }

    /**
     * 测试混合查询学生携带老师信息
     * 测试通过
     */
    @Test
    public void test2() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> student = mapper.getStudent();

            for (Student student1 : student) {
                logger.info(student1);
            }
        }
    }

    /**
     * 测试按照结果嵌套处理
     */
    @Test
    public void test3() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> getStudent = mapper.getStudent2();
            for (Student student : getStudent) {
                logger.info(student);
            }
        }
    }
}
