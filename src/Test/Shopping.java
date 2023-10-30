package Test;

 public class Shopping {
	private static class Product {
        private String name;
        private double unitPrice;
        private double gst;
        private int quantity;

        public Product(String name, double unitPrice, double gst, int quantity) {
            this.name = name;
            this.unitPrice = unitPrice;
            this.gst = gst;
            this.quantity = quantity;
        }

        public double calculateTotalPrice() {
            double totalPrice = unitPrice * quantity;
            if (unitPrice >= 500) {
                totalPrice *= 0.95;
            }
            return totalPrice;
        }

        public double calculateGstAmount() {
            return (gst / 100) * unitPrice * quantity;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("Leather wallet", 1100, 18, 1),
            new Product("Umbrella", 900, 12, 4),
            new Product("Cigarette", 200, 28, 3),
            new Product("Honey", 100, 0, 2)
        };

        double maxGstAmount = 0;
        String maxGstProduct = null;
        double totalAmount = 0;

        for (Product product : products) {
            double totalPrice = product.calculateTotalPrice();
            totalAmount += totalPrice;

            double gstAmount = product.calculateGstAmount();
            if (gstAmount > maxGstAmount) {
                maxGstAmount = gstAmount;
                maxGstProduct = product.getName();
            }
        }

      
        System.out.println("Product with the maximum GST amount: " + maxGstProduct);
        System.out.println("GST amount paid for this product: " + maxGstAmount);
        System.out.println("Total amount to be paid to the shopkeeper after discount: " + totalAmount);
    }
}