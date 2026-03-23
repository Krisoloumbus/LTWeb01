package vn.iotstart.models;

public class Product {
    private long id;
    private String name;
    private String description;
    private double price;
    private String img;
    private long categoryId;
    private long sellerId;
    private int amount;
    private int stock;
    public Product() {}

    public Product(long id, String name, String description, double price,
                   String img, long categoryId, long sellerId,
                   int amount, int stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.img = img;
        this.categoryId = categoryId;
        this.sellerId = sellerId;
        this.amount = amount;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
