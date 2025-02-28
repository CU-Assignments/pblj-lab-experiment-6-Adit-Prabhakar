import java.util.*;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Optional;

class Product {
    String name;
    String category;
    double price;

    // Constructor
    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Display method
    public void display() {
        System.out.println(name + " (" + category + ") - $" + price);
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        // Creating a list of products
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200),
            new Product("Phone", "Electronics", 800),
            new Product("TV", "Electronics", 1500),
            new Product("Shirt", "Clothing", 50),
            new Product("Shoes", "Footwear", 100),
            new Product("Sneakers", "Footwear", 120),
            new Product("Jacket", "Clothing", 200)
        );

        // Grouping products by category
        Map<String, List<Product>> groupedProducts = products.stream()
                .collect(Collectors.groupingBy(product -> product.category));

        System.out.println("Products grouped by category:");
        groupedProducts.forEach((category, productList) -> {
            System.out.println(category + ": " + productList.stream()
                    .map(p -> p.name)
                    .collect(Collectors.joining(", ")));
        });

        // Finding the most expensive product in each category
        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        product -> product.category,
                        Collectors.maxBy(Comparator.comparingDouble(product -> product.price))
                ));

        System.out.println("\nMost Expensive Product in Each Category:");
        mostExpensiveByCategory.forEach((category, product) ->
            System.out.println(category + ": " + 
                (product.isPresent() ? product.get().name + " - $" + product.get().price : "No products")));

        // Calculating the average price of all products
        double averagePrice = products.stream()
                .collect(Collectors.averagingDouble(product -> product.price));

        System.out.println("\nAverage Price of All Products: $" + averagePrice);
    }
}
