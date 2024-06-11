package org.example.controller;

import org.example.domain.DAO.ConnectionRequestDAO;
import org.example.domain.DAO.UserDAO;
import org.example.domain.model.ConnectionRequest;


import java.util.ArrayList;

import static org.example.Main.*;

public class ConnectionController {
    public static void invite() {
        System.out.print("Search user: ");
        ArrayList<UserDAO> users = userService.searchByUsername(scanStr.nextLine(), currentUser.getId());
        for (int i = 0; i < users.size(); i++) {
            System.out.println(i + 1 + " " + users.get(i));
        }

        System.out.print("Choose one user: ");
        int choice = scanNum.nextInt() - 1;

        // tekshiraslar

        UserDAO userDAO = users.get(choice);

        switch (userDAO.getState()) {
            case WITHDRAWN -> {
                System.out.println("You can send request after 2 weeks after withdrawing");
            }
            case PENDING -> {
                System.out.println("You already sent request");
            }
            case CONNECTED -> {
                System.out.println("You already have connection with this user");
            }
            case NOT_CONNECTED -> {
                connectionRequestService.save(ConnectionRequest.builder()
                        .senderId(currentUser.getId())
                        .receiverId(userDAO.getId())
                        .build());
                System.out.println("Request Sent");
            }
        }
    }

    public static void receivedInvitations(){
        ArrayList<ConnectionRequestDAO> receivedRequests = connectionRequestService.getReceivedRequests(currentUser.getId());

        for (ConnectionRequestDAO receivedRequest : receivedRequests) {
            System.out.println(receivedRequest);
        }
    }
}
