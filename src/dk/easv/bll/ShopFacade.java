package dk.easv.bll;

import dk.easv.be.Country;
import dk.easv.be.Order;
import dk.easv.bll.orders.EmailManager;
import dk.easv.bll.orders.PaymentManager;
import dk.easv.bll.orders.PriceManager;
import dk.easv.bll.orders.WarehouseManager;

public class ShopFacade {

    private EmailManager emailManager = new EmailManager();
    private PaymentManager paymentManager = new PaymentManager();
    private WarehouseManager warehouseManager = new WarehouseManager();
    private PriceManager priceManager = new PriceManager();





    public void placeLocalOrder(String productNumber, int quantity, double unitPrice, Country deliveryCountry, String notificationMail) {
        System.out.println("Placing local order. \n");
        Order order = new Order(productNumber, quantity, unitPrice);
        emailManager.sendPaymentReceipt(order, notificationMail);
        paymentManager.withDrawFromCreditCard(order);
        priceManager.calculateVAT(order, deliveryCountry);
        priceManager.calculateTotalPrice(order);
        warehouseManager.orderFromWarehouse(order);
        emailManager.sendOrderConfirmation(order, notificationMail);
        System.out.println("\n");
    }

    public void placeOnlineOrder(String productNumber, int quantity, double unitPrice, Country deliveryCountry, String notificationMail) {
        System.out.println("Placing online order. \n");
        Order order = new Order(productNumber, quantity, unitPrice);
        priceManager.calculateVAT(order, deliveryCountry);
        priceManager.calculateTotalPrice(order);
        paymentManager.withDrawFromCreditCard(order);
        emailManager.sendPaymentReceipt(order, notificationMail);
        warehouseManager.orderFromWarehouse(order);
        emailManager.sendOrderConfirmation(order, notificationMail);
        System.out.println("\n");
    }
}
