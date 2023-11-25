import java.util.*;
import java.util.Scanner;

class Main {
    String name;
    double price;
    double gst;
    int quantity;

 Main(String name, double price, double gst, int quantity) {
        this.name = name;
        this.price = price;
        this.gst = gst;
        this.quantity = quantity;
    }

    double getTotalPrice() {
        return price * quantity;
    }

    double getGSTAmount() {
        return getTotalPrice() * gst / 100;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.println("Enter the number of products:");
        int n = scanner.nextInt();
        scanner.nextLine();  // consume newline left-over

        for (int i = 0; i < n; i++) {
            System.out.println("Enter product name:");
            String name = scanner.nextLine();

            System.out.println("Enter product price:");
            double price = scanner.nextDouble();

            System.out.println("Enter product GST:");
            double gst = scanner.nextDouble();

            System.out.println("Enter product quantity:");
            int quantity = scanner.nextInt();
            scanner.nextLine();  // consume newline left-over

            products.add(new Product(name, price, gst, quantity));
        }

        double totalAmount = 0;
        Product maxGSTProduct = null;
        double maxGST = 0;

        for (Product product : products) {
            double totalPrice = product.getTotalPrice();
            if (totalPrice > 500) {
                totalPrice *= 0.95;  // apply 5% discount
            }
            totalAmount += totalPrice;

            double gstAmount = product.getGSTAmount();
            if (gstAmount > maxGST) {
                maxGST = gstAmount;
                maxGSTProduct = product;
            }
        }

        System.out.println("Total amount for the whole cart: " + totalAmount);
        System.out.println("Product for which we paid more GST amount: " + maxGSTProduct.name);
    }
}