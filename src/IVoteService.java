import java.util.HashMap;
import java.util.Map;

public class IVoteService implements Service {

    private Map<CandidateAnswer, Integer> submissions;
    private Map<Student, Integer> entry;
    private int studentResponseCount;
    private int questionType;
    private CandidateAnswer[] candidateAnswers;


    public IVoteService(int questionType, CandidateAnswer[] candidateAnswers) {
        this.questionType = questionType;
        this.candidateAnswers = candidateAnswers;
        submissions = new HashMap<>();
        for(CandidateAnswer ca : candidateAnswers) {
            submissions.put(ca, 0);
        }
        studentResponseCount = 0;
        entry = new HashMap<>();
    }

    public void addResponse(Student student) {

        for(CandidateAnswer ca : student.getAnswer()) {
            submissions.put(ca, submissions.get(ca) + 1);
        }

        if(!entry.containsKey(student)) {
            entry.put(student, 1);
            uniqueStudentResponse();
        }

    }
    private void uniqueStudentResponse() {
        studentResponseCount += 1;
    }

    public String displayStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Total submissions: " + studentResponseCount + "\n");
        for(CandidateAnswer ca : submissions.keySet()) {
            sb.append(ca.getAnswer() + " : " + submissions.get(ca) + "\t");
        }

        return sb.toString();
    }


    public int getStudentResponseCount() {
        return studentResponseCount;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }
}
