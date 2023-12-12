package Student;

public class MVCPatternDemo {
    public static void main(String[] args) {
        Student model = retriveStudentFromDatabase();
        //Create a view : to write course details on console
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        controller.updateView();
        //update model data
        controller.setFirstName("Roman");
        System.out.println("nAfter updating, Student.Student Details are as follows");
        controller.updateView();
    }
    private static Student retriveStudentFromDatabase(){
        Student student = new Student();
        student.setFirstName("Ivan");
        student.setLastName("Medvedev");
        student.setCourse(2);
        student.setGroup("IKBO-30-22");
        return student;
    }
}