package task;

import java.util.Scanner;

public class App {

	private static void mainMenu() {

		Scanner inp = new Scanner(System.in);

		VoteRecorder person = new VoteRecorder();

		System.out.print("-------------------");
		System.out.print(" The Main Menu ");
		System.out.print("-------------------");

		System.out.print("\n");
		System.out.println("Enter 1 to record new vote");
		System.out.println("Enter 2 to reset votes");
		System.out.println("Enter 3 to display the current total votes for presidents");
		System.out.println("Enter 4 to display the current total votes for vice presidents");
		System.out.println("Enter 5 to display the current total number of no choice as votes");
		System.out.print("\n");
		System.out.print("Enter: ");
		int usrChoice = inp.nextInt();

		switch (usrChoice) {
			case 1:
				person.getAndConfirmVotes();
				break;

			case 2:
				VoteRecorder.resetVotes();
				mainMenu();
				break;

			case 3:
				System.out.println(
						"The current votes of both the president candidates are: "
								+ VoteRecorder.getCurrentVotesPresident());
				mainMenu();
				break;

			case 4:
				System.out.println(
						"The current votes of both the vice president candidates are: "
								+ VoteRecorder.getCurrentVotesVicePresident());
				mainMenu();
				break;

			case 5:
				System.out.println(
						"The current no choice votes are: " + VoteRecorder.getCurrentVotesNoChoice());
				mainMenu();
				break;

			default:
				break;
		}
	}

	public static void main(String[] args) {

		Scanner inp = new Scanner(System.in);

		System.out.println("Welcome to the Voting System");
		System.out.print("\n");

		System.out.print("Enter the name of the 1st candidate for President: ");
		String presidentCandidate1Name = inp.nextLine();
		System.out.print("\n");
		System.out.print("Enter the name of the 2nd candidate for President: ");
		String presidentCandidate2Name = inp.nextLine();
		VoteRecorder.setCandidatesPresident(presidentCandidate1Name, presidentCandidate2Name);

		System.out.print("\n");
		System.out.print("Enter the name of the 1st candidate for Vice President: ");
		String vicePresidentCandidate1Name = inp.nextLine();
		System.out.print("\n");
		System.out.print("Enter the name of the 2nd candidate for Vice President: ");
		String vicePresidentCandidate2Name = inp.nextLine();
		VoteRecorder.setCandidatesVicePresident(vicePresidentCandidate1Name, vicePresidentCandidate2Name);

		System.out.println("\n");
		System.out.print("Enter the total number of voters: ");
		int totalVoters = inp.nextInt();

		for (int i = 0; i < totalVoters; i++) {
			System.out.print("\n");
			mainMenu();
		}

		System.out.print("\n");
		System.out.println("--------------------------------------------------------------");
		System.out.println("All the voters have voted and their votes have been recorded");

		System.out.println(
				"Now,\nTo check the results, enter 1\nTo carry out the voting process again, enter 2\nTo exit, enter 3");
		System.out.println("Enter: ");
		int userChoice = inp.nextInt();

		switch (userChoice) {
			case 1:
				System.out.print("\n");
				System.out.println("The results of the voting process are displayed below");
				System.out.println("--------------------------------------------------------------");
				System.out.println("------------- Results of Voting for President ---------------");
				System.out.print("\n");
				System.out.println("Total number of votes for " + presidentCandidate1Name + ": "
						+ VoteRecorder.getPresidentCandidateVotes(1));
				System.out.println("Total number of votes for " + presidentCandidate2Name + ": "
						+ VoteRecorder.getPresidentCandidateVotes(2));

				System.out.print("\n");
				System.out.println("--------------------------------------------------------------");
				System.out.println("----------- Results of Voting for Vice President -------------");
				System.out.print("\n");
				System.out.println("Total number of votes for " + vicePresidentCandidate1Name + ": "
						+ VoteRecorder.getPresidentCandidateVotes(1));
				System.out.println("Total number of votes for " + vicePresidentCandidate2Name + ": "
						+ VoteRecorder.getPresidentCandidateVotes(2));
				System.out.print("\n");

				if (VoteRecorder.getPresidentCandidateVotes(1) > VoteRecorder.getPresidentCandidateVotes(2)) {
					System.out.println("The winner of the presidential elections is: " + presidentCandidate1Name);
				} else if (VoteRecorder.getPresidentCandidateVotes(2) > VoteRecorder.getPresidentCandidateVotes(1)) {
					System.out.println("The winner of the presidential elections is: " + presidentCandidate2Name);
				} else {
					System.out.println("The presidential elections have a tie");
				}

				if (VoteRecorder.getVicePresidentCandidateVotes(1) > VoteRecorder.getVicePresidentCandidateVotes(2)) {
					System.out.println(
							"The winner of the vice presidential elections is: " + vicePresidentCandidate1Name);
				} else if (VoteRecorder.getPresidentCandidateVotes(2) > VoteRecorder.getPresidentCandidateVotes(1)) {
					System.out.println(
							"The winner of the vice presidential elections is: " + vicePresidentCandidate2Name);
				} else {
					System.out.println("The vice presidential elections have a tie");
				}

				break;

			case 2:
				main(args);
				break;

			case 3:
				System.exit(0);
				break;

			default:
				break;
		}

	}
}
