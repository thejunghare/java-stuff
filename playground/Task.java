package playground;

public class Task extends Item implements Workable {
    private int id;
    private String name;

    public Task(int id, String name, String createdBy) {
        super(createdBy);
        this.id = id;
        this.name = name;
    }

    public String setName(String name) {
        return this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public void printTask() {
        System.out.println("Task : " + getName() + " with id " + getId() + " assigned to " + getCreatedBy());
    }

    @Override
    public void workDone() {
        System.out.println("Task " + id + ": " + name + " is being done by " + getCreatedBy());
    }
}