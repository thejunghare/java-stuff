package playground;

abstract class Item {
    private String createdBy;

    public Item(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void printTask() {
        System.out.println("Task : ");
    }
}