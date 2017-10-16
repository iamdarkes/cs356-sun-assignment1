import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulatorDriver implements Driver {

    private static final int STUDENT_AMOUNT = 15;
    private static final int QUESTION_AMOUNT = 3;

    public static void main(String[] args) {
        //runRandomSimulation();
        runEveryQuestionSimulation();
    }


    /**
     * makes sure to go through every question once
     */
    public static void runEveryQuestionSimulation() {
        System.out.println(new IVoteDialog().introduction());

        for (int j = 0; j < QUESTION_AMOUNT; j++) {
            Student[] students = generateStudents();
            String[] questions = {IVoteDialog.QUESTION_1, IVoteDialog.QUESTION_2, IVoteDialog.QUESTION_3};
            List<String[]> ca = new ArrayList<>();
            ca.add(IVoteDialog.CANDIDATE_ANSWERS_1);
            ca.add(IVoteDialog.CANDIDATE_ANSWERS_2);
            ca.add(IVoteDialog.CANDIDATE_ANSWERS_3);
            System.out.println(IVoteDialog.SCQ_OR_MCQ);
            Random random = new Random();
            int type = random.nextInt(2);
            System.out.println(IVoteDialog.GENERATED_VALUE + type);
            System.out.println(IVoteDialog.ENTER_QUESTION);
            //int rand = random.nextInt(3);
            String questionText = questions[j];
            System.out.println(IVoteDialog.GENERATED_VALUE + questionText);
            System.out.println(IVoteDialog.ENTER_CANDIDATE_ANSWERS);
            int answerCount = random.nextInt(5 - 2) + 2;
            System.out.println(IVoteDialog.GENERATED_VALUE + answerCount);
            CandidateAnswer[] candidateAnswers = new CandidateAnswer[answerCount];
            for (int i = 0; i < answerCount; i++) {
                //System.out.println("Enter candidate answer: ");
                //System.out.println("Randomly generated submission: " + ca1[i]);
                //System.out.println("Is the candidate answer correct? ");
                int correct = random.nextInt(2);
                CandidateAnswer candidateAnswer = new CandidateAnswer(ca.get(j)[i], correct == 1);
                candidateAnswers[i] = candidateAnswer;
                System.out.println(IVoteDialog.GENERATED_VALUE + candidateAnswer.getAnswer() + " : " + candidateAnswer.isCorrect());

            }
            IVoteQuestion question = new IVoteQuestion(questionText, type);
            question.setCandidateAnswers(candidateAnswers);
            IVoteService iVoteService = new IVoteService(type, candidateAnswers);
            System.out.println(IVoteDialog.STUDENTS_SUBMITTING);
            submitAnswers(students, question, answerCount, random, iVoteService);
            System.out.println(IVoteDialog.RESULTS);
            System.out.println(iVoteService.displayStatistics());
            System.out.println(new IVoteDialog().finish());
        }

    }

    /**
     * Simulate truly random simulation.
     */
    public static void runRandomSimulation() {
        Student[] students = generateStudents();

        String[] questions = {IVoteDialog.QUESTION_1, IVoteDialog.QUESTION_2, IVoteDialog.QUESTION_3};
        List<String[]> ca = new ArrayList<>();
        ca.add(IVoteDialog.CANDIDATE_ANSWERS_1);
        ca.add(IVoteDialog.CANDIDATE_ANSWERS_2);
        ca.add(IVoteDialog.CANDIDATE_ANSWERS_3);

        System.out.println(new IVoteDialog().introduction());
        System.out.println(IVoteDialog.SCQ_OR_MCQ);
        Random random = new Random();
        int type = random.nextInt(2);
        System.out.println(IVoteDialog.GENERATED_VALUE + type);
        System.out.println(IVoteDialog.ENTER_QUESTION);
        int rand = random.nextInt(3);
        String questionText = questions[rand];
        System.out.println(IVoteDialog.GENERATED_VALUE + questionText);
        System.out.println(IVoteDialog.ENTER_CANDIDATE_ANSWERS);
        int answerCount = random.nextInt(5 - 2) + 2;
        System.out.println(IVoteDialog.GENERATED_VALUE + answerCount);
        CandidateAnswer[] candidateAnswers = new CandidateAnswer[answerCount];
        for (int i = 0; i < answerCount; i++) {
            //System.out.println("Enter candidate answer: ");
            //System.out.println("Randomly generated submission: " + ca1[i]);
            //System.out.println("Is the candidate answer correct? ");
            int correct = random.nextInt(2);
            CandidateAnswer candidateAnswer = new CandidateAnswer(ca.get(rand)[i], correct == 1);
            candidateAnswers[i] = candidateAnswer;
            System.out.println(IVoteDialog.GENERATED_VALUE + candidateAnswer.getAnswer() + " : " + candidateAnswer.isCorrect());

        }
        IVoteQuestion question = new IVoteQuestion(questionText, type);
        question.setCandidateAnswers(candidateAnswers);
        IVoteService iVoteService = new IVoteService(type, candidateAnswers);
        System.out.println(IVoteDialog.STUDENTS_SUBMITTING);
        submitAnswers(students, question, answerCount, random, iVoteService);
        System.out.println(IVoteDialog.RESULTS);
        System.out.println(iVoteService.displayStatistics());
        System.out.println(new IVoteDialog().finish());
    }

    /**
     * Take input and calculate results for IVoteService
     *
     * @param students     array of students
     * @param question     IVoteQuestion that has been asked
     * @param answerCount  how many candidate answers there are
     * @param random       next random number
     * @param iVoteService service for current question
     */
    public static void submitAnswers(Student[] students, IVoteQuestion question, int answerCount, Random random, IVoteService iVoteService) {
        if (iVoteService.getQuestionType() == 0) {
            //have students answer once if SCQ
            for (int i = 0; i < students.length; i++) {
                CandidateAnswer[] ans = question.getCandidateAnswers();
                students[i].addAnswer(ans[random.nextInt(answerCount)]);
                iVoteService.addResponse(students[i]);
            }
        } else {
            //have students answer twice if MCQ
            for (int i = 0; i < students.length; i++) {
                CandidateAnswer[] ans = question.getCandidateAnswers();
                students[i].addAnswer(ans[random.nextInt(answerCount)]);
                students[i].addAnswer(ans[random.nextInt(answerCount)]);
                iVoteService.addResponse(students[i]);
            }

        }
    }

    /**
     * Make an array of unique students based on STUDENT_AMOUNT constant
     *
     * @return populated student array
     */
    public static Student[] generateStudents() {
        Student[] students = new Student[STUDENT_AMOUNT];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            //System.out.println(students[i].getUUID());
        }
        return students;
    }

}
