package task.lab_assighment13;

public class Product {
    private int id;
    private String name;
    private double price;
    private String imagelink;

    public Product(int id, String name, double price, String imagelink) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imagelink = imagelink;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public String getImagelink(){
        return imagelink;
    }
}
