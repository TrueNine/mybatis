package cn.TrueNine.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 老师表映射对象
 *
 * @author TrueNine
 * @version 1.0
 * @date 2020/6/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
    private Integer id;
    private String name;
    private List<Student> students;
}
