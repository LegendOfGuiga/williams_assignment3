package williams_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3 {
	public static void main(String args[]) {
		quiz();
	}
	
	public static void quiz() {
		SecureRandom rand = new SecureRandom();
		Scanner scan = new Scanner(System.in);

		int num1, num2,seedCorrect,seedIncorrect, ans;
		double correct, incorrect, numQuestions;
		
		while (0 != 1) {
			correct = 0.0;
			incorrect = 0.0;
			numQuestions = 0.0;
			for(int i=0; i<10; i++) {
				num1 = rand.nextInt(10);
				num2 = rand.nextInt(10);
				askQuestion(num1, num2);
				numQuestions++;
				ans = readResponse(scan);
				if (isAnswerCorrect(ans, num1, num2)) {
					correct = correct + 1;
					seedCorrect = rand.nextInt(4)+1;
					displayCorrectResponse(seedCorrect);
				}
				else {
					incorrect = incorrect + 1;
					seedIncorrect = rand.nextInt(4)+1;
					displayIncorrectResponse(seedIncorrect);
				}
			}
		
			double score = calculatePercentCorrect(correct, numQuestions);
			
			displayCompletionMessage(score);
			if(!tryAgain(scan)) {
				break;
			}
		}
		scan.close();
	}
	
	public static boolean tryAgain(Scanner scan) {
		System.out.println("Enter 1 to try again. Enter another number to quit.");
		int response = scan.nextInt();
		if (response == 1) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void displayCompletionMessage(double score) {
		if (score >= 75) {
			System.out.println("Congratulations, you are ready to go to the next level!");
		}
		else {
			System.out.println("Please ask your teacher for extra help.");
		}
	}

	public static double calculatePercentCorrect(double correct, double questions) {
		double score = (correct / questions)*100;
		return score;
	}
	
	public static boolean isAnswerCorrect(int ans, int num1, int num2) {
		if (ans == num1*num2) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void displayCorrectResponse(int seed) {
		switch(seed){
		case 1:
			System.out.println("Very good!");
			break;
		case 2:
			System.out.println("Excellent!");
			break;
		case 3:
			System.out.println("Nice work!");
			break;
		case 4:
			System.out.println("Keep up the good work!");
			break;
		}
	}
	
	public static void displayIncorrectResponse(int seed) {
		switch(seed){
		case 1:
			System.out.println("No. Please try again.");
			break;
		case 2:
			System.out.println("Wrong. Try once more.");
			break;
		case 3:
			System.out.println("Don't give up!");
			break;
		case 4:
			System.out.println("No. Keep trying.");
			break;
		}
	}
	
	public static int readResponse(Scanner scan) {
		int res = scan.nextInt();
		return res;
	}
	
	public static void askQuestion(int num1, int num2){
		System.out.printf("How much is %d times %d? ", num1, num2);
	}
}


