package com.blueprint.stone.jdk_character.jdk5;

import java.util.Arrays;

public class TypeSafeEnums {

    public static void main(String[] args) {

        System.out.println(Color.RED.toString());
        System.out.println(Coin.penny.value());

        Arrays.stream(Color.values()).forEach(System.out::println);

        Arrays.stream(Coin.values()).forEach(System.out::println);

    }

    enum Color {
        RED, BLUE, WITHE, BLACK, ORANGE, PINK, GRAY
    }

    enum Coin {

        penny(1), nickel(5), dime(10), quarter(25);

        Coin(int value) {
            this.value = value;
        }

        private final int value;

        public int value() {
            return value;
        }
    }

}
