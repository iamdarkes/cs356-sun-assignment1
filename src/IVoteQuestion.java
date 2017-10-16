import java.util.ArrayList;
import java.util.List;

public class IVoteQuestion implements Question {

    private String questionText;
    private CandidateAnswer[] candidateAnswers;
    //private
    private int choiceCount;

    public IVoteQuestion(String questionText, int choiceCount) {
        this.questionText = questionText;
        this.choiceCount = choiceCount;
        this.candidateAnswers = new CandidateAnswer[choiceCount];
    }


    public IVoteQuestion(String questionText, CandidateAnswer[] candidateAnswers) {
        this.questionText = questionText;
        this.choiceCount = candidateAnswers.length;
        this.candidateAnswers = candidateAnswers;
    }




    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getQuestionText() + "\n");
        for(int i = 0; i < candidateAnswers.length; i++) {
            //sb.append((i + 1) + ") " + candidateAnswers[i].getAnswer() + " " + candidateAnswers[i].isCorrect() +  "\n");
            sb.append((i + 1) + ") " + candidateAnswers[i].getAnswer() + "\n");
        }
        return sb.toString();

    }

    @Override
    public void displayResult() {

    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public CandidateAnswer[] getCandidateAnswers() {
        return candidateAnswers;
    }

    public void setCandidateAnswers(CandidateAnswer[] candidateAnswers) {
        this.candidateAnswers = candidateAnswers;
    }

    public int getChoiceCount() {
        return choiceCount;
    }

    public List<CandidateAnswer> getCorrectAnswer() {
        //CandidateAnswer[] correctCandidateAnswers = new CandidateAnswer[candidateAnswers.length];
        List<CandidateAnswer> correctCandidateAnswers = new ArrayList<>();
        if(candidateAnswers != null) {
            for(int i =0; i < candidateAnswers.length; i++) {
                if(candidateAnswers[i].isCorrect() == true) {
                    correctCandidateAnswers.add(candidateAnswers[i]);
                }
            }
        } else {
            return null;
        }
        return correctCandidateAnswers;
    }

}
