import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();

        while (true) {
            System.out.println("-------chon menu-------");
            System.out.println("1.them sinh vien");
            System.out.println("2.Hien thi danh sach sinh vien");
            System.out.println("3.Cap nhat sinh vien");
            System.out.println("4.Xoa sinh vien");
            System.out.println("5.Tim kiem sinh vien theo ten");
            System.out.println("6.Sap xep theo tuoi tang dan");
            System.out.println("7.Sap xep theo tuoi giam dan");
            System.out.println("8.Thoat");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("nhap ten sinh vien: ");
                    String name;
                    name = scanner.nextLine();

                    //kiem tra tuoi la so duong
                    int age;
                    while (true) {
                        System.out.println("Nhap tuoi sinh vien: ");
                        age = scanner.nextInt();
                        if (age > 0) {
                            break;
                        } else {
                            System.out.println("Tuoi phai la so duong");
                        }
                    }
                    scanner.nextLine();

                    System.out.println("nhap email sinh vien: ");
                    String email = scanner.nextLine();

                    //validate email
                    if (!email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
                        System.out.println("Email không hợp lệ.");
                        continue; // Bắt đầu vòng lặp lại để nhập lại
                    }


                    System.out.println("Nhap dia chi sinh vien: ");
                    String address=scanner.nextLine();

                    System.out.println("Nhap gioi tinh sinh vien (Nam hoac nu): ");
                    String gender=scanner.nextLine();
                    //kiem tra gioi tinh nam hoac nu
                    if (!gender.equals("nam") && !gender.equals("nu")) {
                        System.out.println("Gioi tinh chi la 'nam' hoac 'nu'. ");
                        continue;
                    }

                    Student newStudent = new Student(StudentManager.getAllStudents().size() + 1, name, age, email, address.isEmpty(), gender);
                    studentManager.addStudent(newStudent);
                    System.out.println("sinh vien duoc them thanh cong");
                    break;

                case 2:
                    List<Student>allStudents=studentManager.getAllStudents();
                    if (allStudents.isEmpty()){
                        System.out.println("Danh sach sinh vien trong");
                    }else {
                        System.out.println("danh sach sinh vien : ");
                        for (Student student:allStudents){
                            System.out.println(student);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập ID của sinh viên cần cập nhật: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Đọc ký tự newline

                    List<Student> studentsToUpdate = studentManager.getAllStudents();
                    boolean found = false;
                    for (Student student : studentsToUpdate) {
                        if (student.getId() == idToUpdate) {
                            System.out.print("Nhập tên mới: ");
                            String updatedName = scanner.nextLine();

                            int updatedAge;
                            while (true) {
                                System.out.print("Nhập tuổi mới: ");
                                updatedAge = scanner.nextInt();
                                if (updatedAge > 0) {
                                    break;
                                } else {
                                    System.out.println("Tuổi phải là số dương.");
                                }
                            }
                            scanner.nextLine(); // Đọc ký tự newline

                            System.out.print("Nhập email mới: ");
                            String updatedEmail = scanner.nextLine();

                            if (!updatedEmail.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
                                System.out.println("Email không hợp lệ.");
                                continue; // Bắt đầu vòng lặp lại để nhập lại
                            }

                            System.out.print("Nhập địa chỉ mới: ");
                            String updatedAddress = scanner.nextLine();

                            System.out.print("Nhập giới tính mới (nam or nu): ");
                            String updatedGender = scanner.nextLine();

                            if (!updatedGender.equals("nam") && !updatedGender.equals("nu")) {
                                System.out.println("Giới tính phải là 'nam' or 'nu'.");
                                continue; // Bắt đầu vòng lặp lại để nhập lại
                            }

                            Student updatedStudent = new Student(idToUpdate, updatedName, updatedAge, updatedEmail, updatedAddress.isEmpty(), updatedGender);
                            studentManager.updateStudent(updatedStudent);
                            System.out.println("Sinh viên đã được cập nhật thành công.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy sinh viên với ID " + idToUpdate);
                    }
                    break;

                case 4:
                    System.out.println("Nhap Id sinh vien can xoa :");
                    int idToDelete=scanner.nextInt();
                    studentManager.deleteStudent(idToDelete);
                    System.out.println("Sinh vien xoa thanh cong");
                    break;

                case 5:
                    System.out.println("Nhap ten cua sinh vien can tim kiem: ");
                    String searchName=scanner.nextLine();
                    List<Student>searchResults=studentManager.searchStudentsByName(searchName);
                    if (searchResults.isEmpty()){
                        System.out.println("khong tim thay sinh vien co ten \\\"\" + searchName + \"\\\".\"");
                    }else {
                        System.out.println("ket qua tim kiem: ");
                        for (Student student:
                             searchResults) {
                            System.out.println(student);
                        }
                    }
                    break;
                case 6:
                    studentManager.sortByAgescending();
                    System.out.println("Danh sach da duoc sap xep theo tuoi tang dan");
                    break;
                case 7:
                    studentManager.sortByAgeDescending();
                    System.out.println("Danh sach da duoc sap xep theo tuoi giam dan");
                    break;
                case 8:
                    System.out.println("ket thuc chuong trinh");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("lua chon khong hop le vui long chon lai!!! ");
                    break;
            }
        }
    }
}
