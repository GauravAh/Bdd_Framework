package base;

import utils.ConfigReader;

public class BaseClass {

    public static String initializeApplication(){
        String url = ConfigReader.getProp("baseurl");
        return url;
    }

    public static String initializeApplicationSignIn(){
        String url = ConfigReader.getProp("baseQAurl");
        return url;
    }



}
