import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
  public static void main(String[] args) {
 
    try {
      // Regular expresion to define rule
      String regexp = "\\d{1,2}/\\d{1,2}/\\d{4}";
      // Input data
      String date = "22/01/2021";
      // Validation rule date format allowed: 22/01/2021
      boolean dateFormatAllowed = Pattern.matches(regexp, date);
      
      if(!dateFormatAllowed) {
		return;
      }
      
      // Validation rule expiry date of some product
      String expiryDate = "20/01/2021";
      
      SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
      Date setDate = format.parse(date);
      Date productExpiryDate = format.parse(expiryDate);
      
      System.out.println("Date: " + format.format(setDate));
      System.out.println("Product expiry date: " + format.format(productExpiryDate));
      
      if (setDate.after(productExpiryDate)) {
        System.out.println(
          "Date has expired, you have troubles dude!");
      }
   
    } catch (ParseException ex) {

    }
   
  }
}
