package miprimerapp.android.teaching.com.miprimeraapp.model;

public class GameModel {
    private int id;
    private String name;
    private String description;
    private String OfficialWebsiteUrl;
    private int iconDrawable;
    private int backgroundDrawble;

    public GameModel(int id, String name, String description, String officialWebsiteUrl, int iconDrawable, int backgroundDrawble) {
        this.id = id;
        this.name = name;
        this.description = description;
        OfficialWebsiteUrl = officialWebsiteUrl;
        this.iconDrawable = iconDrawable;
        this.backgroundDrawble = backgroundDrawble;
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

    public int getIconDrawable() {
        return iconDrawable;
    }

    public int getBackgroundDrawble() {
        return backgroundDrawble;
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

    public void setIconDrawable(int iconDrawable) {
        this.iconDrawable = iconDrawable;
    }

    public void setBackgroundDrawble(int backgroundDrawble) {
        this.backgroundDrawble = backgroundDrawble;
    }
}
