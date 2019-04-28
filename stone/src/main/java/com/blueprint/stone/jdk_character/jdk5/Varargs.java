package com.blueprint.stone.jdk_character.jdk5;

import java.util.Arrays;

/**
 *  Var args : variable
 * only the last variable can be used as Var args
 */
public class Varargs {

    public static void main(String[] args) {
        String s = arrayJoin(new String[]{"2","3","6","2"});
        System.out.println(s);
    }

    /**
     *  demo : transfer array as string with split ","
     *
     * @param str
     * @return
     */
    public static String arrayJoin(String... str){
        final StringBuffer sb = new StringBuffer();
        if(str.length > 0){
            Arrays.stream(str).forEach(s -> {
                sb.append(s + ",");
            });
        }
        if(sb != null && sb.length() > 0){
            return sb.toString().substring(0,sb.length() - 1);
        }
        return null;
    }

}
