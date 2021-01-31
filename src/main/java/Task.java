import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task {
    public List<String> taskList = new ArrayList<String>();
    String filepath = "taskData.txt";

    public void displayTasks() {
        int number = 0;
        for (int index = 0; index<taskList.size(); index++){
            number = index+1;
            System.out.println(number + ". " + taskList.get(index));
            number++;
        }
        System.out.println("------------");
    }
    public void addTask(String task){
        taskList.add(task);
    }
    public void save(){
        try {
            FileOutputStream writer = new FileOutputStream(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DiskIO.writeToFile(filepath, taskList, true);
    }

    public void load(){
        try {
            taskList = DiskIO.readFromFile(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void markDone(int taskNumber){
        int index = taskNumber - 1;
        taskList.remove(index);
        try {
            FileOutputStream writer = new FileOutputStream(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.save();
        System.out.println("Your task was marked as done, good job!");
    }

    public void clear(){
        try {
            FileOutputStream writer = new FileOutputStream(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.load();
    }
}
