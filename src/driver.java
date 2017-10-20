// Created by Jorden Burchick
// CPSC 374, Data Structures and Algorithms, Dr. Mullins.
// driver.java

public class driver
{
	public static void main(String[] args)
	{
		StackArray stack1 = new StackArray();
		StackArray stack1Copy = new StackArray();
		FileProcessor fileX = new FileProcessor("set2/data1.txt", stack1);
		FileProcessor fileY = new FileProcessor("set2/data1.txt", stack1Copy);
		
		System.out.println("Driver_App says: Popping twice:");
		try
		{
			for(int i = 0; i < 2; i++)
			{
				System.out.println(stack1.pop());
				stack1Copy.pop();
			}	
		}
		catch (ArrayIndexOutOfBoundsException ex)
		{
			System.out.print("Driver_App says: ");
			System.err.println("!! ATTEMPT TO POP AN EMPTY STACK !!");
		}
		catch (Exception ex)
		{
			System.err.println("Something happened.");
		}
		
		FileProcessor newFile = new FileProcessor("set2/data2.txt", stack1);
		FileProcessor anotherNewFile = new FileProcessor("set2/data2.txt", stack1Copy);
		
		try
		{
			System.out.println("Driver_App says: Popping five times:");
			for(int i = 0; i < 5; i++)
			{
				System.out.println(stack1.pop());
				stack1Copy.pop();
			}
		}
		catch (ArrayIndexOutOfBoundsException ex)
		{
			System.out.print("Driver_App says: ");
			System.err.println("!! ATTEMPT TO POP AN EMPTY STACK !!");
		}
		catch (Exception ex)
		{
			System.err.println("Something happened.");
		}
		
		/* Couldn't really figure out how to copy a stack to make another stack without
		 * utilizing a copy constructor. We thought about popping values off of the stack
		 * and into a new one (then popping those onto another to get correct order), 
		 * but then the first stack would be empty. So, instead, we just
		 * made two stacks to start with, put in the same data, and performed the same
		 * operations on both of them. Obviously not the best solution.
		 */
		try
		{
			System.out.println("Driver_App says: Remaining on first stack");
			while(!stack1.isEmpty())
			{
				
				System.out.println(stack1.pop());
			}
		}
		catch (ArrayIndexOutOfBoundsException ex)
		{
			System.out.print("Driver_App says: ");
			System.err.println("!! ATTEMPT TO POP AN EMPTY STACK !!");
		}
		catch (Exception ex)
		{
			System.err.println("Something happened.");
		}
		
		FileProcessor data3 = new FileProcessor("set2/data3.txt", stack1Copy);

		try
		{
			System.out.println("Driver_App says: Remaining on second stack");
			while(!stack1Copy.isEmpty())
			{
				System.out.println(stack1Copy.pop());
			}
		}
		catch (ArrayIndexOutOfBoundsException ex)
		{
			System.out.print("Driver_App says: ");
			System.err.println("!! ATTEMPT TO POP AN EMPTY STACK !!");
		}
		catch (Exception ex)
		{
			System.err.println("Something happened.");
		}
		
		
		System.out.print("\n\n\nEXTRA CREDIT TESTING AREA\n");
		// extra credit testing
		StackArray sizedSt = new StackArray(10);
		FileProcessor sizedFP= new FileProcessor("dataAll.txt", sizedSt);
		sizedSt.print();
		System.out.println(sizedSt.size());
		StackArray copiedSt = new StackArray(sizedSt);
		copiedSt.print();
		System.out.println(copiedSt.size());				
	}
}
