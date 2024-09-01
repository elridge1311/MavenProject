package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    private static Properties properties = new Properties();

    public static void main(String[] args) throws IOException {
        InputStream input = new FileInputStream("target/config/config.properties");
        properties.load(input);
        String myProperty = properties.getProperty("my.property");
        System.out.println("My Name is : " + myProperty);
    }
}
