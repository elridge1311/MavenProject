package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config/config.properties");
                System.exit(1);
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }

        // Get the property value from the loaded properties file
        String myProperty = properties.getProperty("my.property", "default value");

        // Print the result
        String template = "My Name is : ${my.property}";
        String result = template.replace("${my.property}", myProperty);
        System.out.println(result);
    }
}
