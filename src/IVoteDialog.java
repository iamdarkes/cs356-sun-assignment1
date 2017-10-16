public class IVoteDialog implements Dialog {

    public static final String INTRODUCTION = "This is an iVote Simulator. This will run three simulations.";
    public static final String SCQ_OR_MCQ = "Enter a question type: 0) Single Choice 1) Multiple Choice ";
    public static final String ENTER_QUESTION = "Enter a question: ";
    public static final String ENTER_CANDIDATE_ANSWERS = "Enter how many candidate answers: ";
    public static final String GENERATED_VALUE = "Randomly generated value: ";
    public static final String STUDENTS_SUBMITTING = "Students submitting results...";
    public static final String RESULTS = "---Results---";
    public static final String FINISH = "Simulation Finished. Run program again for different results.";
    public static final String QUESTION_1 = "What is the color of the sky?";
    public static final String QUESTION_2 = "What animal makes the noise \"bark\"?";
    public static final String QUESTION_3 = "Who was the first president of the United States?";
    public static final String[] CANDIDATE_ANSWERS_1 = {"Blue", "Red", "Brown", "Green", "Yellow"};
    public static final String[] CANDIDATE_ANSWERS_2 = {"Cat", "Dog", "Mouse", "Lamb", "Moose"};
    public static final String[] CANDIDATE_ANSWERS_3 = {"George Washington", "Thomas Jefferson", "Alexander Hamilton", "Benjamin Franklin", "John Adams"};

    @Override
    public String introduction() {
        return INTRODUCTION;
    }

    @Override
    public String finish() {
        return FINISH;
    }
}






