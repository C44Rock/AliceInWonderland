package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) {
		
		try (Scanner userInput = new Scanner(System.in)) {
			System.out.println("What word do you want to replace?");
			String wordToReplace = userInput.nextLine();
			System.out.println();
			
			System.out.println("What word do you want to replace " + wordToReplace + " with?");
			String newWord = userInput.nextLine();
			System.out.println();
			
			File searchFile = null;
			
			while (searchFile == null) {
				System.out.println("What file (.txt) would you like to search?");
				String fileName = userInput.nextLine();
				System.out.println();
				
				try {
					searchFile = getFileFromString(fileName);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println();
				}
			}
			
			System.out.print("What is the destination file (.txt) name?");
			String destFileName = userInput.nextLine();
			
			
			
			try(PrintWriter fileOutput = new PrintWriter(destFileName)) {
				
				try(Scanner fileInput = new Scanner(searchFile)) {
					while (fileInput.hasNextLine()) {
						String line = fileInput.nextLine();
						String newLine = line.replaceAll(wordToReplace, newWord);
						fileOutput.println(newLine);
					}
					
				} catch (Exception e){
					e.getMessage();
				}
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
				
	}
	
	private static File getFileFromString(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		
		if (!file.exists()) {
			throw new FileNotFoundException(fileName + " does not exist");
		} else if (!file.isFile()) {
			throw new IllegalArgumentException(fileName + " is not a file");
		}
		
		return file;
	}
	
	

}
