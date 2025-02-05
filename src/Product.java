
public class Product {
    private int id;
    private String gender;
    private String category;
    private String product_name;
    private String size;
    private int shoe_size;
    private int price;

    public Product(int id, String gender, String category, String product_name, String size, int shoe_size, int price) {
        this.id = id;
        this.gender = gender;
        this.category = category;
        this.product_name = product_name;
        this.size = size;
        this.shoe_size = shoe_size;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getShoe_size() {
        return shoe_size;
    }

    public void setShoe_size(int shoe_size) {
        this.shoe_size = shoe_size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
