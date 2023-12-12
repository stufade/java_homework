package Student;

public class StudentView {
    public void printCourseDetails(String FirstName, String LastName, String Group, int Course){
        System.out.println("Student.Student Details: ");
        System.out.println("Name: " + FirstName);
        System.out.println("Surname: " + LastName);
        System.out.println("Course: " + Course);
        System.out.println("Group: " + Group);
        System.out.println();
    }
}