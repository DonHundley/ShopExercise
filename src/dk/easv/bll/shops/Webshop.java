package dk.easv.bll.shops;

import dk.easv.be.Country;
import dk.easv.be.Order;
import dk.easv.bll.ShopFacade;
import dk.easv.bll.orders.EmailManager;
import dk.easv.bll.orders.PaymentManager;
import dk.easv.bll.orders.PriceManager;
import dk.easv.bll.orders.WarehouseManager;

public class Webshop extends Shop {


    @Override
    public void placeOrder(ShopFacade facade, String productNumber, int quantity, double unitPrice, Country deliveryCountry, String notificationMail) {
        facade.placeOnlineOrder(productNumber, quantity, unitPrice, deliveryCountry, notificationMail);
    }
}
