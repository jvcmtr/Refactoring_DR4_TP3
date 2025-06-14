package app;


public class App {
    public static void main(String[] args) {

        var client = new Client("João", "joao@email.com");

        var notebook = new Product("Notebook", 3500.0);
        var mouse = new Product("Mouse", 80.0);

        var pedido = new Order(client)
            .addProduct(notebook)
            .addProduct(mouse, 2);

        pedido.printInvoice();
        pedido.sendEmail();
    }
}