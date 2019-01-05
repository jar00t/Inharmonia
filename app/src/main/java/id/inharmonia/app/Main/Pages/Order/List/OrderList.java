package id.inharmonia.app.Main.Pages.Order.List;

public class OrderList {

    private String code;
    private String status_text;
    private int status_icon;
    private String store_name;
    private String store_address;
    private String buyer_name;
    private String buyer_address;
    private String date_time;

    public OrderList(String code, String status_text, int status_icon, String store_name, String store_address, String buyer_name, String buyer_address, String date_time) {
        this.code = code;
        this.status_text = status_text;
        this.status_icon = status_icon;
        this.store_name = store_name;
        this.store_address = store_address;
        this.buyer_name = buyer_name;
        this.buyer_address = buyer_address;
        this.date_time = date_time;
    }

    public String get_code() {
        return code;
    }

    public String get_status_text() {
        return status_text;
    }

    public int get_status_icon() {
        return status_icon;
    }

    public String get_store_name() {
        return store_name;
    }

    public String get_store_address() {
        return store_address;
    }

    public String get_buyer_name() {
        return buyer_name;
    }

    public String get_buyer_address() {
        return buyer_address;
    }

    public String get_date_time() {
        return date_time;
    }

}
