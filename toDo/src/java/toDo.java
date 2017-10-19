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
		String filename, needToAdd, needToRemove, task;
		int numTask;
		filename = "C:\\Users\\Thomas\\Dev\\toDoList\\To-Do-List\\toDo\\tasks.txt";

		printCurrentTasks(filename);

		//ask if user if they need to add or remove task
		while (true) {
			while (keepAdding) {
				System.out.println("Do you need to add a task (y/n) ?");
				needToAdd = scanner.next();
				if (needToAdd.equalsIgnoreCase("y")) {
					System.out.println("Please enter your task: ");
					task = scanner.nextLine();
					write(filename, task);
					printCurrentTasks(filename);
				}
				else if (needToAdd.equalsIgnoreCase("n")) {
					keepAdding = false;
				}
				else {
					System.out.println("ERROR: Invalid input, try again");
					System.exit(0);
				}
			}

			while (keepRemoving) {
				System.out.println("Do you need to remove a task (y/n) ?");
				needToRemove = scanner.next();
				if (needToRemove.equalsIgnoreCase("y")) {
					System.out.println("Enter the task number to be removed: ");
					try {
						numTask = scanner.nextInt();
						removeTask(filename, numTask);
						printCurrentTasks(filename);
					}
					catch (Exception e) {
						System.out.println("ERROR: Invalid number, ry again");
						System.exit(0);
					}
				}
				else if (needToRemove.equalsIgnoreCase("n")) {
					keepRemoving = false;
				}
				else {
					System.out.println("ERROR: Invalid input, try again");
					System.exit(0);
				}
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
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		writer.write(task);
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
				System.out.println("\t" + counter + ".) " + task);
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
	{
	}
}