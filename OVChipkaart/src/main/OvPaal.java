package main;

import resources.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OvPaal implements ActionListener {
   private final int[] location = new int[2];
   private final GUI gui;

   private final JPanel paalCityPanel;

   public OvPaal(int x, int y, String cityName, GUI gui) {
      this.gui = gui;

      location[0] = x;
      location[1] = y;

      JButton paalMaastrichtIn = gui.buttonFactory("Inchecken", this, 70, 20, true);
      JButton paalMaastrichtUit = gui.buttonFactory("Uitchecken", this, 70, 20, true);

      paalCityPanel = paalStadFactory(cityName, paalMaastrichtIn, paalMaastrichtUit);

      gui.addCityPanel(paalCityPanel);
   }

   /**
    * checkt chip in
    *
    * @param chip chip om mee in te checken
    */
   private void inchecken(Chip chip) {
      double minSaldo = 20;

      if (chip.isIngeCheckt()) {
         displayMessage("(Inchecken) Je bent al ingecheckt! Check eerst uit om in te checken!", Constants.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
         return;
      }
      if (chip.getSaldo() < minSaldo) {
         displayMessage("(Inchecken) Je hebt minder dan €" + minSaldo + " saldo! Laad eerst je pas op om in te checken", Constants.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
         return;
      }

      chip.incheckPlaats(location[0], location[1]);
      displayMessage("Je bent ingecheckt", Constants.SUCCESS_MESSAGE_TITLE, JOptionPane.INFORMATION_MESSAGE);
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
         displayMessage("(Uitchecken) Je bent nog niet ingecheckt! Check eerst in om uit te checken", Constants.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
         return;
      }
      double horizontalDistance = Math.abs(chip.getCordsIngeCheckt(0) - location[0]);
      double verticalDistance = Math.abs(chip.getCordsIngeCheckt(1) - location[1]);
      double kmTraveled = Math.sqrt(Math.pow(horizontalDistance, 2) + Math.pow(verticalDistance, 2)); // calculating using pythagoras

      chip.checkUit(kmTraveled * costPerKilometer + minCost);
      displayMessage("Je bent uitgecheckt! Saldo: €" + chip.getSaldo(), Constants.SUCCESS_MESSAGE_TITLE, JOptionPane.INFORMATION_MESSAGE);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      String buttonText = e.getActionCommand();
      Chip chip;
      try {
         chip = gui.getSelectedChip();
      } catch (IndexOutOfBoundsException ex) {
         displayMessage("Selecteer eerst een chip!", Constants.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
         return;
      }

      if (buttonText.equalsIgnoreCase("inchecken")) {
         inchecken(chip);
      } else if (buttonText.equalsIgnoreCase("uitchecken")) {
         uitchecken(chip);
      }
   }

   /**
    * Shows a dialog with text
    *
    * @param message     message to show
    * @param title       title of the dialog
    * @param messageType type of icon next to message
    */
   private void displayMessage(String message, String title, int messageType) {
      JOptionPane.showMessageDialog(gui, message, title, messageType);
   }

   /**
    * Makes JPanel with a city name and buttons
    *
    * @param stadNaam  name of city
    * @param buttonIn  button to check in
    * @param buttonUit button to check out
    * @return panel returns panel
    */
   private JPanel paalStadFactory(String stadNaam, JButton buttonIn, JButton buttonUit) {
      int paalStadWidth = 160;
      int paalStadHeight = 55;

      JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));
      panel.setPreferredSize(new Dimension(paalStadWidth, paalStadHeight));
      panel.setBackground(Color.white);
      JLabel label = gui.labelFactory("Station " + stadNaam, Constants.BACKGROUND_COLOR,false);

      panel.add(label);
      panel.add(buttonIn);
      panel.add(buttonUit);
      return panel;
   }
}