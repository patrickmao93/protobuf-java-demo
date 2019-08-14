package com.github.patrickmao93.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.Simple;

import java.util.Arrays;

public class ProtoToJsonMain {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        System.out.println("Hello world!");

        Simple.SimpleMessage.Builder builder = Simple.SimpleMessage.newBuilder();

        // scala fields
        builder.setId(42)
                .setIsSimple(true)
                .setName("wow");

        // repeated fields
        builder.addSampleList(1)
                .addSampleList(1)
                .addSampleList(1)
                .addAllSampleList(Arrays.asList(1, 2, 3));

        // Print as JSON
        String jsonString = JsonFormat.printer().print(builder);
        System.out.println(jsonString);

        Simple.SimpleMessage.Builder builder2 = Simple.SimpleMessage.newBuilder();

        System.out.println("Builder2");
        JsonFormat.parser()
                .ignoringUnknownFields()
                .merge(jsonString, builder2);
        System.out.println(builder2);
    }
}
