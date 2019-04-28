package com.blueprint.stone.jdk_character.jdk8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class safeDate {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        String s = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        System.out.println(s);

    }

}
