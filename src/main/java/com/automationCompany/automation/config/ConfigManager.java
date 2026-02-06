package com.automationCompany.automation.config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigManager {

    private static Properties props = new Properties();

    static {
        try {
            props.load(new FileInputStream("src/test/resources/config.properties"));
        } catch (Exception e) {
            throw new RuntimeException("Cannot load config.properties");
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
