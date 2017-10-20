// Created by Jorden Burchick
// CPSC 374, Data Structures and Algorithms, Dr. Mullins.
// StackArray.java

import java.util.Arrays;

public class StackArray
{
	private int size = 2;
	private Student theStack[] = new Student[size];
	private int top = -1;
	
	public StackArray()
	{
	}
	
	/* EXTRA CREDIT PORTION */
	public StackArray(int s)
	{
		size = s;
		theStack = Arrays.copyOf(theStack, size);
	}
	
	public StackArray(StackArray S)
	{
		/* Probably not the most efficient way, but we first counted how many nulls were in
		 * the original array, and subtracted that from it's size, giving us how many elements
		 * were in the array. We use this value to create an array of this size. We then went
		 * through the original array and copied any non-nulls into the new array, and copy
		 * the new array to the original. Not even totally sure it works, but it was worth a try.
		 */
		
		int nulls = 0;
		for(int i = 0; i < S.size; i++)
		{
			if(S.theStack[i] == null)
				nulls++;
		}
		int newSize = (S.size - nulls);
		Student newStack[] = new Student[newSize];
		this.size = newSize;
		nulls = 0;
		for(int i = 0; i < S.size; i++)
		{
			if(S.theStack[i] == null)
				nulls++;
			else
				newStack[i - nulls] = S.theStack[i];
		}
		theStack = newStack;
	}
	
	public int size()
	{
		return this.size;
	}
	/* END EXTRA CREDIT PORTION */
	
	public void print()
	{
		for(int i = 0; i < this.size; i++)
		{
			if(theStack[i] == null)
				continue;
			else
				System.out.println(theStack[i]);
		}
	}
	
	public boolean isEmpty()
	{
		return (top == -1);
	}
	
	public boolean isFull()
	{
		return false;
	}
	
	public void push(Student obj)
	{
		if(top == size - 1)
		{
			theStack = Arrays.copyOf(theStack, size*2);
			size *= 2;
		}
		theStack[++top] = obj;
	}
	
	public Student pop() throws Exception
	{
		ArrayIndexOutOfBoundsException ex = new ArrayIndexOutOfBoundsException();
		if(!isEmpty())
			return theStack[top--];
		else
			throw ex;	
	}
}
