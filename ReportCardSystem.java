import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class ReportCardSystem {
    static Scanner sc = new Scanner(System.in);
    static String[] subjects = {"MATHS", "SCIENCE", "COMPUT", "ENGLISH", "SST"};
    static String subjectsFile = "subjects.txt";
    static String studentsFile = "students.txt";

    public static void main(String[] args) {
        loadSubjects();

        while (true) {
            System.out.println("\n=== Student Report Card Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Edit Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("7. Edit Subject Names");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> displayAllStudents();
                case 3 -> searchStudent();
                case 4 -> editStudent();
                case 5 -> deleteStudent();
                case 6 -> {
                    System.out.println("Exiting...");
                    saveSubjects();
                    return;
                }
                case 7 -> editSubjects();
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    static void loadSubjects() {
        try (BufferedReader br = new BufferedReader(new FileReader(subjectsFile))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null && i < subjects.length) {
                subjects[i++] = line.trim();
            }
        } catch (IOException e) {
            // If file doesn't exist, default subjects will be used
        }
    }

    static void saveSubjects() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(subjectsFile))) {
            for (String subject : subjects) {
                bw.write(subject);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving subjects.");
        }
    }

    static void addStudent() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(studentsFile, true))) {
            System.out.print("Enter Roll Number: ");
            String roll = sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            int[] marks = new int[subjects.length];
            for (int i = 0; i < subjects.length; i++) {
                System.out.print("Enter marks for " + subjects[i] + ": ");
                marks[i] = sc.nextInt();
            }
            sc.nextLine();

            StringBuilder sb = new StringBuilder();
            sb.append(roll).append(",").append(name);
            for (int mark : marks) sb.append(",").append(mark);

            bw.write(sb.toString());
            bw.newLine();
            System.out.println("Student added successfully.");
        } catch (IOException e) {
            System.out.println("Error adding student.");
        }
    }

    static void displayAllStudents() {
        try (BufferedReader br = new BufferedReader(new FileReader(studentsFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                displayStudent(line);
            }
        } catch (IOException e) {
            System.out.println("No student data found.");
        }
    }

    static void searchStudent() {
        System.out.print("Enter Roll Number to search: ");
        String roll = sc.nextLine();
        boolean found = false;
        try (BufferedReader br = new BufferedReader(new FileReader(studentsFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(roll + ",")) {
                    displayStudent(line);
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading student file.");
        }
        if (!found) System.out.println("Student not found.");
    }

    static void editStudent() {
        System.out.print("Enter Roll Number to edit: ");
        String roll = sc.nextLine();
        List<String> students = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(studentsFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(roll + ",")) {
                    found = true;
                    System.out.println("Editing details for roll: " + roll);
                    System.out.print("Enter new Name: ");
                    String name = sc.nextLine();

                    int[] marks = new int[subjects.length];
                    for (int i = 0; i < subjects.length; i++) {
                        System.out.print("Enter marks for " + subjects[i] + ": ");
                        marks[i] = sc.nextInt();
                    }
                    sc.nextLine();

                    StringBuilder sb = new StringBuilder();
                    sb.append(roll).append(",").append(name);
                    for (int mark : marks) sb.append(",").append(mark);

                    students.add(sb.toString());
                } else {
                    students.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading student file.");
        }

        if (found) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(studentsFile))) {
                for (String s : students) {
                    bw.write(s);
                    bw.newLine();
                }
                System.out.println("Student updated successfully.");
            } catch (IOException e) {
                System.out.println("Error writing student file.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    static void deleteStudent() {
        System.out.print("Enter Roll Number to delete: ");
        String roll = sc.nextLine();
        List<String> students = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(studentsFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(roll + ",")) {
                    found = true;
                } else {
                    students.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading student file.");
        }

        if (found) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(studentsFile))) {
                for (String s : students) {
                    bw.write(s);
                    bw.newLine();
                }
                System.out.println("Student deleted successfully.");
            } catch (IOException e) {
                System.out.println("Error writing student file.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    static void editSubjects() {
        for (int i = 0; i < subjects.length; i++) {
            System.out.print("Enter new name for " + subjects[i] + ": ");
            subjects[i] = sc.nextLine();
        }
        saveSubjects();
        System.out.println("Subjects updated successfully.");
    }

    static void displayStudent(String data) {
        String[] parts = data.split(",");
        String roll = parts[0];
        String name = parts[1];
        int[] marks = new int[subjects.length];
        int total = 0;

        for (int i = 0; i < subjects.length; i++) {
            marks[i] = Integer.parseInt(parts[i + 2]);
            total += marks[i];
        }

        double average = (double) total / subjects.length;
        DecimalFormat df = new DecimalFormat("#.00");

        System.out.println("\nRoll Number: " + roll);
        System.out.println("Name: " + name);
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + ": " + marks[i]);
        }
        System.out.println("Total: " + total);
        System.out.println("Average: " + df.format(average));
        System.out.println("Grade: " + getGrade(average));
    }

    static String getGrade(double average) {
        if (average >= 90) return "A+";
        else if (average >= 80) return "A";
        else if (average >= 70) return "B";
        else if (average >= 60) return "C";
        else if (average >= 50) return "D";
        else return "F";
    }
}
