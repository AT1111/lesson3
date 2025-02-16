package lesson3.StreamAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Math.ceil;
import static java.lang.Math.pow;
import static java.lang.Math.round;
import static lesson3.StreamAPI.Student.getRandomSchool;

public class Main {
    public static void main() {

        List<Student> students= new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            students.add(new Student(Student.getRandomName(), (int) randomValueLong(10, 30, 0), Helper.getRandomGradeList(),getRandomSchool(),Helper.getRandomAddress()));
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
                    List<StudentGradeClass.StudentGrade> sg = new ArrayList<>();
                    for (int i = 0; i < s.grades.size(); i++) {
                        sg.add(new StudentGradeClass.StudentGrade(s.name,s.school, s.grades.get(i).subject,s.grades.get(i).score));
                    }
                    return sg.stream();
                })
                .sorted(Comparator.comparing(StudentGradeClass.StudentGrade::score).reversed())
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