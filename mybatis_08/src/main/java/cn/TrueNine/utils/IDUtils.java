package cn.TrueNine.utils;

import java.util.UUID;

/**
 * @author TrueNine
 * @version 1.0
 * @date 2020/6/24
 */
public class IDUtils {

    /**
     * 提供一个 随机的字符串 UUID
     *
     * @return UUID String
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
