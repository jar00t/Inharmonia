package id.inharmonia.app.Main.Pages.Home.Lists.Type;

public class TypeList {
    private String typeName;
    private int typeIcon;

    public TypeList(String typeName, int typeIcon) {
        this.typeName = typeName;
        this.typeIcon = typeIcon;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getTypeIcon() {
        return typeIcon;
    }
}

