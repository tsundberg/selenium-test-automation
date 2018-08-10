package se.thinkcode.lib;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private Properties prop = new Properties();
    private InputStream input;

    public PropertiesReader(String propertiesFileName) {
        try {

            input = new FileInputStream(propertiesFileName);
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String read(String propertyKey) {
        return prop.getProperty(propertyKey);
    }
}
