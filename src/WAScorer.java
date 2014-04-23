/*
	WAScorer  - Small java program that will take copied text from a webassign assignment report and parse the values
	The following results are prepared:
		completed score
		total score
		average score
		
	More features can be added but for now, this program will open a data.txt file a just get some values.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class WAScorer {
	/*
		Steps to solve : 1) Open file ; 2) Read file ; 3) Parse lines ; 4) Save results ; 5) Calculate results ; 6) Report
		User should be able to just copy the website grade report, paste it and just run the program
	*/
	
	static BufferedReader br;
	static float completedScore, perfectScore;
	static int totalTimes;
	
	public static void openAndRead(String file) throws IOException {
	//Method will first open a file and read line by line
	//Till we can determine how to parse the data
		String line;
		int count = 1;
			//Read the file if the count mod 3 == 0 (no remainder, in this case the 3rd line) print the line. Should always be the score.
		try {
			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {
				if (count % 3 == 0) {
					String[] splitLine;
					//Split the string here and send to parse
					parseLine(splitLine = line.split("\\s+"));
					//System.out.println(line);
				}
				count++;
			}
			System.out.println(count);
		} catch (IOException e) {
			System.out.println("IOExcetion: " + e);
		} finally {
			if (br.readLine() != null) {
				br.close();
                        }
		}       
	}
	
	public static void parseLine(String[] currentLine) {
		//Set some guidelines to handle scores of 0
		//0 is in index 1 so if value of index 1 is 0, we print that instead
		totalTimes++;
		if (String.valueOf(currentLine[1]).equals("0")) {
			System.out.println(currentLine[1]);
		} else {
			System.out.println(currentLine[1] + " " + currentLine[4]);
			completedScore+=Double.parseDouble(currentLine[1]);
			perfectScore+=Double.parseDouble(currentLine[4]);
		}	
	}
	
	

	public static void main(String[] args) throws IOException {
		//File will be determined here
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Entere file name: " );
		String file = scanner.nextLine();
		
		openAndRead(file);
		System.out.println(totalTimes);
		System.out.printf("Completed Score: %.2f\nTotal Score: %.2f\n", completedScore,  perfectScore);
		System.out.printf("Grade - %.2f\n", completedScore / perfectScore);
	
	}
}