package utils;

import java.sql.*;

public class DbUtils {

    private static final String DB_URL = "jdbc:mysql://yourdbserver:3306/hrms";
    private static final String USER = "username";
    private static final String PASS = "password";


    public static boolean RecordExistInDb(String query) {
        boolean recordExists = false;

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            recordExists = rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recordExists;
    }
}
