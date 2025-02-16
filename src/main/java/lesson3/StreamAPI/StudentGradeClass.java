package lesson3.StreamAPI;

public class StudentGradeClass {
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
}
