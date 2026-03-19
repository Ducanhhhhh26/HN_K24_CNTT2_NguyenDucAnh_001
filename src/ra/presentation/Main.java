package ra.presentation;

import ra.buisiness.StudentBusiness;
import ra.entity.Student;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Sử dụng một Scanner duy nhất và StudentBusiness được tạo một lần
        Scanner sc = new Scanner(System.in);
        StudentBusiness sb = new StudentBusiness();
        int choice;
        while (true) {
            System.out.println("---------------------Quan ly sinh vien---------------------:");
            System.out.println("1. Hiển thị thông tin sinh viên");
            System.out.println("2. Nhập thông tin sinh viên");
            System.out.println("3. Cap nhật thông tin sinh viên");
            System.out.println("4. Xóa thông tin sinh viên");
            System.out.println("5. Tìm kiếm sinh viên theo tên");
            System.out.println("6. Sắp xếp sinh viên theo điểm giảm dần");
            System.out.println("7. Lọc sinh viên có điểm >= 8.0");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            String line = sc.nextLine();
            try {
                choice = Integer.parseInt(line.trim());
            } catch (NumberFormatException ex) {
                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập số. Thử lại.");
                continue;
            }

            switch (choice) {
                case 1:
                    sb.showList();
                    break;
                case 2:
                    Student s = new Student();
                    s.inputData(sc);
                    sb.addStudent(s);
                    break;
                case 3:
                    System.out.print("Nhập mã sinh viên cần cập nhật: ");
                    String id = sc.nextLine();
                    Student newData = new Student();
                    newData.inputData2(sc);
                    sb.updateStudent(id, newData, sc);
                    break;
                case 4:
                    System.out.print("Nhập mã sinh viên cần xóa: ");
                    String idToDelete = sc.nextLine();
                    sb.deleteStudent(idToDelete, sc);
                    break;
                case 5:
                    System.out.print("Nhập tên cần tìm: ");
                    String q = sc.nextLine();
                    sb.showStudents(sb.searchByName(q));
                    break;
                case 6:
                    sb.sortByGPADesc().forEach(sv -> System.out.println(sv.getStudentName() + " - " + sv.getGPA()));
                    break;
                case 7:
                    sb.filterByGPA(8.0).forEach(sv -> System.out.println(sv.getStudentName() + " - " + sv.getGPA()));
                    break;
                case 8:
                    System.out.println("Thoát chương trình.");
                    sc.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }

    }
}
