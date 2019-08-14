package com.github.patrickmao93.protobuf;

import com.example.tutorial.AddressBookProtos.*;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.JsonFormat;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ExerciseMain {

    public static void main(String[] args) throws IOException {
        System.out.println("Writing AddressBook");

        AddressBook addressBook = AddressBook.newBuilder()
                .addPeople(newPerson(1, "Patrick", "patrick@gmail.com", Arrays.asList(
                        newPhone("12312323", Person.PhoneType.MOBILE)
                )))
                .addPeople(newPerson(2, "Jeff", "weng3k@gmail.com", Arrays.asList(
                        newPhone("34556453", Person.PhoneType.WORK),
                        newPhone("123123123123", Person.PhoneType.UNRECOGNIZED)
                )))
                .build();


        System.out.println("Writing to file...");
        FileOutputStream outputStream = new FileOutputStream("address_book.bin");
        addressBook.writeTo(outputStream);

        System.out.println("Reading from file...");
        FileInputStream inputStream = new FileInputStream("address_book.bin");
        AddressBook bookFromFile = AddressBook.parseFrom(inputStream);
        System.out.println("Addressbook read from file: " + bookFromFile);

        String jsonString = JsonFormat.printer().print(bookFromFile);
        System.out.println("JSON format: " + jsonString);
    }

    public static Person newPerson(int id, String name, String email, List<Person.PhoneNumber> phoneNumberList) {

        long millis = System.currentTimeMillis();
        Timestamp timestamp = Timestamp.newBuilder()
                .setSeconds(millis / 1000)
                .setNanos((int) ((millis % 1000) * 1000000))
                .build();


        Person person = Person.newBuilder().setName(name)
                .setId(id)
                .setEmail(email)
                .addAllPhones(phoneNumberList)
                .setLastUpdated(timestamp)
                .build();

        return person;
    }

    public static Person.PhoneNumber newPhone(String phoneNumber, Person.PhoneType phoneType) {
        Person.PhoneNumber phone = Person.PhoneNumber.newBuilder()
                .setNumber(phoneNumber)
                .setType(phoneType)
                .build();

        return phone;
    }
}
