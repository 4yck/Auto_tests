package com.dataart.selenium.models;

public class UserBuilder {
    public static User admin() {
        User user = new User("admin", "admin");
        user.setFname("Ivan");
        user.setLname("Petrov");
        return user;
    }

    public static User newUser() {
        User user = new User("ppetrov", "sibrsa1965*");
        user.setFname("Petr");
        user.setLname("Petrov");
        return user;
    }

    public static User newDeveloper() {
        User user = new User("iivanov", "sibrsa1965*");
        user.setFname("Ivan");
        user.setLname("Ivanov");
        return user;
    }
}
