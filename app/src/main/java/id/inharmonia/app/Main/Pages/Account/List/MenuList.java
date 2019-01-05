package id.inharmonia.app.Main.Pages.Account.List;

public class MenuList {

    private String name;
    private int icon;

    public MenuList(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    public String get_name() {
        return name;
    }

    public int get_icon() {
        return icon;
    }

}
