package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {



        String query = "SELECT * FROM customer";

        try (
                Connection conn = Database.getConnection();
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery()
                ) {
            while(rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                User user = new User(id, firstName, lastName);

                System.out.printf(user.toString());
                /*System.out.println(String.format(
                        "%s: %s %s",
                        id, firstName, lastName
                ));*/
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}