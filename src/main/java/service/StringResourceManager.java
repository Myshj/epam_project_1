package service;

import java.util.Locale;
import java.util.ResourceBundle;

public enum StringResourceManager {
    INSTANCE;

    private ResourceBundle resourceBundle;
    private static final String resourceName = "strings";

    StringResourceManager() {
        this.resourceBundle = ResourceBundle.getBundle(resourceName, Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        this.resourceBundle = ResourceBundle.getBundle(resourceName, locale);
    }

    public String getValue(String key) {
        return resourceBundle.getString(key);
    }
}
