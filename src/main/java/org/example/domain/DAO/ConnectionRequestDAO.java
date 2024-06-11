package org.example.domain.DAO;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ConnectionRequestDAO {
    private UUID requestId;
    private UUID userId;
    private String name;
    private String username;
    private String position;
    private LocalDateTime sentDate;

    public static ConnectionRequestDAO map(ResultSet resultSet) throws SQLException {
        return ConnectionRequestDAO.builder()
                .requestId(resultSet.getObject("req_id", UUID.class))
                .userId(resultSet.getObject("user_id", UUID.class))
                .name(resultSet.getString("name"))
                .username(resultSet.getString("username"))
                .position(resultSet.getString("position"))
                .sentDate(resultSet.getTimestamp("sent_date").toLocalDateTime())
                .build();
    }

    @Override
    public String toString() {
        return name + " | " + username + " | " +
                position;
    }
}
