import java.util.Scanner;

abstract class Student {


    public String getStudentFullName() {return studentFullName;}
    public String getStudentNumber() {return studentNumber;}
    public int getCredits() {return credits;}
    public double getAvgScore() {return avgScore;}
    private String studentNumber;
    private String studentFullName;

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setStudentFullName(String studentFullName) {
        this.studentFullName = studentFullName;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    private int credits;
    private double avgScore;


    public Student(){}
    public Student(String studentNumber, String studentFullName, int credits, double avgScore) {
        this.studentNumber = studentNumber;
        this.studentFullName = studentFullName;
        this.credits = credits;
        this.avgScore = avgScore;
    }

    public void Input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student number: ");
        studentNumber = sc.nextLine();
        System.out.print("Enter student full name: ");
        studentFullName = sc.nextLine();
        System.out.print("Enter credits: ");
        credits = sc.nextInt();
        System.out.print("Enter avg score: ");
        avgScore = sc.nextDouble();
    }
    public boolean CheckGraduation(){
        if (credits < 100){
            return false;
        }
        if (avgScore < 5){
            return false;
        }
        return true;
    }

}
