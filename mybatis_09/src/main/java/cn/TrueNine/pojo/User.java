package cn.TrueNine.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户表使用的映射独享
 *
 * @author TrueNine
 * @version 1.0
 * @date 2020/6/26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {


    private Integer id;
    private String name;
    private String pwd;
}
