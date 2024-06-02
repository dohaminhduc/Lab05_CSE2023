import java.util.Scanner;

public class UniversityStudent extends Student{
    private String thesisName;

    public void setThesisScore(double thesisScore) {
        this.thesisScore = thesisScore;
    }

    public void setThesisName(String thesisName) {
        this.thesisName = thesisName;
    }

    private double thesisScore;
    private static final Scanner sc = new Scanner(System.in);
    public UniversityStudent() {
    }

    public UniversityStudent(String thesisName, double thesisScore) {
        super();
        this.thesisName = thesisName;
        this.thesisScore = thesisScore;
    }

    @Override
    public void Input(){
        super.Input();
        System.out.print("Enter thesis name: ");
        thesisName = sc.next();
        System.out.print("Enter thesis score: ");
        thesisScore = sc.nextDouble();
    }

    public boolean CheckGraduation(){
        if (getCredits() < 150){
            return false;
        }
        if (getAvgScore() < 5){
            return false;
        }
        if (thesisScore < 5 ){
            return false;
        }
        return true;
    }
}