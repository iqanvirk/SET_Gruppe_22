package models;

public class Setting {
    private boolean[] booleanSetting;
    private String[] stringSetting;
    private int settingValue;

    public Setting(boolean[] args, int settingValue) {
        this.booleanSetting = args;
        this.settingValue = settingValue;
    }

    public Setting(String[] args, int settingValue) {
        this.stringSetting = args;
        this.settingValue = settingValue;
    }

    public boolean getBoolean() {
        return this.booleanSetting[this.settingValue];
    }

    public String getString() {
        return this.stringSetting[this.settingValue];
    }

    public void set(int index) {
        if (booleanSetting != null) {
            this.settingValue = index;
        }
        else if (stringSetting != null) {
            this.settingValue = index;
        }
    }
}