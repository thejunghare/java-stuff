package demo;

public class Main {
    int age = 24;

    static void sayHello() {
        System.out.println("Hello");
    }

    public void sayGoodMorning() {
        System.out.println("Good Morning");
    }

    public static void main(String[] args) {
        // public method needs a object be called
        Main obj = new Main();
        //obj.sayGoodMorning();

        // static - we don't need any object
        //sayHello(); // Hello

        Todo firstTodo = new Todo(1, "See your java projects", "Prasad");
        firstTodo.getInfoOfTodo();

        Todo secondTodo = new Todo(2, "Learn Java", "Prasad");

       secondTodo.getInfoOfTodo();

    }
}