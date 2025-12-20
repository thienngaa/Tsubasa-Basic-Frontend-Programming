import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/ProductManagement";
    private static final String USER = "root";
    private static final String PASS = "1234";

    public static Connection openConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
