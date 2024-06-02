import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Management management = new Management();
    public static Scanner sc = new Scanner(System.in);
    private static final Random rand = new Random();


    public static void drawMenu(){
        int n;
        do {
            System.out.println("1. Add College Student");
            System.out.println("2. Add University Student");
            System.out.println("3. Remove student with Student Code");
            System.out.println("4. Print student list");
            System.out.println("5. Find students eligible for graduation");
            System.out.println("6. Sort list by Type and Code");
            System.out.println("7. Find student by name");
            System.out.println("8. EXIT ");
            System.out.println("99. DEV: Add random students");
            n = sc.nextInt();
            sc.nextLine();
            switch (n){
                case 1:
                    System.out.println();
                    System.out.println("===========================");
                    System.out.println("Adding College Student");
                    System.out.println("===========================");
                    System.out.println("How many students would you like to add?");
                    int loop = sc.nextInt();
                    management.addCollegeStudent(loop);
                    break;
                case 2:
                    System.out.println();
                    System.out.println("===========================");
                    System.out.println("Adding University Student");
                    System.out.println("===========================");
                    System.out.println("How many students would you like to add?");
                    int loop2 = sc.nextInt();
                    management.addUniversityStudent(loop2);
                case 3:
                    System.out.println();
                    System.out.println("===========================");
                    System.out.println("Removing Student from list");
                    System.out.println("===========================");
                    System.out.print("Enter student code (0 to return): ");
                    String code = sc.nextLine();
                    management.removeStudent(code);
                case 4:
                    management.printStudentList();
                    break;
                case 5:
                    management.eligibleCheck();
                    break;
                case 6:
                    management.sortStudentList();
                    break;
                case 7:
                    System.out.println();
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    management.findByName(name);
                    break;
                case 8:
                    System.out.print("Exiting program...");
                    System.exit(0);
                case 99:
                    System.out.println();
                    System.out.println("===========================");
                    System.out.println("Added Random Students");
                    System.out.println("===========================");
                    System.out.println();
                    addRandomStudents();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while (n != 10);
    }

    public static void main(String[] args) {
        drawMenu();
    }


    //DEV Options: generate random students
    private static String generateRandomName() {
        String[] firstNames = {"John", "Jane", "Bob", "Alice", "Tom", "Sara"};
        String[] lastNames = {"Doe", "Smith", "Johnson", "Williams", "Brown", "Jones"};
        return firstNames[rand.nextInt(firstNames.length)] + " " + lastNames[rand.nextInt(lastNames.length)];
    }

    private static String generateRandomNumber() {
        return String.format("%04d", rand.nextInt(10000));
    }

    private static String generateRandomThesisName() {
        String[] thesisNames = {"Thesis A", "Thesis B", "Thesis C", "Thesis D", "Thesis E"};
        return thesisNames[rand.nextInt(thesisNames.length)];
    }

    private static void addRandomStudents() {
        for (int i = 0; i < 5; i++) {
            // Add random College Students
            management.addRandomCollegeStudent(generateRandomName(), generateRandomNumber(), rand.nextInt(200) + 1, rand.nextDouble() * 10, rand.nextDouble() * 10);
            // Add random University Students
            management.addRandomUniversityStudent(generateRandomName(), generateRandomNumber(), rand.nextInt(200) + 1, rand.nextDouble() * 10, generateRandomThesisName(), rand.nextDouble() * 10);
        }
    }
}