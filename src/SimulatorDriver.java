import java.util.Random;

public class SimulatorDriver implements Driver{

    private static final int STUDENT_AMOUNT = 5;
    private static final int QUESTION_AMOUNT = 10;

    public static void main(String[] args) {
        System.out.println("Hello World");
        IVoteQuestion[] questions = new IVoteQuestion[3];


        CandidateAnswer[] candidateAnswers1 = new CandidateAnswer[4];
        CandidateAnswer[] candidateAnswers2 = new CandidateAnswer[4];
        CandidateAnswer[] candidateAnswers3 = new CandidateAnswer[4];
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


        questions[0] = new IVoteQuestion("what is color of sky", candidateAnswers1);
        questions[1] = new IVoteQuestion("answer is affirmative", candidateAnswers2);
        questions[2] = new IVoteQuestion("sound of doggo", candidateAnswers3);


        //System.out.println(questions[0].toString());
        Student[] students = generateStudents();
        for(int i = 0; i < questions.length; i++) {
            System.out.println(questions[i].toString());
            for(int j = 0; j < students.length; j++) {
                Random rand = new Random();
                //System.out.println("random: " + rand.nextInt());
                students[j].setAnswer(rand.nextInt());
                if(students[j].getAnswer() + 1 == questions[i].getCandidateAnswers())
            }

        }

//        for(int  i=0; i < questions.length; i++) {
//            questions[i] = new IVoteQuestion("Question " + i + " is this", 4);
//        }
//
//        for(int  i=0; i < questions.length; i++) {
//            questions[i] = new IVoteQuestion("Question 1 is this", 4);
//        }
    }

    @Override
    public void run() {

    }

    public static Student[] generateStudents() {
        Student[] students = new Student[STUDENT_AMOUNT];
        for(int i =0; i < students.length; i++) {
            students[i] = new Student();
            System.out.println(students[i].getUUID());
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
