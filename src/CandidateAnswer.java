public class CandidateAnswer implements Answer {

    private String answer;
    private boolean correct;

    public CandidateAnswer(String answer, boolean correct) {
        this.answer = answer;
        this.correct = correct;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @Override
    public String getAnswer() {
        return answer;
    }
}
