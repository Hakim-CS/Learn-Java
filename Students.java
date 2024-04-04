import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of students in the class: ");
        int studentNumber = scanner.nextInt();
        scanner.nextLine();

        List<StudentInfo> students = new ArrayList<>(); // creating a list of students

        System.out.println("Enter the student information:");
        for (int i = 0; i < studentNumber; i++) {
            System.out.println("Enter the " + (i + 1) + "th student information:");
            System.out.println("Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Name: ");
            String name = scanner.nextLine();
            System.out.println("Midterm Grade: ");
            double midterm = scanner.nextDouble();
            System.out.println("Final Grade: ");
            double finalGrade = scanner.nextDouble();
            scanner.nextLine();

            StudentInfo student = new StudentInfo(id, name, midterm, finalGrade); // creating a student object
            students.add(student); // adding the student to the list

        } // end of for loop

        printInfo(students);
        calculateGrades(students);
        listLessThan60(students);
        topOfAverage(students);
        minMidterm(students);
        maxFinalGrade(students);
    } // end of main method

    // StudentInfo class
    static class StudentInfo {

        private int id;
        private String name;
        private double midterm;
        private double finalGrade;

        // constructor
        public StudentInfo(int id, String name, double midterm, double finalGrade) {
            this.id = id;
            this.name = name;
            this.midterm = midterm;
            this.finalGrade = finalGrade;
        } // end of constructor

        // getters and setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getMidterm() {
            return midterm;
        }

        public void setMidterm(double midterm) {
            this.midterm = midterm;
        }

        public double getFinalGrade() {
            return finalGrade;
        }

        public void setFinalGrade(double finalGrade) {
            this.finalGrade = finalGrade;
        }

        public String toString() {
            return "Student ID: " + id + ", Name: " + name + ", Midterm Grade: " + midterm + ", Final Grade: "
                    + finalGrade;
        } // end of toString method
    } // end of StudentInfo class

    // print the list of the students
    public static void printInfo(List<StudentInfo> students) {
        System.out.println("\nStudent information:  ");
        for (StudentInfo student : students) {
            System.out.println(student);
        } // end for
    } // end of printInfo method

    // calculate the %40 and %60 of the grades
    public static void calculateGrades(List<StudentInfo> students) {
        System.out.println("\nStudent grades after calculation: ");
        for (StudentInfo student : students) {
            double midterm = student.getMidterm();
            double finalGrade = student.getFinalGrade();
            double termGrade = (midterm * 0.4) + (finalGrade * 0.6);
            System.out.println("Student ID: " + student.getId() + ", Name: " + student.getName()
                    + ", Midterm Grade: " + midterm + ", Final Grade: " + finalGrade + ", Term Grade: "
                    + termGrade); //printing the calculated grades
        }
    } // end of calculateGrades method

    // list students with less than 60 term grade
    public static void listLessThan60(List<StudentInfo> students) {
        System.out.println("\nStudents with less than 60 term grade: ");
        for (StudentInfo student : students) {
            double midterm = student.getMidterm();
            double finalGrade = student.getFinalGrade();
            double termGrade = (midterm * 0.4) + (finalGrade * 0.6);
            if (termGrade < 60) {
                System.out.println( " (  " +student +" ) ");
            }
        }
    } // end of listLessThan60 method

    // list students with term grade above the average
    public static void topOfAverage(List<StudentInfo> students) {
        double average = 0;
        for (StudentInfo student : students) {
            double midterm = student.getMidterm();
            double finalGrade = student.getFinalGrade();
            double termGrade = (midterm * 0.4) + (finalGrade * 0.6);
            average += termGrade;
        }
        average /= students.size();
        System.out.println("\nStudents with term grade above the average: ");
        for (StudentInfo student : students) {
            double midterm = student.getMidterm();
            double finalGrade = student.getFinalGrade();
            double termGrade = (midterm * 0.4) + (finalGrade * 0.6);
            if (termGrade > average) {
                System.out.println(student);
            }
        }
    } // end of topOfAverage method

    // find minimum midterm grade
    public static void minMidterm(List<StudentInfo> students) {
        double minMidterm = students.get(0).getMidterm();
        for (StudentInfo student : students) {
            minMidterm = Math.min(minMidterm, student.getMidterm());
        }
        System.out.println("\nMinimum midterm grade: " + minMidterm);
    } // end of minMidterm method

    // find maximum final grade
    public static void maxFinalGrade(List<StudentInfo> students) {
        double maxFinalGrade = students.get(0).getFinalGrade();
        for (StudentInfo student : students) {
            maxFinalGrade = Math.max(maxFinalGrade, student.getFinalGrade());
        }
        System.out.println("Maximum final grade: " + maxFinalGrade);
    } // end of maxFinalGrade method

    public static void  isPassed(List<StudentInfo> students){
        for (StudentInfo student : students) {
            double midterm = student.getMidterm();
            double finalGrade = student.getFinalGrade();
            double termGrade = (midterm * 0.4) + (finalGrade * 0.6);
            if (termGrade > 60) {
                System.out.println("Student ID: " + student.getId() + ", Name: " + student.getName() + " is passed.");
            } else {
                System.out.println("Student ID: " + student.getId() + ", Name: " + student.getName() + " is failed.");
            }
        }
    }

} // end of Students class
