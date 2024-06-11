package org.example.repository;

import org.example.domain.DAO.ConnectionRequestDAO;
import org.example.domain.model.ConnectionRequest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class ConnectionRequestRepository implements BaseRepository<ConnectionRequest> {
    // siz bunday qilmang, function oching, bu tezroq bo'lishi uchun!!!
    private static final String INSERT = """
        insert into connections_requests(sender_id, receiver_id) VALUES (?::uuid, ?::uuid);""";

    @Override
    public String save(ConnectionRequest connectionRequest) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT)){
            preparedStatement.setString(1, connectionRequest.getSenderId().toString());
            preparedStatement.setString(2, connectionRequest.getReceiverId().toString());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public String update(UUID id, ConnectionRequest update) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public Optional<ConnectionRequest> findById(UUID id) {
        return Optional.empty();
    }

    public ArrayList<ConnectionRequestDAO> getReceivedRequestsOfUser(UUID userId) {
        String GET_RECEIVED_REQUESTS_OF_USER = "select * from get_received_requests_of_user(?::uuid)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_RECEIVED_REQUESTS_OF_USER)) {
            preparedStatement.setString(1, userId.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<ConnectionRequestDAO> incomingRequests = new ArrayList<>();
            while (resultSet.next()) {
                incomingRequests.add(ConnectionRequestDAO.map(resultSet));
            }
            return incomingRequests;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
