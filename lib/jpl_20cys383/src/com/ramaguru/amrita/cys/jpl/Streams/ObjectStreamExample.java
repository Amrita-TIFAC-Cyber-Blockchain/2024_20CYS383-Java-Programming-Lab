package com.ramaguru.amrita.cys.jpl.Streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * An example demonstrating the usage of ObjectInputStream and ObjectOutputStream to read and write objects.
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 */
class Person implements Serializable {
    private String name;
    private int age;

    /**
     * Constructs a Person object with the specified name and age.
     *
     * @param name The name of the person.
     * @param age  The age of the person.
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}

/**
 * An example demonstrating the usage of ObjectInputStream and ObjectOutputStream to read and write objects.
 *
 */
public class ObjectStreamExample {
    /**
     * Serializes a Person object into a file and then deserializes it back.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        Person person = new Person("John", 25);

        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Projects_Java\\lib\\jpl_20cys383\\src\\com\\ramaguru\\amrita\\files\\person.ser"))) {
            oos.writeObject(person);
            System.out.println("Person object serialized and saved to 'person.ser'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Projects_Java\\lib\\jpl_20cys383\\src\\com\\ramaguru\\amrita\\files\\person.ser"))) {
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println("Deserialized Person: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
