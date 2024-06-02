import java.util.*;

public class CollegeStudent extends Student {
    public void setGraduateScore(double graduateScore) {
        this.graduateScore = graduateScore;
    }

    private double graduateScore;
    public CollegeStudent(){}
    public CollegeStudent(double graduateScore) {
        this.graduateScore = graduateScore;
    }

    public CollegeStudent(String studentNumber, String studentFullName, int credits, double avgScore, double graduateScore) {
        super(studentNumber, studentFullName, credits, avgScore);
        this.graduateScore = graduateScore;
    }
    @Override
    public void Input(){
        super.Input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter graduate score: ");
        this.graduateScore = sc.nextDouble();
    }

    @Override
    public boolean CheckGraduation(){

        if (graduateScore < 5 ){
            return false;
        }
        return super.CheckGraduation();
    }

}
