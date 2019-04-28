package com.blueprint.stone.jdk_character.jdk5;

import java.util.Arrays;
import java.util.List;

/**
 *  jdk 5 new character
 *      foreach
 */
public class ForeachLoop {

    public static void main(String [] args){

        List<String> list = Arrays.asList(new String[]{"1","2","6","4"});

        /**
         *  old style
         */
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

        /**
         * new style
         */
        for (String s : list) {
            System.out.println(s);
        }
    }

}
