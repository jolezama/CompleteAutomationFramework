package com.automationCompany.automation.config;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class ConfigManager {

    private static final String DEFAULT_ENV = "uat";
    private static final String ENVIRONMENT = System.getProperty("env", DEFAULT_ENV).toLowerCase();
    private static final Properties props = new Properties();

    static {
        String configPath = String.format("src/test/resources/config-%s.properties", ENVIRONMENT);

        try (FileInputStream inputStream = new FileInputStream(configPath)) {
            props.load(inputStream);
        } catch (Exception primaryException) {
            throw new RuntimeException(
                    String.format("Cannot load config for env '%s' at '%s'. Available path exists: %s",
                            ENVIRONMENT,
                            configPath,
                            Files.exists(Path.of(configPath))
                    ),
                    primaryException
            );
        }
    }

    public static String get(String key) {
        String value = props.getProperty(key);
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Missing required config key: " + key + " for env: " + ENVIRONMENT);
        }
        return value;
    }

    public static String getBaseUrl(String appKey) {
        return get("baseUrl." + appKey.toLowerCase());
    }

    public static String getEnvironment() {
        return ENVIRONMENT;
    }
}
