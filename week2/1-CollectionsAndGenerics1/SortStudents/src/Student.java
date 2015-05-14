import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student implements Comparable<Student> {

    private String name;
    private int grade;
    
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
    
    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }
    
    public static void sortStudents(List<Student> students) {
        Collections.sort(students);
    }

    @Override
    public int compareTo(Student o) {
        if(this.getGrade() > o.getGrade()) {
            return -1;
        }
        else if(this.getGrade() < o.getGrade()) {
            return 1;
        }
        else {
            if(this.getName().compareTo(o.getName()) < 0) {
                return -1;
            }
            else if(this.getName().compareTo(o.getName()) > 1) {
                return 1;
            }
        }
        
        return 0;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName() + ": " + this.getGrade());
        return sb.toString();
    }
    
    public static void main(String[] arguments) {
        List<Student> students = new ArrayList<Student>();
        
        students.add(new Student("Valery" , 6));
        students.add(new Student("Ivaylo" , 2));
        students.add(new Student("Borislav" , 4));
        students.add(new Student("Cvetelina" , 6));
        
        sortStudents(students);
        
        for(Student student : students) {
            System.out.println(student);
        }
    }
    
}
