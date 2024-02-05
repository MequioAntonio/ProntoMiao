package it.unical.prontoMiao.persistenza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IdBroker {

    private static final String query = "SELECT nextval('db_sequence') AS id";//postgresql

    public static Long getId(Connection connection){
        Long id = null;
        try {
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet result = statement.executeQuery();
            result.next();
            id = result.getLong("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

}