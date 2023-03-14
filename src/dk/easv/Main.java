package dk.easv;

import dk.easv.be.Country;
import dk.easv.bll.ShopFacade;
import dk.easv.bll.shops.LocalStore;
import dk.easv.bll.shops.Shop;
import dk.easv.bll.shops.Webshop;

public class Main {
    private ShopFacade facade;

    public static void main(String[] args) {
        ShopFacade facade = new ShopFacade();

        Shop shop = new LocalStore();
        Shop webShop = new Webshop();

        shop.placeOrder(facade,"ABC123", 2, 10, new Country("Denmark", 25), "hbh@easv.dk");
        webShop.placeOrder(facade,"ABC123", 2, 10, new Country("Denmark", 25), "hbh@easv.dk");
    }
}
