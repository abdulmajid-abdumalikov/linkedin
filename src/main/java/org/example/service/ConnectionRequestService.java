package org.example.service;

import org.example.domain.DAO.ConnectionRequestDAO;
import org.example.domain.model.ConnectionRequest;
import org.example.repository.ConnectionRequestRepository;

import java.util.ArrayList;
import java.util.UUID;

public class ConnectionRequestService implements BaseService<ConnectionRequest> {

    private static final ConnectionRequestRepository connectionRequestRepository = new ConnectionRequestRepository();
    @Override
    public String save(ConnectionRequest connectionRequest) {
        return connectionRequestRepository.save(connectionRequest);
    }

    @Override
    public String update(UUID id, ConnectionRequest update) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public ConnectionRequest findById(UUID id) {
        return null;
    }

    public ArrayList<ConnectionRequestDAO> getReceivedRequests(UUID userId) {
        return connectionRequestRepository.getReceivedRequestsOfUser(userId);
    }
}
