package dk.easv.bll.shops;

import dk.easv.be.Country;
import dk.easv.bll.ShopFacade;

public abstract class Shop {
    public abstract void placeOrder(ShopFacade facade, String productNumber, int quantity, double unitPrice, Country deliveryCountry, String notificationMail);
}
