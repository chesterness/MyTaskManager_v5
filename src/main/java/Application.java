import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Task task = new Task();
        task.load();
        boolean exit = false;
        System.out.println("Welcome to your task manager!\nInput the number of the action that you would like to perform");
        do {
            System.out.println("1. Display your tasks\n2. Add a task\n3. Save\n4. Mark task as done\n5. Clear\n6. Exit");
            int read = scnr.nextInt();
            switch (read) {
                case 1:
                    System.out.println("Your tasks:");
                    task.displayTasks();
                    break;
                case 2:
                    System.out.println("Write your task below");
                    String addedTask = scnr.nextLine() + scnr.nextLine();
                    task.addTask(addedTask);
                    System.out.println("Your task has been added");
                    break;
                case 3:
                    task.save();
                    task.load();
                    System.out.println("Your task list has been saved");
                    break;
                case 4:
                    task.displayTasks();
                    System.out.println("Which task would you like to mark as done? Input it's number");
                    int taskNumber = scnr.nextInt();
                    task.markDone(taskNumber);
                    break;
                case 5:
                    task.clear();
                    System.out.println("Your task list has been cleared");
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    exit = true;
            }
        } while(!exit);
        scnr.close();
    }
}
