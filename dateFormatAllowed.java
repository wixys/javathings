import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
  public static void main(String[] args) {
 
    try {
      // Regular expression to define rule
      String regexp = "([0][1-9]|[1-2][0-9]|[3][0-1])/([0][1-9]|[1][0-2])/\\d{4}";
      // Input data
      String date = "03/01/2021";
      // Validation rule date format allowed: 22/01/2021
      boolean dateFormatAllowed = Pattern.matches(regexp, date);
      
      if(!dateFormatAllowed) {
		System.out.println("Date format is not allowed");
		return;
      }
      
      // Validation rule expiry date of some product
      String expiryDate = "02/01/2021";
      
      SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
      Date setDate = format.parse(date);
      Date productExpiryDate = format.parse(expiryDate);
      
      System.out.println("Current date: " + format.format(setDate));
      System.out.println("Product expiry date: " + format.format(productExpiryDate));
      
      if(setDate.equals(productExpiryDate)){
        System.out.println("Last day man, you'd better get rid of that");
      }else if (setDate.after(productExpiryDate)) {
        System.out.println("Date has expired, you have troubles dude!");
      }else{
        System.out.println("Product has not passed its shelf life. Still eatable I guess");
      }
   
    } catch (ParseException ex) {
        ex.printStackTrace();
    }
   
  }
}
