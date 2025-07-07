    import java.util.*;

class Student {
    private String name;
    private int rollNo;
    private int[] marks = new int[3]; // 3 subjects

    public Student(String name, int rollNo, int[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public int getTotal() {
        return marks[0] + marks[1] + marks[2];
    }

    public double getAverage() {
        return getTotal() / 3.0;
    }

    public String getGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A+";
        else if (avg >= 75) return "A";
        else if (avg >= 60) return "B";
        else if (avg >= 50) return "C";
        else return "F";
    }

    public void display() {
        System.out.println("Roll No: " + rollNo + ", Name: " + name);
        System.out.println("Marks: " + Arrays.toString(marks));
        System.out.println("Total: " + getTotal() + ", Average: " + getAverage() + ", Grade: " + getGrade());
    }
}

public class StudentTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Student " + (i + 1));
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Roll No: ");
            int roll = sc.nextInt();
            int[] marks = new int[3];
            for (int j = 0; j < 3; j++) {
                System.out.print("Marks of subject " + (j + 1) + ": ");
                marks[j] = sc.nextInt();
            }
            students.add(new Student(name, roll, marks));
        }

        System.out.println("\n--- Student Report ---");
        Student topper = students.get(0);
        for (Student s : students) {
            s.display();
            System.out.println();
            if (s.getTotal() > topper.getTotal()) {
                topper = s;
            }
        }

        System.out.println("🏆 Topper of the class:");
        topper.display();

        sc.close();
    }
}


