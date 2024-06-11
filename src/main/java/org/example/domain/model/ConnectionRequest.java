package org.example.domain.model;

import lombok.*;
import org.example.domain.enumerators.RequestStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ConnectionRequest extends BaseModel{
    private UUID senderId;
    private UUID receiverId;
    private RequestStatus status;

    public static ConnectionRequest map(ResultSet rs) throws SQLException {
        ConnectionRequest connectionRequest = ConnectionRequest.builder()
                .senderId(rs.getObject("sender_id", UUID.class))
                .receiverId(rs.getObject("receiver_id", UUID.class))
                .status(RequestStatus.valueOf(rs.getString("status")))
                .build();
        connectionRequest.setId(rs.getObject("id", UUID.class));
        connectionRequest.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
        connectionRequest.setUpdatedDate(rs.getTimestamp("updated_date").toLocalDateTime());
        return connectionRequest;
    }
}
