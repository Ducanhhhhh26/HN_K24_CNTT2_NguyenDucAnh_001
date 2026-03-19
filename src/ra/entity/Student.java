package ra.entity;

import java.util.Scanner;

public class Student {
    private String studentId;
    private String studentName;
    private int age;
    private double GPA;


    public Student() {
    }
    public Student(double GPA, int age, String studentId, String studentName) {
        this.GPA = GPA;
        this.age = age;
        this.studentId = studentId;
        this.studentName = studentName;
    }
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void inputData(Scanner sc) {
        do {
            System.out.print("Enter Student ID: ");
            studentId = sc.nextLine();
            if (studentId == null || studentId.trim().isEmpty()) {
                System.out.println("Mã sinh viên không được để trống. Vui lòng nhập lại.");
            }
        } while (studentId == null || studentId.trim().isEmpty());
        do {
            System.out.print("Enter Student Name: ");
            studentName = sc.nextLine();
            if (studentName == null || studentName.trim().isEmpty()) {
                System.out.println("Tên sinh viên không được để trống. Vui lòng nhập lại.");
            }
        } while (studentName == null || studentName.trim().isEmpty());
        System.out.print("Enter Age: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid age. Enter an integer for Age: ");
            sc.next();
        }
        age = sc.nextInt();
        System.out.print("Enter GPA: ");
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid GPA. Enter a number for GPA: ");
            sc.next();
        }
        GPA = sc.nextDouble();
        sc.nextLine();
    }
    public void inputData2(Scanner sc) {
        do {
            System.out.print("Enter Student Name: ");
            studentName = sc.nextLine();
            if (studentName == null || studentName.trim().isEmpty()) {
                System.out.println("Tên sinh viên không được để trống. Vui lòng nhập lại.");
            }
        } while (studentName == null || studentName.trim().isEmpty());
        System.out.print("Enter Age: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid age. Enter an integer for Age: ");
            sc.next();
        }
        age = sc.nextInt();
        System.out.print("Enter GPA: ");
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid GPA. Enter a number for GPA: ");
            sc.next();
        }
        GPA = sc.nextDouble();
        sc.nextLine();
    }
}
