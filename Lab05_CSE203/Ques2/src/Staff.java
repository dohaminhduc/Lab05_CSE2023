import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Staff {

    protected String fullname;
    protected String dateOfBirth;
    protected long IDnumber;
    protected double salary;
    Scanner sc = new Scanner(System.in);

    public Staff(String fullname, String dateOfBirth, long IDnumber, double salary) {
        this.fullname = fullname;
        this.dateOfBirth = dateOfBirth;
        this.IDnumber = IDnumber;
        this.salary = salary;
    }

    public Staff() {
    }

    public long getIDnumber() {
        return IDnumber;
    }

    public void CalculateSalary() {

    }

    public void Edit() {

    }

    public void Input() {
        System.out.print("Enter Full name: ");
        fullname = sc.nextLine();
        System.out.print("Enter date of birth:  ");
        dateOfBirth = sc.nextLine();

        while (true) {
            try {
                System.out.print("Enter id number: ");
                IDnumber = sc.nextLong();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Please enter id number again: ");
                sc.nextLine();
            }
        }

    }

    @Override
    public String toString() {
        return "ID number: " + IDnumber + "\nFullname: " + fullname + "\nDate of birth: " + dateOfBirth + "\n";
    }

    static Comparator<Staff> comBySalary = (Staff a, Staff b) -> (int) (b.salary - a.salary);
}
