package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    // this allows to read config value by only passing a key without specifying file path every time
    // calls another 'read' method (overloaded) and passes a constant file path(CONFIG-FILE-PATH)
    public static String read(String key) {
        return read(key, Constants.CONFIG_FILE_PATH);
    }

    //THIS ONE PROVIDES MORE FLEXIBILITY BY ALLOWING TO SPECIFY A CUSTOM FILE PATH
    // And  it reads config value from a given  path
    public static String read(String key, String path) {

        Properties properties = new Properties(); // creates empty Properties object that later will be filled with dat from file(key value pair)
        try (FileInputStream input = new FileInputStream(path)) {//to read  the content of the properties file= tries to open file specified by path
            properties.load(input);// loads key-value pairs from the file into the Properties object= reads the contents of the file and makes the key-value pairs accessible
        } catch (IOException ioException) {//this exception handling prevents crushes
            ioException.printStackTrace();//catches IOException prints the error details and prevents program from breaking
        }
        return properties.getProperty(key);// to return the corresponding value of the key that is specified above
    }


}

