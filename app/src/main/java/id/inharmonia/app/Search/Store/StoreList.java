package id.inharmonia.app.Search.Store;

public class StoreList {

    private String storeName;
    private String storeAddress;

    public StoreList(String storeName, String storeAddress) {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

}
