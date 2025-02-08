package lesson3.StreamAPI;

import java.util.List;

import static lesson3.StreamAPI.Main.randomValueLong;

public class Student {
    String name; // Name of the student
	int age; // Age of the student
	List<Grade> grades; // List of Grade objects, each representing the score in a subject
	String school; // The name of the school the student attends
	Address address; // A nested field with information about the student’s address

    public Student(String name, int age, List<Grade> grades, String school, Address address) {
        this.name = name;
        this.age = age;
        this.grades = grades;
        this.school = school;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grades=" + grades +
                ", school='" + school + '\'' +
                ", address=" + address +
                '}';
    }

    public static String getRandomName() {
        String[] names = {"Alice", "David", "Jack", "Thomas", "Charlie", "William"};
        return names[(int) randomValueLong(0,5,0)];
    }

    public static String getRandomSchool() {
        return "School №"+ randomValueLong(1,100,0);
    }
}
