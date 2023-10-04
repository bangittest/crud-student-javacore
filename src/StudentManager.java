import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentManager {
    private static List<Student>students=new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }
    public static List<Student> getAllStudents() {
        return students;
    }

    public void updateStudent(Student updatedStudent){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId()==updatedStudent.getId()){
                students.set(i, updatedStudent);
                break;
            }
        }
    }
    public void deleteStudent(int id){
        students.removeIf(student -> student.getId()==id);
    }

    public List<Student>searchStudentsByName(String searchName){
        List<Student>searchResults=new ArrayList<>();
        for (Student student : students) {
            if (student.getName().toLowerCase().contains((searchName.toLowerCase()))) {

                searchResults.add(student);
            }
        }
        return searchResults;
    }
    public void sortByAgescending(){
        students.sort(Comparator.comparingInt(Student::getAge));
    }

    public void sortByAgeDescending(){
        students.sort((s1,s2) -> s2.getAge() - s1.getAge());
    }
}
