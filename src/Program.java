import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        String birthDate = sc.next();

        System.out.println();

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus orderStatus = OrderStatus.valueOf(sc.next());
        System.out.print("How many items to this order? ");
        int orderItemQuantity = sc.nextInt();

        DateTimeFormatter entryDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(birthDate, entryDate);
        System.out.println(date);
        Client client = new Client(name, email, date);
        LocalDateTime orderDate = LocalDateTime.now();
        Order order = new Order(orderDate, orderStatus);

        System.out.println("-----------------");

        for (int i = 1; i <= orderItemQuantity; i++) {
            System.out.printf("Enter #%d item data: %n", i);
            System.out.print("Product name: ");
            String productName = sc.next();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int productQuantity = sc.nextInt();
            System.out.println();

            OrderItem orderItem = new OrderItem(productQuantity, productPrice);

            Product product = new Product(productName, productPrice);
            order.addItem(orderItem);
            orderItem.addProduct(product);

        }

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("-----------------");
        System.out.println("ORDER SUMMARY");
        System.out.println("Order Moment: " + order.getMoment().format(formatter2));
        System.out.printf("Order status: %s %n", orderStatus);
        System.out.printf("Client: %s (%s) - %s %n", client.getName(), client.getBirthDate(), client.getEmail());
        System.out.println("Order items: ");

        double totalValue = 0;
        for (OrderItem orderItem : order.getOrderItems()) {

            for (Product product : orderItem.getProducts()) {
                System.out.printf("%s, $%.2f, Quantity: %d, Subtotal: $%.2f %n",
                        product.getName(), product.getPrice(), orderItem.getQuantity(), orderItem.subTotal());
                totalValue += orderItem.subTotal();
            }
        }
        System.out.println();
        System.out.printf("Total price: %.2f ", totalValue);


        sc.close();

    }
}