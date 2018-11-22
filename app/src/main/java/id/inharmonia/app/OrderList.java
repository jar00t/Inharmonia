package id.inharmonia.app;

public class OrderList {
    private String orderCode;
    private String orderStatusText;
    private int orderStatusIcon;
    private String storeName;
    private String storeAddress;
    private String buyerName;
    private String buyerAddress;
    private String orderDateTime;

    public OrderList(String orderCode, String orderStatusText, int orderStatusIcon, String storeName, String storeAddress, String buyerName, String buyerAddress, String orderDateTime) {
        this.orderCode = orderCode;
        this.orderStatusText = orderStatusText;
        this.orderStatusIcon = orderStatusIcon;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.buyerName = buyerName;
        this.buyerAddress = buyerAddress;
        this.orderDateTime = orderDateTime;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public int getOrderStatusIcon() {
        return orderStatusIcon;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public String getOrderDateTime() {
        return orderDateTime;
    }
}
