package Utility;

import org.testng.annotations.DataProvider;

public class DataSet {

    @DataProvider(name = "validCredentials")
    public static Object ValidCredentials(){
        Object[][] data = {
                {"standard_user", "secret_sauce"}
        };
        return data;
    }

    @DataProvider(name = "inValidCredentials")
    public static Object InValidCredentials(){
        Object[][] data = {
                {"rahul_user", "rahul5"}
        };
        return data;
    }
}
