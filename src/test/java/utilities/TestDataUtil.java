package utilities;
public class TestDataUtil {
    public static String generateFirstName(){
        return "Dhanu";
    }
    public static String generateLastName(){
        return "Apex" + System.currentTimeMillis();
    }
    public static String generateEmployeeId(){
        return String.valueOf((int)(Math.random()*900000)+100000);
    }
}