import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListStaff list = new ListStaff();
        int command = 0;
        while (command != 10) {
            System.out.print("Choose command \n"
                    + "1. Add new lecture\n"
                    + "2. Add new teaching assistant\n"
                    + "3. Add new research\n"
                    + "4. Add new specialist\n"
                    + "5. Edit by id number\n"
                    + "6. Remove by id number\n"
                    + "7. Perform the calculation of the total salary of all staff. (TotalSalary.eiu with Text file)\n"
                    + "8. Statistics of the total salary of staff by type of staff. (TotalSalarybyType.eiu with Text file)\n"
                    + "9. Get a list of the 3 highest paid staff. (HighestPaidStaff.eiu with Binary file)\n"
                    + "10. Exit\n"
                    + "Command: ");
            command = sc.nextInt();
            switch (command) {
                case 1:
                    list.addLecture();
                    break;
                case 2:
                    list.addTeachingAssitant();
                    break;
                case 3:
                    list.addResearch();
                    break;
                case 4:
                    list.addSpecialist();
                    break;
                case 5:
                    list.editById();
                    break;
                case 6:
                    list.remove();
                    break;
                case 7:
                    list.performTotalsalary("D:\\cse203\\Assignment2_Lab5\\TotalSalary.eiu.txt");
                    break;
                case 8:
                    list.salaryByType("D:\\cse203\\Assignment2_Lab5\\TotalSalarybyType.eiu.txt");
                    break;
                case 9:
                    list.Get3highest("D:\\cse203\\Assignment2_Lab5\\HighestPaidStaff.eiu.txt");
                    break;
            }
        }
    }
}