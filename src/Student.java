// Created by Jorden Burchick
// CPSC 374, Data Structures and Algorithms, Dr. Mullins.
// Student.java

public class Student
{
	String fName, lName;
	double gpa;
	int age;

	public Student()
	{ }
	
	public Student(String l, String f, double g, int a)
	{ 
		lName = l;
		fName = f;
		gpa = g;
		age = a;
	}
	
	public String toString()
	{
		return age + " " + gpa + " " + fName + " " + lName;
	}
}
