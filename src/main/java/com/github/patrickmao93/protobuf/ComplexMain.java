package com.github.patrickmao93.protobuf;

import example.complex.Complex.*;

import java.util.Arrays;

public class ComplexMain {

    public static void main(String[] args) {

        System.out.println("Complex example");

        ComplexMessage.Builder builder = ComplexMessage.newBuilder();

        ComplexMessage message = builder.setOneDummy(newDummyMessage(12, "dummy1"))
                .addAllMultipleDummy(Arrays.asList(
                        newDummyMessage(1, "dummy1"),
                        newDummyMessage(2, "dummy2"),
                        newDummyMessage(3, "dummy3"),
                        newDummyMessage(4, "dummy4")
                )).build();

        System.out.println(message);
    }

    public static DummyMessage newDummyMessage(int id, String name) {

        DummyMessage.Builder builder = DummyMessage.newBuilder();
        DummyMessage message = builder.setId(id)
                .setName(name)
                .build();

        return message;
    }
}
