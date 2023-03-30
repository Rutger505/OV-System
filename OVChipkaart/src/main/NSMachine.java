package main;

import resources.Constants;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NSMachine implements ActionListener {
   private final GUI gui;

   public NSMachine(GUI gui) {
      this.gui = gui;
      JButton ovKopenB = gui.buttonFactory("OV kopen", this, 100, 40, true);
      JButton ovOpladenB = gui.buttonFactory("OV opladen", this, 100, 40, true);
      JButton saldoB = gui.buttonFactory("Saldo", this, 100, 40, true);

      gui.addNSButton(ovKopenB);
      gui.addNSButton(ovOpladenB);
      gui.addNSButton(saldoB);
   }

   /**
    * Laad de chip op
    *
    * @param chip   chip om geld op te zetten
    * @param amount hoeveelheid geld om op te laden
    */
   public void opladen(Chip chip, double amount) {
      if (amount <= 0) {
         displayMessage("(Opladen) Je kan niet €0 of minder opladen", Constants.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
         return;
      }

      chip.changeSaldo(amount);
   }

   /**
    * check saldo
    *
    * @param chip chip om saldo van te kijken
    */
   public String checkSaldo(Chip chip) {
      return "Het saldo van deze chip is: €" + chip.getSaldo();
   }

   /**
    * Fabriceert een chipkaart
    *
    * @param saldo het saldo wat standaard op de pas staat
    * @return de chipkaart
    */
   public Chip koopKaart(String name, double saldo) {
      return new Chip(name, saldo);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      String buttonText = e.getActionCommand().toLowerCase();

      Chip chip = null;
      if (!buttonText.equals("ov kopen")) {
         try {
            chip = gui.getSelectedChip();
         } catch (IndexOutOfBoundsException ex) {
            displayMessage("Selecteer eerst een chip!", Constants.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
            return;
         }
      }
      switch (buttonText) {
         case "ov kopen" -> {
            String name = getUserInput("Chip naam:", "Chip naam", false);
            if(name == null) {
               return;
            }
            String temp = getUserInput("Saldo:", "Saldo", true);
            if(temp == null){
               return;
            }
            double saldo = Double.parseDouble(temp);
            Main.addChip(koopKaart(name, saldo));
         }
         case "ov opladen" -> {
            String temp = getUserInput("Hoeveelheid om op te laden:", "Opladen", true);
            if(temp == null){
               return;
            }
            double saldo = Double.parseDouble(temp);
            opladen(chip, saldo);
         }
         case "saldo" -> {
            String saldo = checkSaldo(chip);
            displayMessage(saldo, "Saldo", JOptionPane.INFORMATION_MESSAGE);
         }
         default -> displayMessage("Geen knop gevonden", Constants.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
      }
   }

   /**
    * Gets user input using JOptionPane and retries if the input is nothing.
    *
    * @param message message to show in joptionpane
    * @param title   title to show in joptionpane
    * @param isSaldo if the function should check if input is not number and not under 0.
    * @return user input
    */
   private String getUserInput(String message, String title, boolean isSaldo) {
      String input;
      while (true){
         input = JOptionPane.showInputDialog(gui, message, title, JOptionPane.QUESTION_MESSAGE);
         if(input == null) {
            return null;
         }
         if (input.equals("")) {
            displayMessage("Vul het veld eerst in", Constants.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
            continue;
         }
         if (isSaldo) {
            if (!tryParseDouble(input)) {
               displayMessage("Voer alleen maar nummers of decimalen(2.45) in", Constants.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
               continue;
            }
            if (Double.parseDouble(input) <= 0) {
               displayMessage("Het saldo moet meer dan 0 zijn", Constants.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
               continue;
            }
         }
         break;
      }
      return input;
   }

   /**
    * Checks if input is a double
    * @param input input to check
    * @return true or false if input is a double
    */
   private boolean tryParseDouble(String input){
      try {
         Double.parseDouble(input);
         return true;
      } catch (NumberFormatException exception) {
         return false;
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
}