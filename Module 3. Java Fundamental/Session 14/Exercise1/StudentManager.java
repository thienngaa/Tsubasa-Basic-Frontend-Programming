package exercise01;

import database.ConnectDatabase;
import validation.Validator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StudentManager {

    public void addStudents(List<Student> students) {
        Connection connection = null;
        CallableStatement stmt = null ;
        try  {
            connection = ConnectDatabase.getConnection() ;
            if (connection != null) {
                connection.setAutoCommit(false); // Bắt đầu transaction

                for (Student student : students) {
                    stmt = connection.prepareCall("{CALL add_students(?, ?)}");
                    stmt.setString(1, student.getName());
                    stmt.setInt(2, student.getAge());
                    stmt.executeUpdate();
                }

                connection.commit(); // Cam kết transaction
                System.out.println("Đã thêm sinh viên thành công.");
            }

        } catch (SQLException e) {
            try {
                connection.rollback(); // Rollback nếu có lỗi
                System.out.println("Đã xảy ra lỗi, rollback transaction.");
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void updateStudent(Student student) {
        Connection connection = null;
        CallableStatement stmt = null;

        try {
            connection = ConnectDatabase.getConnection();
            if (connection != null) {
                connection.setAutoCommit(false); // Bắt đầu transaction

                // Gọi stored procedure để cập nhật sinh viên
                stmt = connection.prepareCall("{CALL update_student(?, ?, ?)}");
                stmt.setInt(1, student.getId());
                stmt.setString(2, student.getName());
                stmt.setInt(3, student.getAge());
                stmt.executeUpdate();

                connection.commit(); // Cam kết transaction
                System.out.println("Cập nhật thông tin sinh viên thành công.");
            }

        } catch (SQLException e) {
                try {
                    connection.rollback(); // Rollback nếu có lỗi
                    System.out.println("Đã xảy ra lỗi, rollback transaction.");
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void deleteStudentByAge(Scanner scanner) {
        int age = Validator.getInt(scanner,"Nhập tuổi để xóa những học sinh có độ tuổi nhỏ hơn : ");
        Connection connection = null;
        CallableStatement stmt = null;
        try {
            connection = ConnectDatabase.getConnection() ;
            if (connection != null) {
                connection.setAutoCommit(false);
                stmt = connection.prepareCall("{CALL delete_students_by_age(?)}");
                stmt.setInt(1, age);
               int rs = stmt.executeUpdate();
                connection.commit();
                if (rs == 0) {
                    System.out.println("Không tim thấy học sinh nào có tuổi nhỏ hơn : " + age);
                }else {
                    System.out.println("Xóa thành công "+ rs + " học sinh có tuổi nhỏ hơn : " + age);
                }
            }
        } catch (Exception e) {
            try {
                connection.rollback();
            }catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        }finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
