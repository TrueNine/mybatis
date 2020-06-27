package cn.TrueNine.pojo;

import lombok.*;

/**
 * 用户表映射对象
 *
 * @author TrueNine
 * @version 1.0
 * @date 2020/6/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class User {
    private Integer id;
    private String name;
    private String password;
}
