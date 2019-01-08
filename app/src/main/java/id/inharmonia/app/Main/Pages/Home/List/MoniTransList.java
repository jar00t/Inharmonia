package id.inharmonia.app.Main.Pages.Home.List;

public class MoniTransList {

    private String name;
    private int icon;
    private Boolean is_enabled;

    public MoniTransList(String name, int icon, Boolean is_enabled) {
        this.name = name;
        this.icon = icon;
        this.is_enabled = is_enabled;
    }

    public String get_name() {
        return name;
    }

    public int get_icon() {
        return icon;
    }

    public Boolean get_is_enabled() { return is_enabled; }

}
