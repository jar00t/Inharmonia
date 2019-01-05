package id.inharmonia.app.Store.List;

public class StoreList {

    private int id;
    private int picture;
    private String name;
    private String location;
    private int cost;
    private boolean is_free_ongkir;
    private boolean is_favorited;

    public StoreList(int id, int picture, String name, String location, int cost, boolean is_free_ongkir, boolean is_favorited) {
        this.id = id;
        this.picture = picture;
        this.name = name;
        this.location = location;
        this.cost = cost;
        this.is_free_ongkir = is_free_ongkir;
        this.is_favorited = is_favorited;
    }

    public int get_id() {
        return id;
    }

    public int get_picture() {
        return picture;
    }

    public String get_name() {
        return name;
    }

    public String get_location() {
        return location;
    }

    public int get_cost() {
        return cost;
    }

    public boolean get_is_free_ongkir() {
        return is_free_ongkir;
    }

    public boolean get_is_favorited() {
        return is_favorited;
    }
}

