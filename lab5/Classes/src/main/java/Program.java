import java.util.Arrays;
import java.util.List;

public class Program {

    private static List<Product> products = Arrays.asList(
            new Product(1,  "молоко", 123456789012L, "Брест-литовск", 2.10, 20, 100),
            new Product(2,  "сметана", 234567890123L, "Брест-литовск", 2.80, 20, 150),
            new Product(3,  "кефир", 345678901234L, "Брест-литовск", 1.70, 20, 200),
            new Product(4,  "масло", 456789012345L, "Брест-литовск", 3.50, 50, 140),
            new Product(5,  "конфеты", 567890123456L, "Комунарка", 0.50, 200, 1000),
            new Product(6,  "шоколад", 678901234567L, "Комунарка", 3.20, 150, 800),
            new Product(7,  "торт", 789012345678L, "Комунарка", 15.60, 30, 80),
            new Product(8,  "булочка", 890123456789L, "Брестский пекарь", 0.80, 10, 300),
            new Product(9,  "хлеб", 901234567890L, "Брестский пекарь", 1.20, 12, 180),
            new Product(10, "батон", 112345678901L, "Брестский пекарь", 1.10, 9, 240),
            new Product(11, "пельмени", 340124567890L, "Дзержинский мясокомбинат", 3.50, 200, 2000),
            new Product(12,  "булочка", 567890123456L, "Комунарка", 0.90, 15, 400)
    );

    public static void main(String[] args) {
        ActionProduct actionProduct = new ActionProduct(products);
        System.out.println("Получить список товаров для <булочка>:");
        actionProduct.getProductForName("булочка").forEach(System.out::println);
        System.out.println("\nПолучить список товаров для <булочка> не превосходящих цену в 0.85 BYN:");
        actionProduct.getProductForNameAndMaxPrice("булочка", 0.85).forEach(System.out::println);
        System.out.println("\nПолучить список товаров, где срок хранения не превосходит 20 дней");
        actionProduct.getProductForMinStorageTime(20).forEach(System.out::println);
    }
}
