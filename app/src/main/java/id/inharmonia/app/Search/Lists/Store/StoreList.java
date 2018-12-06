package id.inharmonia.app.Search.Lists.Store;

public class StoreList {

    private int Icon;
    private String Title;
    private String SubTitle;

    public StoreList(int Icon, String Title, String SubTitle) {
        this.Icon = Icon;
        this.Title = Title;
        this.SubTitle = SubTitle;
    }

    public int getIcon() {
        return Icon;
    }

    public String getTitle() {
        return Title;
    }

    public String getSubTitle() {
        return SubTitle;
    }

}

