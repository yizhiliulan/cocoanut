package com.blueprint.common.util;

import java.util.UUID;

public class StringUtils {

    /**
     * 获取32位的UUID随机数
     * @return java.lang.String
     */
    public static String getUUIDStr(){
        return UUID.randomUUID().toString().replace("_","");
    }

}
