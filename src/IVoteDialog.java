public class IVoteDialog implements Dialog {



    public void configureQuestionType()  {
        System.out.println("How many candidate answers does the question have?");
    }

    @Override
    public void introduction() {
        System.out.println("This is iVote Simulator.");
    }

    @Override
    public void finish() {
        System.out.println("Simulation Finished.");
    }
}
