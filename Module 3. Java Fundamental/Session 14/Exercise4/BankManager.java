package exercise04;

import database.ConnectDatabase;

import java.sql.*;

public class BankManager {
    public void transfer(int id_from, int id_to, double amount) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectDatabase.getConnection();
            if (connection != null) {
                connection.setAutoCommit(false);
                callableStatement = connection.prepareCall("{call transfer_funds(?,?,?,?)}");
                callableStatement.setInt(1, id_from);
                callableStatement.setInt(2, id_to);
                callableStatement.setDouble(3, amount);
                callableStatement.registerOutParameter(4, Types.VARCHAR);
                callableStatement.executeUpdate();
                connection.commit();
                String rs = callableStatement.getString(4);
                System.out.println(rs);
            }

        } catch (Exception e) {
            try {
               if (connection != null) {
                   connection.rollback();
               }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("Chuyển tiền thất bại !");
        }finally {
            try {
                if(callableStatement != null)callableStatement.close();
                if(connection != null)connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
