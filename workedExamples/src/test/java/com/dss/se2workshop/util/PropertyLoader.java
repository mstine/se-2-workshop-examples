package com.dss.se2workshop.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    public static String getBaseUrl() {
        try {
            Properties prop = new Properties();
            InputStream in = PropertyLoader.class.getResourceAsStream("/test.properties");
            prop.load(in);
            in.close();
            return prop.getProperty("base.url");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
