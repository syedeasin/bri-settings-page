package com.example.testbrilliant;

public class settingPageModel {
    String settingsItemName;
    int settingsIcon;

    public settingPageModel(String settingsItemName, int settingsIcon) {
        this.settingsItemName = settingsItemName;
        this.settingsIcon = settingsIcon;
    }

    public String getSettingsItemName() {
        return settingsItemName;
    }

    public int getSettingsIcon() {
        return settingsIcon;
    }
}
