package ra.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Appointment {
    private String appointmentId;     // 6 ký tự, không trùng
    private String patientName;        // 10–50 ký tự
    private String phoneNumber;        // SĐT VN
    private LocalDate appointmentDate; // dd/MM/yyyy
    private String doctor;             // <= 200 ký tự

    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Appointment() {}

    public Appointment(String appointmentId, String patientName,
                       String phoneNumber, LocalDate appointmentDate,
                       String doctor) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.phoneNumber = phoneNumber;
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
    }

    // Getter & Setter
    public String getAppointmentId() { return appointmentId; }
    public void setAppointmentId(String appointmentId) { this.appointmentId = appointmentId; }
    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public LocalDate getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(LocalDate appointmentDate) { this.appointmentDate = appointmentDate; }
    public String getDoctor() { return doctor; }
    public void setDoctor(String doctor) { this.doctor = doctor; }

    // Nhập dữ liệu
    public void inputData(Scanner scanner) {
        // Mã lịch hẹn
        while (true) {
            System.out.print("Nhập mã lịch hẹn (6 ký tự): ");
            String id = scanner.nextLine().trim();
            if (id.length() == 6) {
                this.appointmentId = id;
                break;
            }
            System.err.println("Mã lịch hẹn phải đúng 6 ký tự!");
        }

        // Tên bệnh nhân
        while (true) {
            System.out.print("Nhập tên bệnh nhân (10-50 ký tự): ");
            String name = scanner.nextLine().trim();
            if (name.length() >= 10 && name.length() <= 50) {
                this.patientName = name;
                break;
            }
            System.err.println("Tên bệnh nhân không hợp lệ!");
        }

        // SĐT Việt Nam
        Pattern phonePattern = Pattern.compile("^(03|05|07|08|09)\\d{8}$");
        while (true) {
            System.out.print("Nhập số điện thoại: ");
            String phone = scanner.nextLine().trim();
            if (phonePattern.matcher(phone).matches()) {
                this.phoneNumber = phone;
                break;
            }
            System.err.println("Số điện thoại không hợp lệ!");
        }

        // Ngày hẹn
        while (true) {
            System.out.print("Nhập ngày hẹn (dd/MM/yyyy): ");
            try {
                this.appointmentDate =
                        LocalDate.parse(scanner.nextLine(), formatter);
                break;
            } catch (Exception e) {
                System.err.println("Sai định dạng ngày!");
            }
        }

        // Bác sĩ
        while (true) {
            System.out.print("Nhập tên bác sĩ (<=200 ký tự): ");
            String d = scanner.nextLine();
            if (d.length() <= 200) {
                this.doctor = d;
                break;
            }
            System.err.println("Tên bác sĩ quá dài!");
        }
    }

    @Override
    public String toString() {
        return "Mã: " + appointmentId +
                " | BN: " + patientName +
                " | SĐT: " + phoneNumber +
                " | Ngày: " + appointmentDate.format(formatter) +
                " | BS: " + doctor;
    }
}
