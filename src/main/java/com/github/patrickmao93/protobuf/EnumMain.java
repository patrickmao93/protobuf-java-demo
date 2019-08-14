package com.github.patrickmao93.protobuf;

import example.enumerations.EnumExample.*;

public class EnumMain {

    public static void main(String[] args) {

        System.out.println("Example for enums");

        EnumMessage.Builder builder = EnumMessage.newBuilder();

        builder.setId(123);
        builder.setDayOfTheWeek(DayOfTheWeek.FRIDAY);

        EnumMessage message = builder.build();

        System.out.println(message);
    }
}
