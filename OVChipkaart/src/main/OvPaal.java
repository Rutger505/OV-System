package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OvPaal implements ActionListener {
   private final int[] location = {1, 43};

   public OvPaal(int x, int y) {
      location[0] = x;
      location[1] = y;
   }

   /**
    * checkt chip in
    *
    * @param chip chip om mee in te checken
    */
   private void inchecken(Chip chip) {
      double minSaldo = 20;

      if (chip.isIngeCheckt()) {
         displayMessage("(Inchecken) Je bent al ingecheckt! Check eerst uit om in te checken!", "Error", JOptionPane.WARNING_MESSAGE);
         return;
      }
      if (chip.getSaldo() < minSaldo) {
         displayMessage("(Inchecken) Je hebt minder dan €" + minSaldo + " saldo! Laad eerst je pas op om in te checken", "Error", JOptionPane.WARNING_MESSAGE);
         return;
      }

      chip.incheckPlaats(location[0], location[1]);
      displayMessage("Je bent ingecheckt", "Succes", JOptionPane.INFORMATION_MESSAGE);
   }

   /**
    * checkt chip uit
    *
    * @param chip chip om mee in te checken
    */
   private void uitchecken(Chip chip) {
      double minCost = 1.08;
      double costPerKilometer = 0.20;

      if (!chip.isIngeCheckt()) {
         displayMessage("(Uitchecken) Je bent nog niet ingecheckt! Check eerst in om uit te checken", "Error", JOptionPane.WARNING_MESSAGE);
         return;
      }
      double horizontalDistance = Math.abs(chip.getCordsIngeCheckt(0) - location[0]);
      double verticalDistance = Math.abs(chip.getCordsIngeCheckt(1) - location[1]);
      double kmTraveled = Math.sqrt(Math.pow(horizontalDistance, 2) + Math.pow(verticalDistance, 2)); // calculating using pythagoras

      chip.checkUit(kmTraveled * costPerKilometer + minCost);
      displayMessage("Je bent uitgecheckt! Saldo: €" + chip.getSaldo(), "Succes", JOptionPane.INFORMATION_MESSAGE);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      String buttonText = e.getActionCommand();

      if (buttonText.equalsIgnoreCase("inchecken")) {
         inchecken(Main.getGUI().getSelectedChip());
      } else if (buttonText.equalsIgnoreCase("uitchecken")) {
         uitchecken(Main.getGUI().getSelectedChip());
      }
   }

   /**
    * Shows a dialog with text
    * @param message message to show
    * @param title title of the dialog
    * @param messageType type of icon next to message
    */
   private void displayMessage(String message, String title, int messageType) {
      JOptionPane.showMessageDialog(Main.getGUI(), message, title, messageType);
   }
}