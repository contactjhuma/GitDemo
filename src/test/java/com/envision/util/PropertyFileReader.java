package com.envision.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
    public static String getfile(String filename, String value) throws FileNotFoundException {
        String foldername="testdata";
        FileInputStream fis=new FileInputStream(foldername+"//"+filename);
        Properties p=new Properties();
        try {
            p.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return p.getProperty(value);

    }
}
