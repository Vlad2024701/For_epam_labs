import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ActionProduct {

    private List<Product> products;

    public ActionProduct(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProductForName(String name){
        return products.stream()
                .filter(product -> Objects.equals(product.getName(), name))
                .collect(Collectors.toList());
    }
    public List<Product> getProductForNameAndMaxPrice(String name, double maxPrice){
        return products.stream()
                .filter(product -> Objects.equals(product.getName(), name) && product.getPrice() < maxPrice)
                .collect(Collectors.toList());
    }
    public List<Product> getProductForMinStorageTime(double minStorageTime){
        return products.stream()
                .filter(product -> product.getStorageTime() > minStorageTime)
                .collect(Collectors.toList());
    }
}
