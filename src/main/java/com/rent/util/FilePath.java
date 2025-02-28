package com.rent.util;

import java.io.IOException;
import java.util.Properties;

public class FilePath {

    private static FilePath instance;
    private String path;

    private FilePath() {
        Properties prop = new Properties();
        try {
            prop.load(FilePath.class.getClassLoader().getResourceAsStream("config.properties"));
            this.path = prop.getProperty("path");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static FilePath getInstance() {
        if (instance == null) {
            instance = new FilePath();
        }
        return instance;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
