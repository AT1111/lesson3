package lesson3.StreamAPI;

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
}
