package id.inharmonia.app.Cart.Lists.Cart;

public class CartList {

    private String cartName;
    private String cartType;
    private String cartQuantity;

    public CartList(String cartName, String cartType, String cartQuantity) {
        this.cartName = cartName;
        this.cartType = cartType;
        this.cartQuantity = cartQuantity;
    }

    public String getCartName() {
        return cartName;
    }

    public String getCartType() {
        return cartType;
    }

    public String getCartQuantity() {
        return cartQuantity;
    }

}

