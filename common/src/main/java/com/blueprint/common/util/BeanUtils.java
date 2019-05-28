package com.blueprint.common.util;

import com.sun.javafx.collections.MappingChange;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class BeanUtils {

    /**
     * 判断对象obj是否为空
     * @param obj Object
     * @return boolean
     */
    public static boolean isEmptyBean(Object obj){
        //字符串
        if(obj instanceof String){
            if(obj != null && obj != "") {
                return true;
            }
        }
        //列表集合
        if(obj instanceof List || obj.getClass().isAssignableFrom(List.class)){
            if(obj != null && !((List) obj).isEmpty()){
                return true;
            }
        }
        //Map集合
        if(obj instanceof Map || obj.getClass().isAssignableFrom(Map.class)){
            if(obj != null && !((Map) obj).isEmpty()){
                return true;
            }
        }


        return false;
    }

}
