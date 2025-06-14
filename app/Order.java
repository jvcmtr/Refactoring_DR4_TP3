package app;

import java.util.*;

public class Order {
    public Client client;
    private HashMap<Product, Integer> products = new HashMap<>();

    public double discountRate = 0.1;

    public Order(Client client){
        this.client = client;
    }

    public void printInvoice() {
        var total = 0;
        System.out.println("Cliente: " + client.getName());

        for( var entry : products.entrySet()){
            var product = entry.getKey();
            var ammount = entry.getValue();
            System.out.println(ammount + "x " + product.getName() + " - R$" + product.getPrice());
            total += ammount * product.getPrice();
        }

        System.out.println("Subtotal: R$" + total);
        System.out.println("Desconto: R$" + (total * discountRate));
        System.out.println("Total final: R$" + (total * (1 - discountRate)));
    }

    public Order addProduct(Product p){
        var ammount = products.getOrDefault(p, 0);
        products.put(p, ammount + 1);
        return this;
    }

    public Order addProduct(Product p, int ammount){
        if (ammount < 0){
            throw new IllegalArgumentException("O Numero de produtos deve ser maior do que zero");
        }

        var currentAmmount = products.getOrDefault(p, 0);
        products.put(p, currentAmmount + ammount);
        return this;
    }

    public List<Product> getProducts(){
        List<Product> result = new ArrayList<>();
        
        for( var entry : products.entrySet()){
            var product = entry.getKey();
            var ammount = entry.getValue();

            for (int i = 0; i < ammount; i++) {
                result.add(product);
            }
        }
        return result;
    }

    public void sendEmail() {
        EmailService.sendEmail(client.getEmail(), "Pedido recebido! Obrigado pela compra.");
    }
}