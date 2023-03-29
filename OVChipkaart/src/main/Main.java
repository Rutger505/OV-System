package main;

import java.util.ArrayList;

public class Main {

   private static final ArrayList<Chip> chipList = new ArrayList<>();
   private static GUI gui;

   public static void main(String[] args) {
      NSMachine machine = new NSMachine();
      ArrayList<OvPaal> paalList = new ArrayList<>();
      // ov palen rond Nederland
      paalList.add(new OvPaal(130, 25));
      paalList.add(new OvPaal(120, 90));
      paalList.add(new OvPaal(110, 120));
      paalList.add(new OvPaal(140, 140));
      paalList.add(new OvPaal(65, 150));
      paalList.add(new OvPaal(97, 170));
      paalList.add(new OvPaal(115, 180));
      paalList.add(new OvPaal(85, 205));
      paalList.add(new OvPaal(115, 305));
      paalList.add(new OvPaal(180, 310));
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