package Student;

public class StudentController {
    private StudentView view;
    private Student model;
    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }
    public void updateView() {
        view.printCourseDetails(model.getFirstName(), model.getLastName(), model.getGroup(), model.getCourse());
    }
    public void setFirstName(String firstName) {
        model.setFirstName(firstName);
    }
    public void setLastName(String lastName) {
        model.setLastName(lastName);
    }
    public void setGroup(String group) {
        model.setGroup(group);
    }
    public void setCourse(int course) {
        model.setCourse(course);
    }
}
