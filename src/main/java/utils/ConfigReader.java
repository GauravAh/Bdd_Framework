package utils;

import constants.ConstantClass;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties(){
        // load base.properties
        loadFile(ConstantClass.configPath_base);

        // load endpoint.properties
        loadFile(ConstantClass.configPath_endpoint);

        // load environment directly from base properties
        String environmentVal = properties.getProperty("environment");
        if(environmentVal == null || environmentVal.isEmpty()){
            throw new RuntimeException("Environment is not found in base property");
        }

        String environment1 = System.getProperty("qa","dev");

        // load environment specific system.properties
        loadFile("config/" + environmentVal + "/system.properties");


    }

    private static void loadFile(String filePath){
        InputStream inputStream =  ConfigReader.class.getClassLoader().getResourceAsStream(filePath);
        try {
            if(inputStream == null){
                throw new RuntimeException("Property File not found..");
            }
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProp(String key){
        return properties.getProperty(key);
    }

}
