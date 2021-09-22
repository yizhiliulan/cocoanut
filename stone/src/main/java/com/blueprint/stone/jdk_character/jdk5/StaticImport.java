package com.blueprint.stone.jdk_character.jdk5;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;
import static java.util.Arrays.asList;
import static com.blueprint.stone.jdk_character.jdk5.Varargs.arrayJoin;

/**
 *  static import
 *
 */
public class StaticImport {

    public static void main(String[] args) {
        List list = asList(new String[]{"3","6"});
        out.println(arrayJoin((String[])list.toArray(new String[list.size()])));
    }

}
