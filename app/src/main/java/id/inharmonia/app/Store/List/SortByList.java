package id.inharmonia.app.Store.List;

public class SortByList {

    private String name;
    private int icon;
    private Boolean is_selected;

    public SortByList(String name, int icon, Boolean is_selected) {
        this.name = name;
        this.icon = icon;
        this.is_selected = is_selected;
    }

    public String get_name() {
        return name;
    }

    public int get_icon() {
        return icon;
    }

    public Boolean get_is_selected() { return is_selected; }

}

