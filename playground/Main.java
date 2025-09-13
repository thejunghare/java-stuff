/*
 1. class
 2. object -> use to access attributes and methods
 3. attributes -> variable in class
 4. this -> refer to varibale in object
 5. constructor
 6. method -> public vs static
 7. modifiders -> public (accessible in all/across packages), private (accessible in within declared class), default (accessible in same package), protected (accessible in same package and subclasses)
 8. Encapsulation -> hiding sensitive data.
 */

package playground;

public class Main {
    int age;

    Boolean isElgible;

    public Main(Boolean isElgible, int age) {
        this.age = age;
        this.isElgible = isElgible;
    }

    public Main(Boolean isElgible) {
        this(isElgible, 19);
    }

    // methodß
    static int sumOfAge() {
        Main obj = new Main(false);
        System.out.println("Age before 10 years : " + obj.age);
        return obj.age + 10;
    }

    public int sum() {
        return this.age + 10;
    }

    public static void main(String[] agrs) {
        Main obj = new Main(true);

        Task newTask = new Task(1, "Submit assigment", "prasad");
        //Task newTask = new Task();
        //newTask.setName("Submitted assigment!");
        // System.out.println(newTask.getName());
        //System.out.println(newTask.getCreatedBy());
        newTask.printTask();
        newTask.workDone();

        System.out.println(obj.isElgible);
        sumOfAge();
        System.out.println("Age after 10 years : " + obj.sum());
    }
}