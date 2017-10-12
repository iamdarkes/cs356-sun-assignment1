import java.util.UUID;

public class Student {

    private String UUID;
    private int answer;

    public Student() {
        UUID = String.valueOf(java.util.UUID.randomUUID());
    }

    public String getUUID() {
        return UUID;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
