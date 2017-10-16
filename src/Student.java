import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Student {

    private String UUID;
    private List<CandidateAnswer> answer;

    public Student() {
        UUID = String.valueOf(java.util.UUID.randomUUID());
        answer = new ArrayList<>();
    }

    public void addAnswer(CandidateAnswer candidateAnswer) {
        if(!answer.contains(candidateAnswer))
            answer.add(candidateAnswer);
    }

    public String getUUID() {
        return UUID;
    }

    public List<CandidateAnswer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<CandidateAnswer> answer) {
        this.answer = answer;
    }
}
