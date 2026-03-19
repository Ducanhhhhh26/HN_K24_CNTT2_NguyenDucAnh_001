package ra.buisiness;

import ra.entity.Student;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentBusiness {
    // quản lý một danh sachs List<Student>, đối tượng StudentBusiness chỉ tồn tại duy nhất trong một instance và thực hiện các yêu cầu dưới đây(bắt buộc sử dụng JAVA 8 nhé như : Stream APi , lambda, Optional)
    //1 :Hiện thị danh sách theo định dạng bảng (bao gồm mã sinh viên, tên sinh viên, tuổi, điểm trung bình) nếu rỗng thì in ra lỗi
    //2 : Thêm mới một sinh viên vào danh sách
    //3 : Cập nhật thông tin một sinh viên theo mã sinh viên
    //4 : Xóa một sinh viên theo mã sinh viên
    //5 : Tìm kiếm sinh viên theo tên (có thể tìm kiếm được cả tên đệm)
    //6 : Sap xep diem giam dan
    //7 : Loc sinh vien co diem >= 8.0
        private List<Student> students = new ArrayList<>();
        public void showList(){
            if (students.isEmpty()) {
                System.out.println("Danh sách sinh viên rỗng.");
                return;
            }
            System.out.printf("%-15s %-20s %-5s %-5s%n", "Mã SV", "Tên SV", "Tuổi", "GPA");
            students.forEach(s -> System.out.printf("%-15s %-20s %-5d %-5.2f%n",
                    s.getStudentId(), s.getStudentName(), s.getAge(), s.getGPA()));
        }
        public void addStudent(Student student) {

            if (Existed(student.getStudentId())) {
                System.out.println("Mã sinh viên đã tồn tại. Không thể thêm.");
                return;
            }
            // Confirm before adding
            char choice = 0;
            System.out.println("Ban co chac chan muon them sinh vien nay khong? (Y/N)");
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Lựa chọn rỗng, hủy thêm sinh viên.");
                return;
            }
            choice = line.toUpperCase().charAt(0);
            switch (choice) {
                case 'Y':
                    students.add(student);
                    System.out.println("Thêm sinh viên thành công.");
                    break;
                case 'N':
                    System.out.println("Hủy thêm sinh viên.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Hủy thêm sinh viên.");
            }
        }
        // Overloaded add that uses caller's Scanner
        public void addStudent(Student student, Scanner sc) {
            if (student == null
                    || student.getStudentId() == null || student.getStudentId().trim().isEmpty()
                    || student.getStudentName() == null || student.getStudentName().trim().isEmpty()) {
                System.out.println("Dữ liệu sinh viên không hợp lệ: Mã và Tên không được để trống.");
                return;
            }
            if (Existed(student.getStudentId())) {
                System.out.println("Mã sinh viên đã tồn tại. Không thể thêm.");
                return;
            }
            System.out.println("Ban co chac chan muon them sinh vien nay khong? (Y/N)");
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Lựa chọn rỗng, hủy thêm sinh viên.");
                return;
            }
            char choice = line.toUpperCase().charAt(0);
            switch (choice) {
                case 'Y':
                    students.add(student);
                    System.out.println("Thêm sinh viên thành công.");
                    break;
                case 'N':
                    System.out.println("Hủy thêm sinh viên.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Hủy thêm sinh viên.");
            }
        }

    private boolean Existed(String studentId) {
        return students.stream().anyMatch(s -> s.getStudentId().equalsIgnoreCase(studentId));
    }

    public void updateStudent(String studentId, Student newData) {
            // Validate inputs
            if (studentId == null || studentId.trim().isEmpty() || newData == null
                    || newData.getStudentName() == null || newData.getStudentName().trim().isEmpty()) {
                System.out.println("Dữ liệu cập nhật không hợp lệ: mã sinh viên và tên mới không được để trống.");
                return;
            }

            students.stream().filter(s -> s.getStudentId().equalsIgnoreCase(studentId))
                     .findFirst()

                     .ifPresent(s -> {
                        char choice = 0;
                        System.out.println("Ban co chac chan muon cap nhat sinh vien nay khong? (Y/N)");
                        Scanner sc = new Scanner(System.in);
                        String line = sc.nextLine().trim();
                        if (line.isEmpty()) {
                            System.out.println("Lựa chọn rỗng, hủy cập nhật.");
                            return;
                        }
                        choice = line.toUpperCase().charAt(0);
                         // neu yes thi add, nguoc lai thi khong add
                         switch (choice){
                             case 'Y' :
                                 s.setStudentName(newData.getStudentName());
                                 s.setAge(newData.getAge());
                                 s.setGPA(newData.getGPA());
                                 System.out.println("Cap nhat sinh vien thanh cong.");
                                 break;
                             case 'N' :
                                 System.out.println("Huy cap nhat sinh vien.");
                                 break;
                             default:
                                 System.out.println("Lựa chọn không hợp lệ. Hủy cap nhat sinh viên.");
                         }

                     });
         }
        // Overloaded update that uses caller's Scanner
        public void updateStudent(String studentId, Student newData, Scanner sc) {
            if (studentId == null || studentId.trim().isEmpty() || newData == null
                    || newData.getStudentName() == null || newData.getStudentName().trim().isEmpty()) {
                System.out.println("Dữ liệu cập nhật không hợp lệ: mã sinh viên và tên mới không được để trống.");
                return;
            }
            students.stream().filter(s -> s.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .ifPresent(s -> {
                        System.out.println("Ban co chac chan muon cap nhat sinh vien nay khong? (Y/N)");
                        String line = sc.nextLine().trim();
                        if (line.isEmpty()) {
                            System.out.println("Lựa chọn rỗng, hủy cập nhật.");
                            return;
                        }
                        char choice = line.toUpperCase().charAt(0);
                        switch (choice) {
                            case 'Y':
                                s.setStudentName(newData.getStudentName());
                                s.setAge(newData.getAge());
                                s.setGPA(newData.getGPA());
                                System.out.println("Cap nhat sinh vien thanh cong.");
                                break;
                            case 'N':
                                System.out.println("Huy cap nhat sinh vien.");
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ. Hủy cap nhat sinh viên.");
                        }
                    });
        }
        public void deleteStudent(String studentId, Scanner sc) {
            System.out.println("Ban co chac chan muon xoa sinh vien nay khong? (Y/N)");
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Lựa chọn rỗng, hủy xóa.");
                return;
            }
            char choice = line.toUpperCase().charAt(0);
            switch (choice) {
                case 'Y':
                    students.removeIf(s -> s.getStudentId().equalsIgnoreCase(studentId));
                    System.out.println("Xoa sinh vien thanh cong.");
                    break;
                case 'N':
                    System.out.println("Hủy xoa sinh vien.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Huy xoa sinh vien.");
            }
        }
        public List<Student> searchByName(String name) {
            return students.stream().filter(s -> s.getStudentName().toLowerCase().contains(name.toLowerCase()))
                    .collect(Collectors.toList());
        }
        // Hiển thị một danh sách sinh viên theo định dạng bảng
        public void showStudents(List<Student> list) {
            if (list == null || list.isEmpty()) {
                System.out.println("Không tìm thấy sinh viên phù hợp.");
                return;
            }
            System.out.printf("%-15s %-20s %-5s %-5s%n", "Mã SV", "Tên SV", "Tuổi", "GPA");
            list.forEach(s -> System.out.printf("%-15s %-20s %-5d %-5.2f%n",
                    s.getStudentId(), s.getStudentName(), s.getAge(), s.getGPA()));
        }
         public List<Student> sortByGPADesc() {
             return students.stream().sorted((s1, s2) -> Double.compare(s2.getGPA(), s1.getGPA()))
                     .collect(Collectors.toList());
         }
        public List<Student> filterByGPA(double threshold) {
            return students.stream().filter(s -> s.getGPA() >= threshold)
                    .collect(Collectors.toList());
        }
}
