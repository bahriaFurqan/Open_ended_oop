package task.lab_assighment13;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/listitems";
    private static final String USER = "root"; // replace with your MySQL

    private static final String PASSWORD = "swabiyousafzai@furqan"; // replace with your
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
