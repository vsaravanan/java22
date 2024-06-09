package console.collection;

/**
 * @author Sarav on 09 Jun 2024
 * @project govtech
 * @package console.collection
 * @class PriorityQueueExample
 */
import java.util.PriorityQueue;

// https://raw.githubusercontent.com/vsaravanan/java22/master/src/main/java/console/collection/PriorityQueueExample.java

class Task implements Comparable<Task> {
    private String name;
    private int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }
}

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Create a PriorityQueue
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();

        // Add tasks to the queue
        taskQueue.add(new Task("Write report", 2));
        taskQueue.add(new Task("Attend meeting", 1));
        taskQueue.add(new Task("Complete assignment", 3));

        // Process tasks in priority order
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            System.out.println("Processing task: " + task);
        }
    }
}

