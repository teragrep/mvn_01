package com.teragrep.ev;

public class GoodImplementation implements ExampleInterface {
    private final String name;
    private final int age;
    public GoodImplementation(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Hello, " + name + ", I am " + age + " years old.");
    }

    @Override
    public final int hashCode() {
        int result = 17;
        if(name != null) {
            result = 31 * result + name.hashCode();
        }
        if(age != 0) {
            result = 31 * result + age;
        }
        return result;
    }

    @Override
    public final boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ExampleInterface)) {
            return false;
        }
        GoodImplementation other = (GoodImplementation) o;
        boolean nameEquals = (this.name == null && other.name == null) || (this.name != null && this.name.equals(other.name));
        return this.age == other.age && nameEquals;
    }
}
