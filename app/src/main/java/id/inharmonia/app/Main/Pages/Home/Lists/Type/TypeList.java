package id.inharmonia.app.Main.Pages.Home.Lists.Type;

public class TypeList {

    private String typeName;
    private int typeIcon;
    private Boolean typeEnabled;

    public TypeList(String typeName, int typeIcon, Boolean typeEnabled) {
        this.typeName = typeName;
        this.typeIcon = typeIcon;
        this.typeEnabled = typeEnabled;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getTypeIcon() {
        return typeIcon;
    }

    public Boolean getTypeEnabled() { return typeEnabled; }

}

