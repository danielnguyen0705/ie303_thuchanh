public class Product {
    private String name;
    private String subName;
    private String brand;
    private double price;
    private String description;
    private String imageName;

    public Product(String name, String subName, String brand, double price, String description, String imageName) {
        this.name = name;
        this.subName = subName;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.imageName = imageName;
    }

    public String getName() {
        return name;
    }

    public String getSubName() {
        return subName;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getImageName() {
        return imageName;
    }
}