package cn.TrueNine.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 博客表映射对象
 *
 * @author TrueNine
 * @version 1.0
 * @date 2020/6/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Blog {
    private String id;
    private String title;
    private String author;
    private java.util.Date createTime;
    private int views;
}