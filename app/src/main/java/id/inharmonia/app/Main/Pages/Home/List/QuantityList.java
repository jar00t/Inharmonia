package id.inharmonia.app.Main.Pages.Home.List;

public class QuantityList {

    private String name;
    private String total;

    public QuantityList(String name, String total) {
        this.name = name;
        this.total = total;
    }

    public String get_name() {
        return name;
    }

    public String get_total() {
        return total;
    }

}
