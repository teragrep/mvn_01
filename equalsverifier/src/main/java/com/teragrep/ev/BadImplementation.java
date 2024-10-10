package com.teragrep.ev;

public class BadImplementation implements ExampleInterface {
    private final String name;
    private final int age;
    public BadImplementation(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Hello, " + name + ", I am " + age + " years old.");
    }

    @Override
    public final boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ExampleInterface)) {
            return false;
        }
        BadImplementation other = (BadImplementation) o;
        boolean nameEquals = (this.name == null && other.name == null) || (this.name != null && this.name.equals(other.name));
        return this.age == other.age && nameEquals  ;
    }
}
