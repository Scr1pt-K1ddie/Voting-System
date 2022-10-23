package task;

import java.util.Scanner;

public class VoteRecorder {
    private static String nameCandidatePresident1;
    private static String nameCandidatePresident2;
    private static String nameCandidateVicePresident1;
    private static String nameCandidateVicePresident2;
    private static int votesCandidatePresident1;
    private static int votesCandidatePresident2;
    private static int votesCandidateVicePresident1;
    private static int votesCandidateVicePresident2;
    private int myVoteForPresident;
    private int myVoteForVicePresident;

    private static int totalNoVotes;
    private String chosenPresidentName;
    private String chosenVicePresidentName;

    private enum PossibleVoteChoices {
        NOCHOICE,
        CANDIDATE1,
        CANDIDATE2
    }

    PossibleVoteChoices voteChoicePresidentEnum;
    PossibleVoteChoices voteChoiceVicePresidentEnum;

    // ---------------------------------------------------------------------

    public static int getPresidentCandidateVotes(int option) {

        switch (option) {
            case 1:
                return votesCandidatePresident1;

            case 2:
                return votesCandidatePresident2;

            default:
                return 0;
        }
    }

    public static int getVicePresidentCandidateVotes(int option) {

        switch (option) {
            case 1:
                return votesCandidateVicePresident1;

            case 2:
                return votesCandidateVicePresident2;

            default:
                return 0;
        }
    }

    public static void setCandidatesPresident(String name1, String name2) {
        nameCandidatePresident1 = name1;
        nameCandidatePresident2 = name2;
    }

    public static void setCandidatesVicePresident(String name1, String name2) {
        nameCandidateVicePresident1 = name1;
        nameCandidateVicePresident2 = name2;
    }

    public static void resetVotes() {
        totalNoVotes = 0;
        votesCandidatePresident1 = 0;
        votesCandidatePresident2 = 0;
        votesCandidateVicePresident1 = 0;
        votesCandidateVicePresident2 = 0;

        System.out.println("All the votes have been reset");
        System.out.print("\n");
        System.out.println("Redirected to the main menu");
    }

    public static String getCurrentVotesPresident() {

        String totalVotes = Integer.toString(votesCandidatePresident1 + votesCandidatePresident2);
        return totalVotes;

    }

    public static String getCurrentVotesVicePresident() {

        String totalVotes = Integer.toString(votesCandidateVicePresident1 + votesCandidateVicePresident2);
        return totalVotes;

    }

    // my own method (not required in question)
    public static String getCurrentVotesNoChoice() {

        String totalVotes = Integer.toString(totalNoVotes);
        return totalVotes;

    }

    public void getAndConfirmVotes() {

        myVoteForPresident = getVotes(1);
        myVoteForVicePresident = getVotes(2);

        switch (myVoteForPresident) {
            case 0:
                voteChoicePresidentEnum = PossibleVoteChoices.NOCHOICE;
                break;

            case 1:
                voteChoicePresidentEnum = PossibleVoteChoices.CANDIDATE1;
                break;

            case 2:
                voteChoicePresidentEnum = PossibleVoteChoices.CANDIDATE2;
                break;

            default:
                break;
        }

        switch (myVoteForVicePresident) {
            case 0:
                voteChoiceVicePresidentEnum = PossibleVoteChoices.NOCHOICE;
                break;

            case 1:
                voteChoiceVicePresidentEnum = PossibleVoteChoices.CANDIDATE1;
                break;

            case 2:
                voteChoiceVicePresidentEnum = PossibleVoteChoices.CANDIDATE2;
                break;

            default:
                break;
        }

        setChosenCandidatesNames();
        Boolean userHappyOrNot = confirmVotes(chosenPresidentName, chosenVicePresidentName);

        if (userHappyOrNot == false) {
            getAndConfirmVotes();
        }

        recordVotes();
        System.out.print("\n");
        System.out.println("Thank you for voting!");
        System.out.println("Your Votes Have Been Recorded");

    }

    private int getAVote(String name1, String name2) {

        Scanner inp = new Scanner(System.in);

        System.out.println("The candidates are: " + name1 + " and " + name2);
        System.out.print("\n");
        System.out.println("Enter 1 to vote for " + name1);
        System.out.println("Enter 2 to vote for " + name2);
        System.out.println("Enter 0 to vote for no candidate");
        System.out.print("\n");
        System.out.print("Enter your vote: ");
        int vote = inp.nextInt();

        return vote;
    }

    private int getVotes(int presidentOrVicePresident) {

        int userChoice = 0;

        switch (presidentOrVicePresident) {
            case 1:
                System.out.print("\n");
                System.out.println("Voting for President");
                userChoice = getAVote(nameCandidatePresident1, nameCandidatePresident2);
                return userChoice;

            case 2:
                System.out.print("\n");
                System.out.println("Voting for Vice President");
                userChoice = getAVote(nameCandidateVicePresident1, nameCandidateVicePresident2);
                return userChoice;
            default:
                break;
        }

        return 0;
    }

    private Boolean confirmVotes(String presidentVote, String vicePresidentVote) {

        Scanner inp = new Scanner(System.in);

        System.out.print("\n");

        if (presidentVote.equals("No Choice")) {
            System.out.println("You have chosen not to vote for president");
        } else {
            System.out.println("You have chosen to vote for " + presidentVote + " as president: ");
        }

        if (vicePresidentVote.equals("No Choice")) {
            System.out.println("You have chosen not to vote for vice president");
        } else {
            System.out.println(
                    "You have chosen to vote for " + vicePresidentVote + " as vice president: ");
        }

        System.out.print("\n");
        System.out.println("Are you happy with these choices? (y/n) ");
        System.out.println("Enter Y/y if you want to proceed or Enter N/n if you want to re-enter your votes");
        System.out.print("Enter your choice: ");
        String confirm = inp.nextLine();

        if (confirm.equals("Y") || confirm.equals("y")) {
            return true;
        } else if (confirm == "N") {
            return false;
        }

        return false;
    }

    private void recordVotes() {
        switch (voteChoicePresidentEnum) {
            case NOCHOICE:
                totalNoVotes++;
                break;

            case CANDIDATE1:
                votesCandidatePresident1++;
                break;

            case CANDIDATE2:
                votesCandidatePresident2++;
                break;

            default:
                break;
        }

        switch (voteChoiceVicePresidentEnum) {
            case NOCHOICE:
                totalNoVotes++;
                break;

            case CANDIDATE1:
                votesCandidateVicePresident1++;
                break;

            case CANDIDATE2:
                votesCandidateVicePresident2++;
                break;

            default:
                break;
        }
    }

    private void setChosenCandidatesNames() {

        if (voteChoicePresidentEnum.toString() == "CANDIDATE1") {
            chosenPresidentName = nameCandidatePresident1;
        } else if (voteChoicePresidentEnum.toString() == "CANDIDATE2") {
            chosenPresidentName = nameCandidatePresident2;
        } else {
            chosenPresidentName = "No choice";
        }

        if (voteChoiceVicePresidentEnum.toString() == "CANDIDATE1") {
            chosenVicePresidentName = nameCandidateVicePresident1;
        } else if (voteChoiceVicePresidentEnum.toString() == "CANDIDATE2") {
            chosenVicePresidentName = nameCandidateVicePresident2;
        } else {
            chosenVicePresidentName = "No Choice";
        }

    }
}
