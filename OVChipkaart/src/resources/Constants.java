package resources;

import java.awt.*;

public class Constants {
   // colors
   public static final Color OV_COLOR = new Color(230, 0, 126);
   public static final Color BUTTON_BACKGROUND_COLOR = new Color(242, 242, 242);
   public static final Color BACKGROUND_COLOR = new Color(255, 255, 255);

   // Strings
   public static final String WARNING_MESSAGE_TITLE = "Warning";
   public static final String SUCCESS_MESSAGE_TITLE = "Succes";

   /**
    * Prevent unnecessarily instantiation
    */
   private Constants(){
      throw new IllegalStateException("Utility class");
   }
}
