package org.example;

import org.example.domain.model.User;
import org.example.repository.ConnectionRequestRepository;
import org.example.repository.UserRepository;
import org.example.service.ConnectionRequestService;
import org.example.service.UserService;

import java.util.Scanner;

import static org.example.controller.ConnectionController.invite;
import static org.example.controller.ConnectionController.receivedInvitations;
import static org.example.controller.UserController.signIn;
import static org.example.controller.UserController.signUp;

public class Main {
    public static final UserService userService = new UserService();
    public static final ConnectionRequestService connectionRequestService = new ConnectionRequestService();

    public static final Scanner scanNum = new Scanner(System.in);
    public static final Scanner scanStr = new Scanner(System.in);
    public static User currentUser = null;
    public static void main(String[] args) {
        System.out.println("1. Sign in\t2. Sign Up");
        String command = scanStr.nextLine();
        switch (command) {
            case "1" -> {
                signIn();
            }
            case "2" -> {
                signUp();
            }
        }
    }

    public static void userMenu(){
        System.out.println("1. Connections\t2. Messaging\t3. Posts");
        switch (scanStr.nextLine()) {
            case "1" -> {
                connectionMenu();
            }
        }
    }

    public static void connectionMenu() {
        while(true) {
            System.out.println("1. Invitations\t2. Invite");
            switch (scanStr.nextLine()) {
                case "1" -> {
                    invitationMenu();
                }
                case "2" -> {
                    invite();
                }
            }
        }
    }
    private static void invitationMenu() {
        System.out.println("1. Received\t2. Sent");
        switch (scanStr.nextLine()) {
            case "1" -> {
                receivedInvitations();
            }
        }

    }

}