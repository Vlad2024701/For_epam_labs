
public class Product {
    private int id;
    private String name;
    private long upc;
    private String manufacturer;
    private double price;
    private int storageTime;
    private int count;

    public Product(int id, String name, long upc, String manufacturer, double price, int storageTime, int count) {
        this.id = id;
        this.name = name;
        this.upc = upc;
        this.manufacturer = manufacturer;
        this.price = price;
        this.storageTime = storageTime;
        this.count = count;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getUpc(){
        return upc;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public int getStorageTime() {
        return storageTime;
    }


    public int getCount() {
        return count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUpc(long upc) {
        this.upc = upc;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStorageTime(int storageTime) {
        this.storageTime = storageTime;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Product{" +
                " Id=" + id +
                ", Наименование- '" + name + '\'' +
                ", UPC= " + upc +
                ", Производитель= '" + manufacturer + '\'' +
                ", Цена= " + price + " BYN" +
                ", Срок хранения= " + storageTime + " дней" +
                ", Количество= " + count +
                " }";
    }
}
