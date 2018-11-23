package id.inharmonia.app;

public class ImageTextSubList {

    private int Icon;
    private String Title;
    private String SubTitle;

    public ImageTextSubList(int Icon, String Title, String SubTitle) {
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
