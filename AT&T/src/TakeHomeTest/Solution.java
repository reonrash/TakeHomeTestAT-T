package TakeHomeTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class Solution {

	public static void main(String[] args) throws ParseException, FileNotFoundException {
		
		// Read file and convert text into an array of books 
		// Pass that array into findestOldestBookByMostPublishedAuthor and print result
		
		File file = new File("src/input.txt");
		Scanner scan = new Scanner(file);
		List<String> books = new ArrayList<>();
		while (scan.hasNextLine()) {
			books.add(scan.nextLine());
		}
		String solution = findOldestBookByMPAuthor(books);
		System.out.println(solution);
	}
	
	public static String findOldestBookByMPAuthor(List<String> books) throws ParseException {
		// Keep track of each authors book count and increment when indexed 
		// Check if author's book count is greater than max if it is swap
		// For each author's book check if it older than their currOldest book and swap the date and currOldest Book in maps if it is 
		Map<String, Integer> bookCount = new HashMap<>();
		Map<String, String> oldestBookDate = new HashMap<>();
		Map<String, String> oldestBook = new HashMap<>();
		Map<String, String> authorToGenre = new HashMap<>();
		authorToGenre.put("Steven King", "Horror");
		authorToGenre.put("Rudyard Kipling", "Adventure");
		authorToGenre.put("Isaac Asimov", "Science Fiction");
		authorToGenre.put("Suzanne Collins", "YA Fiction");
		if (books.size() == 0) {
			return "";
		}
		String[] firstBook = books.get(0).split(",");
		String mostPublishedAuthor = firstBook[2];
		int maxCount = 1;
		for (String book: books) {
			String[] info = book.split(",");
			String date = info[1];
			String author = info[2];	
			if (!authorToGenre.containsKey(author)) {
				continue;
			}
			if (bookCount.containsKey(author)) {
				int currCount = bookCount.get(author) + 1;
				if (currCount > maxCount) {
					maxCount = currCount;
					mostPublishedAuthor = author;
				}
				bookCount.put(author, currCount);
				String prevDate = oldestBookDate.get(author);
				if (beforeDate(date, prevDate)) {
					oldestBookDate.put(author, date);
					oldestBook.put(author, book);	
				}
			} else {
				bookCount.put(author, 1);
				oldestBookDate.put(author, date);
				oldestBook.put(author, book);
			}
		}
		String oldestBookByMostPublishedAuthor = oldestBook.get(mostPublishedAuthor);
		String[] info = oldestBookByMostPublishedAuthor.split(",");
		String title = info[0];
		String date = info[1];
		String author = info[2];
		String length = info[3];
		String genre = authorToGenre.get(author);
		String output = title + ", written by " + genre + " writer " + author + " on " + date + " is " + length + " pages long.";
		
		return output;
	}
	
	public static boolean beforeDate(String a, String b) throws ParseException  {
		Date dateA = new SimpleDateFormat("MM/dd/yyyy").parse(a);
		Date dateB = new SimpleDateFormat("MM/dd/yyyy").parse(b);  
		if (dateA.before(dateB)) {
			return true;
		} 
		return false;
	}

}
