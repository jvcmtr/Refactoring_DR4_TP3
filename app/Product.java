package app;

public class Product {
    private String name;
    private Double price;

    public Product(String name, Double price){
        if (price <= 0){
            throw new IllegalArgumentException("O Preço de um produto não pode ser igual ou menor que zero");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
