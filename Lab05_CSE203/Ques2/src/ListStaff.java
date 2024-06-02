import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author ADMIN
 */
class ListStaff extends Vector<Staff> {

    Scanner sc = new Scanner(System.in);

    public ListStaff() {
        super();
    }

    public void addLecture() {
        Staff lec = new Lecturers();
        lec.Input();
        this.add(lec);
        savaToFile("D:\\cse203\\Assignment2_Lab5\\EiuStaff.eiu.txt");
    }

    public void addResearch() {
        Staff res = new Researchers();
        try {
            res.Input();
        } catch (InputMismatchException e) {
            System.out.println(e);
        }
        this.add(res);
        savaToFile("D:\\cse203\\Assignment2_Lab5\\EiuStaff.eiu.txt");
    }

    public void addTeachingAssitant() {
        Staff ta = new TeachingAssistants();
        try {
            ta.Input();
        } catch (InputMismatchException e) {

        }
        this.add(ta);
        savaToFile("D:\\cse203\\Assignment2_Lab5\\EiuStaff.eiu.txt");
    }

    public void addSpecialist() {
        Staff sp = new Specialists();
        sp.Input();
        this.add(sp);
        savaToFile("D:\\cse203\\Assignment2_Lab5\\EiuStaff.eiu.txt");
    }

    public void savaToFile(String fName) {
        if (this.size() == 0) {
            System.out.println("Empty list");
            return;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Staff st : this) {
                pw.println(st.toString());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Staff findID(long idInput) {
        for (Staff st : this) {
            if (st.getIDnumber() == idInput) {
                return st;
            }
        }
        return null;
    }

    public void editById() {
        System.out.print("Enter the id number of staff you want to edit: ");
        long idEdit = sc.nextLong();
        Staff st = findID(idEdit);
        if (st != null) {
            st.Edit();
            savaToFile("D:\\cse203\\Assignment2_Lab5\\EiuStaff.eiu.txt");
        } else {
            System.out.print("Not found the staff");
        }
    }

    public void remove() {
        System.out.print("Enter the id number of staff you want to remove: ");
        long idEdit = sc.nextLong();
        for (Staff st : this) {
            if (st.getIDnumber() == idEdit) {
                this.remove(st);
            }
        }
        savaToFile("D:\\cse203\\Assignment2_Lab5\\EiuStaff.eiu.txt");
    }

    public void performTotalsalary(String fName) {
        if (this.size() == 0) {
            System.out.println("Empty list");
            return;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            double total = 0;
            for (Staff st : this) {
                pw.println(st.fullname + ": " + st.salary);
                total += st.salary;
            }
            pw.println("Total salary: " + total);
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void salaryByType(String fName) {
        if (this.size() == 0) {
            System.out.println("Empty list");
            return;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            double totalLec = 0;
            double totalAssi = 0;
            double totalRe = 0;
            double totalSpe = 0;
            for (Staff st : this) {
                if (st.getClass().toString().compareTo("class cse203.assignnment2_lab5.Lecturers") == 0) {
                    totalLec += st.salary;
                } else if (st.getClass().toString().compareTo("class cse203.assignnment2_lab5.TeachingAssistant") == 0) {
                    totalAssi += st.salary;
                } else if ((st.getClass().toString().compareTo("class cse203.assignnment2_lab5.Researchers") == 0)) {
                    totalRe += st.salary;
                } else if ((st.getClass().toString().compareTo("class cse203.assignnment2_lab5.Specialists") == 0)) {
                    totalSpe += st.salary;
                }
            }
            pw.println("Total salary of lectures: " + totalLec);
            pw.println("Total salary of teaching assistants: " + totalAssi);
            pw.println("Total salary of researchers: " + totalRe);
            pw.println("Total salary of specialists: " + totalSpe);
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void SortBySalary() {
        this.sort(Staff.comBySalary);
    }

    public void Get3highest(String fName) {
        if (this.size() == 0) {
            System.out.println("Empty list");
            return;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            SortBySalary();
            for (int i = 0; i < 3; i++) {
                pw.println(this.get(i).fullname + ": " + this.get(i).salary);
            }

            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
