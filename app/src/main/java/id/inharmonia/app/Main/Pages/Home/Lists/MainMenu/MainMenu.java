package id.inharmonia.app.Main.Pages.Home.Lists.MainMenu;

public class MainMenu {

    private String menuName;
    private int menuIcon;
    private Boolean menuEnabled;

    public MainMenu(String menuName, int menuIcon, Boolean menuEnabled) {
        this.menuName = menuName;
        this.menuIcon = menuIcon;
        this.menuEnabled = menuEnabled;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuIcon() {
        return menuIcon;
    }

    public Boolean getMenuEnabled() { return menuEnabled; }

}
