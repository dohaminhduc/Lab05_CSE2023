import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Specialists extends Staff{

    private List<String> eduProjectCode = new ArrayList<>();
    private int expYears;

    public Specialists() {
    }

    public Specialists(int expYears) {
        super();
        this.expYears = expYears;
    }

    public int findTProject() {
        int count = 0;
        for (int i = 0; i < eduProjectCode.size(); i++) {
            if (eduProjectCode.get(i).charAt(0) == 'T') {
                count++;
            }
        }
        return count;
    }

    @Override
    public void CalculateSalary() {
        salary = (double) ((expYears * 4 + findTProject()) * 18000);
    }

    @Override
    public void Input() throws InputMismatchException {
        super.Input();
        while (true) {
            try {
                System.out.print("Enter number of project: ");
                int n = sc.nextInt();
                for (int i = 0; i < n; i++) {
                    System.out.print("Enter code of project " + (i + 1) + ": ");
                    eduProjectCode.add(sc.next());
                }
                break;
            } catch (Exception e) {
                System.out.print("Please enter number of project (integer)");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("Enter number of experienced years: ");
                expYears = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.print("Please enter number of experienced years again (integer)");
                sc.nextLine();
            }
        }

    }

    @Override
    public String toString() {
        String n = super.toString();
        n += "Experienced years: " + expYears + "\nNumber of project: " + eduProjectCode.size() + "are:\n";
        for (String string : eduProjectCode) {
            n += string + "\n";
        }
        n += "Salary: " + salary + "\n";
        return n;
    }

    @Override
    public void Edit() {
        System.out.println("What do you want to edit:\n 1.Fullname \n 2.Date of birth \n 3.ID number \n 4.Number of experienced years \n5.List of project");
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
                expYears = sc.nextInt();
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
                    eduProjectCode.add(index - 1, newcode);
                } else {
                    System.out.println("Do you want to remove(0) or add more project(1): ");
                    int com = sc.nextInt();
                    if (com == 0) {
                        System.out.print("Enter the index you want to remove (from 1 to ...): ");
                        int index = sc.nextInt();
                        eduProjectCode.remove(index - 1);
                    } else {
                        System.out.print("Enter the new one: ");
                        eduProjectCode.add(sc.next());
                    }
                }
                CalculateSalary();
                break;

        }

    }
}
