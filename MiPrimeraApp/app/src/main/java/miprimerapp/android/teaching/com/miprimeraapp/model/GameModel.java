package miprimerapp.android.teaching.com.miprimeraapp.model;

public class GameModel {
    private int id;
    private String name;
    private String description;
    private String OfficialWebsiteUrl;
    private String icon;
    private String background;

    public GameModel(){

    }

    public GameModel(int id, String name, String description, String officialWebsiteUrl, String icon, String background) {
        this.id = id;
        this.name = name;
        this.description = description;
        OfficialWebsiteUrl = officialWebsiteUrl;
        this.icon = icon;
        this.background = background;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getOfficialWebsiteUrl() {
        return OfficialWebsiteUrl;
    }

    public String getIcon() {
        return icon;
    }

    public String getBackground() {
        return background;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOfficialWebsiteUrl(String officialWebsiteUrl) {
        OfficialWebsiteUrl = officialWebsiteUrl;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
