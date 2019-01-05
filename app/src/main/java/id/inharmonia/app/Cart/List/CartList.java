package id.inharmonia.app.Cart.List;

public class CartList {

    private String id;
    private String name;
    private String type;
    private String quantity;
    private Boolean is_selected;

    public CartList(String id, String name, String type, String quantity, Boolean is_selected) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.is_selected = is_selected;
    }

    public String get_id() { return id; }

    public String get_name() {
        return name;
    }

    public String get_type() {
        return type;
    }

    public String get_quantity() {
        return quantity;
    }

    public Boolean get_is_selected() { return is_selected; }

    public void set_is_selected(Boolean is_selected) {
        this.is_selected = is_selected;
    }

}

