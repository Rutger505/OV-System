package main;

import java.util.ArrayList;

public class Main {

   private static final ArrayList<Chip> chipList = new ArrayList<>();
   private static GUI gui;

   public static void main(String[] args) {
      gui = new GUI();

      new NSMachine(gui);
      // ov palen rond Nederland
      new OvPaal(130, 25, "Maastricht", gui);
      new OvPaal(120, 90, "Eindhoven", gui);
      new OvPaal(110, 120, "'s-Hertogenbosch", gui);
      new OvPaal(140, 140, "Nijmegen", gui);
      new OvPaal(65, 150, "Rotterdam", gui);
      new OvPaal(97, 170, "Utrecht", gui);
      new OvPaal(115, 180, "Amersfoort", gui);
      new OvPaal(85, 205, "Amsterdam", gui);
      new OvPaal(115, 305, "Harlingen", gui);
      new OvPaal(180, 310, "Groningen", gui);
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
}