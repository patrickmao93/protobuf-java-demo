package com.github.patrickmao93.protobuf;

import example.simple.Simple.SimpleMessage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SimpleMain {

    public static void main(String[] args) {

        System.out.println("Hello world!");

        SimpleMessage.Builder builder = SimpleMessage.newBuilder();

        // scala fields
        builder.setId(42)
                .setIsSimple(true)
                .setName("wow");

        // repeated fields
        builder.addSampleList(1)
                .addSampleList(1)
                .addSampleList(1)
                .addAllSampleList(Arrays.asList(1, 2, 3));

        System.out.println(builder.toString());

        SimpleMessage message = builder.build();

        try {

            FileOutputStream outputStream = new FileOutputStream("simple_message.bin");
            message.writeTo(outputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Reading from file");

            FileInputStream inputStream = new FileInputStream("simple_message.bin");
            SimpleMessage messageFromFile = SimpleMessage.parseFrom(inputStream);

            System.out.println(messageFromFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
