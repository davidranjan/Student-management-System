import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        while (true) {
            System.out.println("Enter 1 to add a student");
            System.out.println("Enter 2 to remove a student");
            System.out.println("Enter 3 to display all students");
            System.out.println("Enter 4 to exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(scanner, studentList);
                    break;
                case 2:
                    removeStudent(scanner, studentList);
                    break;
                case 3:
                    displayAllStudents(studentList);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
        }
    }

    private static void addStudent(Scanner scanner, ArrayList<Student> studentList) {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        System.out.print("Enter student ID: ");
        String id = scanner.next();

        ArrayList<String> subjectList = new ArrayList<>();
        ArrayList<Double> percentageList = new ArrayList<>();

        // Input subjects and percentages
        for (int i = 1; i <= 3; i++) {
            System.out.print("Enter subject " + i + " name: ");
            String subject = scanner.next();
            subjectList.add(subject);

            System.out.print("Enter " + subject + " percentage: ");
            double percentage = scanner.nextDouble();
            percentageList.add(percentage);
        }

        studentList.add(new Student(name, id, subjectList, percentageList));
        System.out.println("Student added!");
    }

    private static void removeStudent(Scanner scanner, ArrayList<Student> studentList) {
        System.out.print("Enter student ID: ");
        String id = scanner.next();
        boolean removed = false;
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                studentList.remove(student);
                removed = true;
                System.out.println("Student removed!");
                break;
            }
        }
        if (!removed) {
            System.out.println("Student not found");
        }
    }

    private static void displayAllStudents(ArrayList<Student> studentList) {
        if (studentList.isEmpty()) {
            System.out.println("No students to display");
        } else {
            for (Student student : studentList) {
                System.out.println("Student Name: " + student.getName());
                System.out.println("Student ID: " + student.getId());
                System.out.println("Subjects and Marks:");
    
                ArrayList<String> subjectList = student.getSubjectList();
                ArrayList<Double> percentageList = student.getPercentageList();
    
                for (int i = 0; i < subjectList.size(); i++) {
                    System.out.println(subjectList.get(i) + ": " + percentageList.get(i));
                }
    
                System.out.println("Average Percentage: " + student.getPercentageAverage());
                System.out.println();
            }
        }
    }
    
    

    private static class Student {
        private String name;
        private String id;
        private ArrayList<String> subjectList;
        private ArrayList<Double> percentageList;

        public Student(String name, String id, ArrayList<String> subjectList, ArrayList<Double> percentageList) {
            this.name = name;
            this.id = id;
            this.subjectList = subjectList;
            this.percentageList = percentageList;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public ArrayList<String> getSubjectList() {
            return subjectList;
        }

        public ArrayList<Double> getPercentageList() {
            return percentageList;
        }

        public double getPercentageAverage() {
            double sum = 0;
            for (Double percentage : percentageList) {
                sum += percentage;
            }
            return sum / percentageList.size();
        }
    }
}