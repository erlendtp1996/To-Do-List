import java.io.*;
import java.util.*;

class toDo {
	public static void main(String[] args) 
		throws IOException {
		Scanner scanner = new Scanner(System.in);	
		boolean keepAdding = true;
		String filename, needToAdd, task;
		filename = "C:\\Users\\Thomas\\Dev\\toDoList\\To-Do-List\\toDo\\tasks.txt";

		printCurrentTasks(filename);
		
		while (keepAdding) {
			System.out.println("Do you need to add a task (y/n) ?");
			needToAdd = scanner.nextLine();
			if (needToAdd.equalsIgnoreCase("y")) {
				System.out.println("Please enter your task: ");
				task = scanner.nextLine();
				write(filename, task);
				printCurrentTasks(filename);
			}
			else {
				System.out.println("\n\n\n");
				System.out.println("\t<<Bye>>");
				System.out.println("\n\n\n");
				keepAdding = false;
			}
		}
		/*
		Scanner scan = new Scanner(System.in);
		String task;
		
		System.out.println("Please input a task: ");
		task = scan.nextLine();
		System.out.println(task);
		*/
		
		/*
		String task, filename;
		task = "hello world";
		write(filename, task);
		read(filename);
		*/
	}
	
	public static void write(String filename, String task) 
		throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		writer.write(task);
		writer.close();
	}
	
	public static void read(String filename)
		throws IOException {
			
		BufferedReader input = new BufferedReader(new FileReader(filename));
		
		if (input.readLine() == null) {
			System.out.println("YOU HAVE NO CURRENT TASKS!");
		}
		else {
					//readin line in if statement in then reads null
					input.reset();
					String line = input.readLine();
					System.out.println("CURRENT TASKS: ");
					System.out.println(line);
		}
	
		input.close();
	}
	
	public static void printCurrentTasks(String filename) 
		throws IOException {
		
		BufferedReader input = new BufferedReader(new FileReader(filename));
		
		if (input.readLine() == null) {
			System.out.println("YOU HAVE NO CURRENT TASKS!");
		}
		else {
					String line = input.readLine();
					System.out.println("CURRENT TASKS: ");
					System.out.println(line);
		}
	
		input.close();
	}
}