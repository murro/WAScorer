import java.util.Scanner;
import java.io.IOException;

//Driver class for WAScorer

public class WADriver {
	
		public static void main(String[] args) throws IOException {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Entere file name: " );
			String file = scanner.nextLine();
			
			WAScorer score1 = new WAScorer(file);
			score1.openAndRead(score1.getFileName());
			System.out.println(score1.getTotalTimes());
			System.out.printf("Completed Score: %.2f\nTotal Score: %.2f\n", score1.getCompletedScore(),  score1.getPerfectScore());
			System.out.printf("Grade - %.2f\n", score1.getCompletedScore() / score1.getPerfectScore());
		}
}