
//version 0001
//make sure to update for more features


import java.util.Scanner;
//here student details variables are defined
class Student {// super class
    String admissionNumber;
    String name;
    int maths;
    int language;
    int kiswahili;
    int environmental;
    int creativity;
    String term;
//here attributes are declared
    Student(String admissionNumber, String name, String term) {
        this.admissionNumber = admissionNumber;
        this.name = name;
        this.term = term;
    }

    void addScores(int maths, int language, int kiswahili, int environmental, int creativity) {//method to be called for subject scores
        this.maths = maths;
        this.language = language;
        this.kiswahili = kiswahili;
        this.environmental = environmental;
        this.creativity = creativity;
    }

    int getTotalScore() {
        return maths + language + kiswahili + environmental + creativity;//generate the total score
    }
// Generate the average
    double getAverageScore() {
        return getTotalScore() / 5.0;
    }
// here if else is used to determine the scores responses
    String getGrade(double score) {
        if (score < 40) {
            return "Below Expectations";
        } else if (score < 50) {
            return "Approaches Expectations";
        } else if (score < 70) {
            return "Meets Expectations";
        } else if(score <100){
            return "Exceeds Expectations";
        }else{
            return "this is not allowed,make sure the students score were placed well and valid, ";
        }
    }
}
//this is the main class
public class ReportGenerator {// main class

    public static void main(String[] args) {//this is the main method
        String[] roles = inputRoles();
        Student student = inputStudentDetails();
        printReport(student, roles);
    }
//takes the admin details in this method
    public static String[] inputRoles() {
        Scanner scanner = new Scanner(System.in);
        String[] roles = new String[3];

        System.out.print("Enter Class Teacher's Name: ");
        roles[0] = scanner.nextLine();

        System.out.print("Enter Subject Trainer: ");
        roles[1] = scanner.nextLine();

        System.out.print("Enter School Admin: ");
        roles[2] = scanner.nextLine();

        return roles;
    }
//takes student details
    public static Student inputStudentDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Students Admission Number: ");
        String admissionNumber = scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the current Term: ");
        String term = scanner.nextLine();

        Student student = new Student(admissionNumber, name, term);

        System.out.print("Enter Maths Score: ");
        int maths = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Language Score: ");
        int language = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Kiswahili Score: ");
        int kiswahili = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Environmental Score: ");
        int environmental = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Creativity Score: ");
        int creativity = Integer.parseInt(scanner.nextLine());

        student.addScores(maths, language, kiswahili, environmental, creativity);

        return student;
    }
//out put student report in this method
    public static void printReport(Student student, String[] roles) {
        int totalScore = student.getTotalScore();
        double averageScore = student.getAverageScore();
        String grade = student.getGrade(averageScore);

        System.out.println("\nReport for Student: " + student.name);//
        System.out.println("Admission Number: " + student.admissionNumber);
        System.out.println("Term: " + student.term);
        System.out.println("Total Score: " + totalScore);
        System.out.println("Average Score: " + averageScore);
        System.out.println("Grade: " + grade);
        System.out.println("Class Teacher: " + roles[0]);
        System.out.println("Subject Trainer: " + roles[1]);
        System.out.println("School Admin: " + roles[2]);
    }
}
