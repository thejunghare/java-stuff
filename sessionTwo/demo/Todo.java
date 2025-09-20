//Model -> strcuture of our database
package demo;

public class Todo extends Items {
    int age;
    private int id;
    private String name;

//    public Todo(){
//
//
//    }

    public Todo(int id, String name, String assignedBy) {
        super(assignedBy);
        this.id = id;
        this.name = name;
    }

    // defined getters and setter

    // 2 set method
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 2 get method
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void getInfoOfTodo() {
        System.out.println("Your todo with " + getId() + " is " + getName() + " assigned by " + getAssignedBy());
    }

}