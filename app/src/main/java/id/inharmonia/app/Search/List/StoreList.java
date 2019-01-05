package id.inharmonia.app.Search.List;

public class StoreList {

    private String name;
    private String address;

    public StoreList(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String get_name() {
        return name;
    }

    public String get_address() {
        return address;
    }

}
