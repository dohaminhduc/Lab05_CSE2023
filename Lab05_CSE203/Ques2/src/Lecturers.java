import java.util.*;

public class Lecturers extends Staff{
    private final Scanner sc = new Scanner(System.in);
    private String academicRank;
    private String academicDegree;
    private int yearsOfTeaching;
    private ArrayList<String> subjects = new ArrayList<>();
    public Lecturers(String dateOfBirth, String personalID, String name, String academicRank, String academicDegree, int yearsOfTeaching, ArrayList<String> subjects) {
        super(dateOfBirth, personalID, name);
        this.academicRank = academicRank;
        this.academicDegree = academicDegree;
        this.yearsOfTeaching = yearsOfTeaching;
        this.subjects = subjects;
    }

    public Lecturers(String academicRank, String academicDegree, int yearsOfTeaching, ArrayList<String> subjects) {
        this.academicRank = academicRank;
        this.academicDegree = academicDegree;
        this.yearsOfTeaching = yearsOfTeaching;
        this.subjects = subjects;
    }
    public Lecturers() {}

    public void InfoLec(){
        Lecturers lec = new Lecturers();
        lec.Info();
        System.out.println("Enter academic rank: ");
        academicRank = sc.nextLine();
        System.out.println("Enter academic degree: ");
        academicDegree = sc.nextLine();
        System.out.println("Enter years of teaching: ");
        yearsOfTeaching = sc.nextInt();
        System.out.println("Enter number of subjects: ");
        int loop = sc.nextInt();
        for(int i=0; i<loop; i++){
            subjects.add(sc.nextLine());
        }
    }
    public double Salary(int loop , int yearsOfTeaching){
        return (yearsOfTeaching * 0.12 * loop)* 20000;
   }
}
