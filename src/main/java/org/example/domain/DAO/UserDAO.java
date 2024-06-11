package org.example.domain.DAO;

import lombok.*;
import org.example.domain.enumerators.RelationState;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDAO {
    private UUID id;
    private String name;
    private String username;
    private String position;
    private RelationState state;

    public static UserDAO map(ResultSet resultSet) throws SQLException {
        return UserDAO.builder()
                .name(resultSet.getString("name"))
                .username(resultSet.getString("username"))
                .position(resultSet.getString("position"))
                .id(resultSet.getObject("id", UUID.class))
                .state(RelationState.valueOf(resultSet.getString("state")))
                .build();
    }

    @Override
    public String toString() {
        return name + '|' +
                 username + '|' +
                 position + '(' +
                state + ')';
    }
}
