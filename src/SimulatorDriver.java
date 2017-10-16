import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulatorDriver implements Driver{

    private static final int STUDENT_AMOUNT = 15;
    private static final int QUESTION_AMOUNT = 10;

    public static void main(String[] args) {
        IVoteQuestion[] questions = new IVoteQuestion[3];

        CandidateAnswer[] candidateAnswers1 = new CandidateAnswer[4];
        CandidateAnswer[] candidateAnswers2 = new CandidateAnswer[4];
        CandidateAnswer[] candidateAnswers3 = new CandidateAnswer[4];
        CandidateAnswer[] candidateAnswers4 = new CandidateAnswer[12];
        candidateAnswers1[0] = new CandidateAnswer("Blue", true);
        candidateAnswers1[1] = new CandidateAnswer("Black", false);
        candidateAnswers1[2] = new CandidateAnswer("Brown", false);
        candidateAnswers1[3] = new CandidateAnswer("Orange", false);
        candidateAnswers2[0] = new CandidateAnswer("No", false);
        candidateAnswers2[1] = new CandidateAnswer("Maybe", false);
        candidateAnswers2[2] = new CandidateAnswer("meow", false);
        candidateAnswers2[3] = new CandidateAnswer("affirmative", true);
        candidateAnswers3[0] = new CandidateAnswer("cow", false);
        candidateAnswers3[1] = new CandidateAnswer("test", false);
        candidateAnswers3[2] = new CandidateAnswer("bark", true);
        candidateAnswers3[3] = new CandidateAnswer("weesnaw", false);

        candidateAnswers4[0] = new CandidateAnswer("Blue", true);
        candidateAnswers4[1] = new CandidateAnswer("Black", false);
        candidateAnswers4[2] = new CandidateAnswer("Brown", false);
        candidateAnswers4[3] = new CandidateAnswer("Orange", false);
        candidateAnswers4[4] = new CandidateAnswer("No", false);
        candidateAnswers4[5] = new CandidateAnswer("Maybe", false);
        candidateAnswers4[6] = new CandidateAnswer("meow", false);
        candidateAnswers4[7] = new CandidateAnswer("affirmative", true);
        candidateAnswers4[8] = new CandidateAnswer("cow", false);
        candidateAnswers4[9] = new CandidateAnswer("test", false);
        candidateAnswers4[10] = new CandidateAnswer("bark", true);
        candidateAnswers4[11] = new CandidateAnswer("weesnaw", false);


        questions[0] = new IVoteQuestion("what is color of sky", candidateAnswers1);
        questions[1] = new IVoteQuestion("answer is affirmative", candidateAnswers2);
        questions[2] = new IVoteQuestion("sound of doggo", candidateAnswers3);

        Student[] students = generateStudents();


        String[] questionText = {"What is the color of the sky?", "What animal makes the noise \"bark\"?", "Who was the first president of the United States?"};
        String[] ca1 = {"Blue", "Red", "Brown", "Green", "Yellow"};
        String[] ca2 = {"Cat", "Dog", "Mouse", "Lamb", "Moose"};
        String[] ca3 = {"George Washington", "Thomas Jefferson", "Alexander Hamilton", "Benjamin Franklin", "John Adams"};
        List<String[]> ca = new ArrayList<>();
        ca.add(ca1);
        ca.add(ca2);
        ca.add(ca3);


        System.out.println("Welcome to the iVote Simulator");
        System.out.println("Enter a question type: 0) SCQ 1) MCQ");
        Random random = new Random();
        int type = random.nextInt(2);
        System.out.println("Randomly generated submission: " + type);
        System.out.println("Enter a question: ");
        int q = random.nextInt(3);
        String questionT = questionText[q];
        System.out.println("Randomly generated submission: " + questionT);
        System.out.println("Enter how many candidate answers: ");
        int answerCount = random.nextInt(5 - 2) + 2;
        System.out.println("Randomly generated submission: "  + answerCount);
        CandidateAnswer[] candidateAnswers = new CandidateAnswer[answerCount];
        for(int i = 0; i < answerCount; i++) {
            //System.out.println("Enter candidate answer: ");
            //System.out.println("Randomly generated submission: " + ca1[i]);
            //System.out.println("Is the candidate answer correct? ");
            int correct = random.nextInt(2);
            CandidateAnswer candidateAnswer = new CandidateAnswer(ca.get(q)[i], correct == 1);
            candidateAnswers[i] = candidateAnswer;
            System.out.println("Randomly generated submission: " + candidateAnswer.getAnswer() + " : " + candidateAnswer.isCorrect());

        }
        IVoteQuestion question = new IVoteQuestion(questionT, type);
        question.setCandidateAnswers(candidateAnswers);



        IVoteService ivote = new IVoteService(type, candidateAnswers);

        System.out.println("Students submitting results...");
        if(type == 0) {
            for (int i = 0; i < students.length; i++) {
                CandidateAnswer[] ans = question.getCandidateAnswers();
                students[i].addAnswer(ans[random.nextInt(answerCount)]);
                ivote.addResponse(students[i]);
            }
        } else {
            for (int i = 0; i < students.length; i++) {
                CandidateAnswer[] ans = question.getCandidateAnswers();
                students[i].addAnswer(ans[random.nextInt(answerCount)]);
                students[i].addAnswer(ans[random.nextInt(answerCount)]);
                ivote.addResponse(students[i]);
            }

        }
        System.out.println("---Results---");
        System.out.println(ivote.displayStatistics());




    }

    @Override
    public void run() {

    }

    public static Student[] generateStudents() {
        Student[] students = new Student[STUDENT_AMOUNT];
        for(int i =0; i < students.length; i++) {
            students[i] = new Student();
            //System.out.println(students[i].getUUID());
        }

        return students;
    }

    public Question[] generateQuestions() {
        Question[] questions = new Question[QUESTION_AMOUNT];

        for(int i =0; i < questions.length; i++) {
            //questions[i] = new Question
        }


        return questions;
    }
}
