package id.inharmonia.app.Cart.Lists.Cart;

public class CartList {

    private String cartId;
    private String cartName;
    private String cartType;
    private String cartQuantity;
    private Boolean cartSelected;

    public CartList(String cartId, String cartName, String cartType, String cartQuantity, Boolean cartSelected) {
        this.cartId = cartId;
        this.cartName = cartName;
        this.cartType = cartType;
        this.cartQuantity = cartQuantity;
        this.cartSelected = cartSelected;
    }

    public String getCartId() { return cartId; }

    public String getCartName() {
        return cartName;
    }

    public String getCartType() {
        return cartType;
    }

    public String getCartQuantity() {
        return cartQuantity;
    }

    public Boolean getCartSelected() { return cartSelected; }

    public void setCartSelected(Boolean cartSelected) {
        this.cartSelected = cartSelected;
    }

}

