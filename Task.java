import java.util.*;
enum Types {
    HEART,
    CLUBS,
    DIAMONDS,
    SPADES;
}

public class Task implements Comparable<Task> {
    private final String name;
    private final String status;
    private final String priority;
    private final Types type;

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getPriority() {
        return priority;
    }

    public Types getType() {
        return type;
    }

    public Task(String name, String status, String priority, Types type) {
        if (status == null ||  priority == null)
            throw new NullPointerException();
        this.name = name;
        this.status = status;
        this.priority = priority;
        this.type = type;
    }

    public String toString() {
        Random n = new Random();
        n.nextInt();
	    return name + " " + status + " " + priority;
    }

    public int compareTo(Task n) {
        int lastCmp = priority.compareTo(n.priority);
        return (lastCmp != 0 ? lastCmp : status.compareTo(n.status));
    }

    public static void main(String[] args) {
        Task taskArray[] = {
            new Task("Cisco", "Progress", "1", Types.CLUBS),
            new Task("Boeing", "Completed", "3", Types.DIAMONDS),
            new Task("Apple", "Queued", "2", Types.SPADES),
            new Task("Yahoo", "Progress", "4", Types.CLUBS),
            new Task("Google", "Queued", "0", Types.SPADES),
            new Task("MS", "Completed", "5", Types.DIAMONDS),
            
        };

        List<Task> tasks = Arrays.asList(taskArray);
        System.out.println("Sort them by name");
        Collections.sort(tasks, new NameComparator());
        System.out.println(tasks);

        System.out.println("*******************");
        System.out.println("Sort them by status");
        Collections.sort(tasks, new StatusComparator());
        System.out.println(tasks);

        System.out.println("*******************");
        System.out.println("Sort them by priority");
        Collections.sort(tasks, new PriorityComparator());
        System.out.println(tasks);

        System.out.println("*******************");
        System.out.println("Sort them by priority");
        Collections.sort(tasks, new ColorComparator());
        System.out.println(tasks);
    }
}

class NameComparator implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) {
        return t1.getName().compareTo(t2.getName());
    }
}

class StatusComparator implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) {
        return t1.getStatus().compareTo(t2.getStatus());
    }
}

class PriorityComparator implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) {
        return t1.getPriority().compareTo(t2.getPriority());
    }
}

class ColorComparator implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) {
        return t1.getType().compareTo(t2.getType());
    }
}