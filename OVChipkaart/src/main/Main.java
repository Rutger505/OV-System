package main;

import java.util.ArrayList;

public class Main {

   private static final ArrayList<Chip> chipList = new ArrayList<>();
   private static GUI gui;

   public static void main(String[] args) {
      NSMachine machine = new NSMachine();
      ArrayList<OvPaal> paalList = new ArrayList<>();
      // ov palen rond Nederland
      paalList.add(new OvPaal(130, 25, "Maastricht"));
      paalList.add(new OvPaal(120, 90, "Eindhoven"));
      paalList.add(new OvPaal(110, 120, "'s-Hertogenbosch" ));
      paalList.add(new OvPaal(140, 140, "Nijmegen"));
      paalList.add(new OvPaal(65, 150, "Rotterdam"));
      paalList.add(new OvPaal(97, 170, "Utrecht"));
      paalList.add(new OvPaal(115, 180, "Amersfoort"));
      paalList.add(new OvPaal(85, 205, "Amsterdam"));
      paalList.add(new OvPaal(115, 305, "Harlingen"));
      paalList.add(new OvPaal(180, 310, "Groningen"));
      gui = new GUI(paalList, machine);
   }

   /**
    * Adds a chip to the list and updates it to the gui.
    *
    * @param chip chip to add
    */
   public static void addChip(Chip chip) {
      chipList.add(chip);
      gui.addChipSelect(chip);
   }

   /**
    * Get the list of chips
    *
    * @return the list of chips
    */
   public static ArrayList<Chip> getChipList() {
      return chipList;
   }

   /**
    * Get the gui
    *
    * @return the gui
    */
   public static GUI getGUI() {
      return gui;
   }
}