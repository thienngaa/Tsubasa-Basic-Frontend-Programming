package ra.business;

import ra.entity.Appointment;

import java.util.*;
import java.util.stream.Collectors;

public class AppointmentBusiness {
    private List<Appointment> appointments = new ArrayList<>();

    // Thêm lịch hẹn
    public void addAppointment(Scanner scanner) {
        Appointment ap = new Appointment();
        ap.inputData(scanner);

        boolean exists = appointments.stream()
                .anyMatch(a -> a.getAppointmentId()
                        .equalsIgnoreCase(ap.getAppointmentId()));

        if (exists) {
            System.err.println("Mã lịch hẹn đã tồn tại!");
            return;
        }

        appointments.add(ap);
        System.out.println("Thêm lịch hẹn thành công!");
    }

    // Hiển thị (sắp xếp theo ngày tăng dần)
    public void displayAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }

        appointments.stream()
                .sorted(Comparator.comparing(Appointment::getAppointmentDate))
                .forEach(System.out::println);
    }

    // Tìm kiếm theo tên bệnh nhân
    public void searchByPatientName(String keyword) {
        List<Appointment> result = appointments.stream()
                .filter(a -> a.getPatientName()
                        .toLowerCase()
                        .contains(keyword.toLowerCase()))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy lịch hẹn!");
        } else {
            result.forEach(System.out::println);
        }
    }

    // Cập nhật (Optional + ifPresentOrElse)
    public void updateAppointment(String id, Scanner scanner) {
        Optional<Appointment> opt = appointments.stream()
                .filter(a -> a.getAppointmentId().equalsIgnoreCase(id))
                .findFirst();

        opt.ifPresentOrElse(ap -> {
            System.out.println("Nhập thông tin mới:");
            ap.inputData(scanner);
            System.out.println("Cập nhật thành công!");
        }, () -> System.err.println("Không tìm thấy lịch hẹn!"));
    }

    // Xóa có xác nhận
    public void deleteAppointment(String id, Scanner scanner) {
        Optional<Appointment> opt = appointments.stream()
                .filter(a -> a.getAppointmentId().equalsIgnoreCase(id))
                .findFirst();

        opt.ifPresentOrElse(ap -> {
            System.out.print("Bạn có chắc muốn xóa? (Y/N): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                appointments.remove(ap);
                System.out.println("Đã xóa!");
            }
        }, () -> System.err.println("Không tìm thấy lịch hẹn!"));
    }

    // Thống kê
    public void statistics() {
        System.out.println("Tổng số lịch hẹn: " + appointments.size());

        Map<String, Long> stat = appointments.stream()
                .collect(Collectors.groupingBy(
                        Appointment::getDoctor,
                        Collectors.counting()
                ));

        stat.forEach((doctor, count) ->
                System.out.println("Bác sĩ: " + doctor + " | Số lịch: " + count));
    }
}
