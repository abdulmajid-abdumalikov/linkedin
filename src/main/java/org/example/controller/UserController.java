package org.example.controller;

import org.example.domain.model.User;

import static org.example.Main.*;

public class UserController {

    public static void signUp() {
        System.out.print("Enter name ");
        String name = scanStr.nextLine();

        System.out.print("Enter username ");
        String username = scanStr.nextLine();

        System.out.print("Enter password ");
        String password = scanStr.nextLine();

        System.out.print("Enter position ");
        String position = scanStr.nextLine();

        User user = User.builder()
                .name(name)
                .username(username)
                .password(password)
                .position(position)
                .build();
        userService.save(user);
    }

    public static void signIn() {
        System.out.print("Enter username ");
        String username = scanStr.nextLine();

        System.out.print("Enter password ");
        String password = scanStr.nextLine();
        currentUser = userService.signIn(
                username, password
        );

        userMenu();
    }
}
