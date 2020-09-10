package university;

public class Aspirant extends Student {

    private String study;

    public Aspirant(String firstName, String lastName, String group, double averageMark, String study) {
        super(firstName, lastName, group, averageMark);
        this.study = study;
    }

    @Override
    int getScholarship() {
        int scholarship = 180;
        if (averageMark == 5.0) {
            scholarship = 200;
        }
        return scholarship;
    }
}
