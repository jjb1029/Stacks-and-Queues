// Created by Jorden Burchick
// CPSC 374, Data Structures and Algorithms, Dr. Mullins.
// FileProcessor.java

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileProcessor
{
	public FileProcessor(String fileName, StackArray stack)
	{
		try
		{
			String firstName, lastName;
			int age;
			double gpa;
			
			File file = new File(fileName); 
			Scanner src = new Scanner(file);
			src.useDelimiter(",|\r\n|\n");

			while(src.hasNext())
			{
				lastName = src.next();
				firstName = src.next();
				age = src.nextInt();
				gpa = src.nextDouble();
				Student st = new Student(lastName, firstName, gpa, age);
				stack.push(st);
			}
			
			src.close();
		}
		catch(FileNotFoundException ex)
		{
			System.err.println("File " + fileName + " not found");
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			System.err.println("Too many data values.");
		}
		catch(InputMismatchException ex)
		{
			System.err.println("Data type conflicts.");
		}
		catch(NoSuchElementException ex)
		{
			System.err.println("No more elements.");
		}
	}
}