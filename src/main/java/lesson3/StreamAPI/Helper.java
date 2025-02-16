package lesson3.StreamAPI;

import java.util.ArrayList;
import java.util.List;

import static lesson3.StreamAPI.Main.randomValueDouble;
import static lesson3.StreamAPI.Main.randomValueLong;

public class Helper {

    public static Address getRandomAddress() {
        int i= (int) randomValueLong(1, 4, 0);
        return switch (i) {
            case 1 -> new Address("London", "Highway 359");
            case 2 -> new Address("New York", "838 Broadway");
            case 3 -> new Address("Kyiv", "Olimpiiska St.2");
            default -> new Address("Kharkiv", "Nauki Avenue 3");
        };
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
