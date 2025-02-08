package lesson3.StreamAPI;

import java.util.ArrayList;
import java.util.List;

import static lesson3.StreamAPI.Main.randomValueDouble;

public class Grade {
    String subject; // Name of the subject
    double score; // Score obtained in the subject

    public Grade(String subject, double score) {
        this.subject = subject;
        this.score = score;
    }

    @Override
    public String toString() {
        return subject + ", " + score;
    }

    public static List<Grade> getRandomGradeList() {
        String[] subjects={"Math","History","Geography","Art","Music"};

        List<Grade> grades= new ArrayList<>();
        for (String s : subjects) {
            grades.add(new Grade(s, randomValueDouble(0, 100, 1)));
        }
        return grades;
    }
}
