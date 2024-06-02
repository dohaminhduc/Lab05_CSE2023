import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Researchers extends Staff{

    private List<String> projectCode = new ArrayList<>();
    private int numOfYearResearch;

    public Researchers() {
    }

    public Researchers(int numOfYearResearch) {
        super();
        this.numOfYearResearch = numOfYearResearch;
    }

    public int findNumOfProjectD() {
        int count = 0;
        for (int i = 0; i < projectCode.size(); i++) {
            if (projectCode.get(i).charAt(0) == 'D') {
                count++;
            }
        }
        return count;
    }

    @Override
    public void CalculateSalary() {
        salary = (double) ((numOfYearResearch * 2 + findNumOfProjectD()) * 20000);
    }

    @Override
    public void Input() {
        super.Input();
        while (true) {
            try {
                System.out.print("Enter number of project: ");
                int n = sc.nextInt();
                for (int i = 0; i < n; i++) {
                    System.out.print("Enter code of project " + (i + 1) + ": ");
                    projectCode.add(sc.next());
                }
                break;
            } catch (Exception e) {
                System.out.print("Please enter number of project again (integer)");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("Enter number of researched years: ");
                numOfYearResearch = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.print("Please enter number of researched years again (integer)");
                sc.nextLine();
            }
        }

    }

    public String toString() {
        String n = super.toString();
        n = n + "Number of project: " + n + "are:\n";
        for (String string : projectCode) {
            n += string + "\n";
        }
        n += "Salary: " + salary + "\n";
        return n;
    }

    public void Edit() {
        System.out.println("What do you want to edit:\n 1.Fullname \n 2.Date of birth \n 3.ID number \n 4.Number of years research \n5.List of project");
        int n = sc.nextInt();
        switch (n) {
            case 1:
                System.out.print("Enter the new one: ");
                fullname = sc.next();
                break;
            case 2:
                System.out.print("Enter the new one: ");
                dateOfBirth = sc.next();
                break;
            case 3:
                System.out.print("Enter the new one: ");
                IDnumber = sc.nextLong();
                break;
            case 4:
                System.out.print("Enter the new one: ");
                numOfYearResearch = sc.nextInt();
                CalculateSalary();
                break;
            case 5:
                System.out.print("Do you want to not change (0) or change(1) number of project: ");
                int temp = sc.nextInt();
                if (temp == 0) {
                    System.out.print("Enter the index you want to change (from 1 to ...): ");
                    int index = sc.nextInt();
                    System.out.print("Enter the new code project: ");
                    String newcode = sc.next();
                    projectCode.add(index - 1, newcode);
                } else {
                    System.out.println("Do you want to remove(0) or add more project(1): ");
                    int com = sc.nextInt();
                    if (com == 0) {
                        System.out.print("Enter the index you want to remove (from 1 to ...): ");
                        int index = sc.nextInt();
                        projectCode.remove(index - 1);
                    } else {
                        System.out.print("Enter the new one: ");
                        projectCode.add(sc.next());
                    }
                }
                CalculateSalary();
                break;
        }

    }
}