package id.inharmonia.app.Main.Pages.Account.Lists.Menu;

public class Menu {

    private String menuName;
    private int menuIcon;

    public Menu(String menuName, int menuIcon) {
        this.menuName = menuName;
        this.menuIcon = menuIcon;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuIcon() {
        return menuIcon;
    }

}
