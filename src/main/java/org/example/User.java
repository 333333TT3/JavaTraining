package org.example;

public class User {

    Integer id;
    String name;
    String secName;
    String PhoneNumber;
    String UserName;

    @Override
    public String toString() {
        return this.id + " | " + this.name + " | " + this.secName + " | " + this.PhoneNumber + " | " + this.UserName;
    }
}
