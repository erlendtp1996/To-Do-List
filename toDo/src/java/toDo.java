import java.io.*;
import java.util.*;

//TODO - add documentation
class toDo {
	//TODO - add documentation and make print look pretty
	//ask for due date??
	//if they type exit, then exit
	public static void main(String[] args) 
		throws IOException {
			
		Scanner scanner = new Scanner(System.in);	
		boolean keepAdding = true;
		boolean keepRemoving = true;
		String tempfile, filename, aOrR, needToAdd, needToRemove, task;
		int numTask = 0;
		String filename1 = "C:\\Users\\Thomas\\Dev\\toDoList\\To-Do-List\\toDo\\tasks.txt";
		filename = "\\..\\..\\tasks.txt";

		printCurrentTasks(filename);

		//ask if user if they need to add or remove task
		while (true) {
			System.out.println("Do you need to add or remove a task (a/r) ? Type 'exit' to quit.");
			aOrR = scanner.nextLine();
			if (aOrR.equalsIgnoreCase("a")) {
				System.out.println("Please enter your task: ");
				task = scanner.nextLine();
				write(filename, task);
				printCurrentTasks(filename);
			}
			else if (aOrR.equalsIgnoreCase("r")) {
				System.out.println("Enter the task number to be removed: ");
				try {
					numTask = Integer.parseInt(scanner.nextLine());
				}	
				catch (Exception e) {
					System.out.println("ERROR: Invalid number, ry again");
					System.exit(0);
				}
					removeTask(filename, numTask);
					printCurrentTasks(filename);
				}
			else if (aOrR.equalsIgnoreCase("exit"))
			{
				System.out.println("Goodbye");
				System.exit(0);
			}
			else {
				System.out.println("ERROR: Invalid input, try again");
				System.exit(0);
			}
		}
	}
	
	/*
	 * Writes a task to a file using a BufferedWriter 
	 *
	 * @param filename - the path to the file to be written to
	 * @param task - the task to be written to the file
	 */
	public static void write(String filename, String task) 
		throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
		writer.write(task);
		writer.newLine();
		writer.close();
	}
	
	/*
	 * Reads the file and prints the tasks written to the user 
	 *
	 * @param filename - the path to the file to be read from
	 */
	public static void printCurrentTasks(String filename) 
		throws IOException {
		
		FileInputStream fIn = new FileInputStream(filename);
		BufferedReader input = new BufferedReader(new InputStreamReader(fIn));
		String task = "";
		int counter = 1;
		
		if (input.readLine() == null) {
			System.out.println("YOU HAVE NO CURRENT TASKS!");
		}
		else {
			fIn.getChannel().position(0);
			input = new BufferedReader(new InputStreamReader(fIn));
			System.out.println("/****************************/");
			System.out.println("\tCURRENT TASKS:\n");
			while ((task = input.readLine()) != null)
			{
				System.out.println("\t" + counter++ + ".) " + task);
			}
			System.out.println("\n");
		}
	}
	
	
	/*
	 * Removes the specified task in the file
	 *
	 * @param filename - the path to the file to be read from
	 * @param taskNumber - the number that is printed along with the task
	 */
	public static void removeTask(String filename, int taskNumber)
		throws IOException {
		ArrayList<String> list = new ArrayList<String>();	
		File inputFile = new File(filename);
		BufferedReader read = new BufferedReader(new FileReader(inputFile));
		
		String currLine;
		int counter = 1;
		
		while ((currLine = read.readLine()) != null) {
			if (counter == taskNumber) {
				counter++;
				continue;
			}
			list.add(currLine);
			counter++;
		}	
		read.close();		

		PrintWriter clear = new PrintWriter(filename);
		clear.print("");
		clear.close();
		
		for (int i = 0; i < list.size(); i++) {
			write(filename, list.get(i));
		}
	}
}