package org.example.domain.model;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Connection extends BaseModel{
    private UUID senderId;
    private UUID recipientId;

    public static Connection map(ResultSet rs) throws SQLException {
        Connection connection = Connection.builder()
                .senderId(rs.getObject("sender_id", UUID.class))
                .recipientId(rs.getObject("receiver_id", UUID.class)).build();
        connection.setId(rs.getObject("id", UUID.class));
        connection.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
        connection.setUpdatedDate(rs.getTimestamp("updated_date").toLocalDateTime());
        return connection;
    }
}
