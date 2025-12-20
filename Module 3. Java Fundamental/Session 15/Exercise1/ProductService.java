import java.sql.*;

public class ProductService {

    public static void showAll() {
        try (Connection con = ConnectionDB.openConnection();
             CallableStatement cs = con.prepareCall("{CALL PROC_GET_ALL_PRODUCT()}")) {

            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                System.out.println(
                        rs.getInt("Product_Id") + " | " +
                        rs.getString("Product_Name") + " | " +
                        rs.getFloat("Product_Price") + " | " +
                        rs.getString("Product_catalog")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
