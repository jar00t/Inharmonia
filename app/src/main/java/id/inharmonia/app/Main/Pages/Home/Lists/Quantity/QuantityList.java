package id.inharmonia.app.Main.Pages.Home.Lists.Quantity;

public class QuantityList {

    private String sizeName;
    private String sizeTotal;

    public QuantityList(String sizeName, String sizeTotal) {
        this.sizeName = sizeName;
        this.sizeTotal = sizeTotal;
    }

    public String getSizeName() {
        return sizeName;
    }

    public String getSizeTotal() {
        return sizeTotal;
    }

}
