package lesson3.StreamAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Math.*;
import static lesson3.StreamAPI.Student.*;

public class Main {
    public static void main() {

        record StudentGrade(
            String studentName, // Name of the student associated with the grade
            String school, // Name of the student’s school
            String subject, // Name of the subject
            double score // Score for the subject
        ) {
            @Override
            public double score() {
                return score;
            }
        }

        List<Student> students= new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            students.add(new Student(Student.getRandomName(), (int) randomValueLong(10, 30, 0), Grade.getRandomGradeList(),getRandomSchool(),Address.getRandomAddress()));
        }

        System.out.println();
        System.out.println("List for testing: ");
        printList(students);

        System.out.println();
        System.out.println("Filter 1: ");
        printStream(
            students.stream()
                .filter(s -> s.age>15 && s.address.city.equals("New York"))
                .flatMap(s -> {
                    List<StudentGrade> sg = new ArrayList<>();
                    for (int i = 0; i < s.grades.size(); i++) {
                        sg.add(new StudentGrade(s.name,s.school, s.grades.get(i).subject,s.grades.get(i).score));
                    }
                    return sg.stream();
                })
                .sorted(Comparator.comparing(StudentGrade::score).reversed())
                .limit(3)
        );
    }

    public static double randomValueDouble(double min_value, double max_value, int sign_count) {
        double sign = pow(10,sign_count);
        double result = Math.random()*(max_value-min_value)+min_value;
        return ceil(result*sign)/sign;
    }

    public static long randomValueLong(int min_value, int max_value, int zero_count) {
        long sign = round(pow(10,zero_count));
        double result = Math.random()*(max_value-min_value)+min_value;
        if(zero_count>0)
            return (round(result/sign)*sign);
        else if (zero_count<0) {
            return 0;
        } else {
            return round(result);
        }
    }

    public static void printList(List<?> o) {
        for (Object object : o) {
            System.out.println(object.toString());
        }
    }

    public static void printStream(Stream<?> o) {
        o.forEach(o1 -> System.out.println(o1.toString()));
    }
}