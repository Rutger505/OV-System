package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NSMachine implements ActionListener {

   /**
    * Laad de chip op
    *
    * @param chip   chip om geld op te zetten
    * @param amount hoeveelheid geld om op te laden
    */
   public void opladen(Chip chip, double amount) {
      if (amount <= 0) {
         displayMessage("(Opladen) Je kan niet €0 of minder opladen", "Error", JOptionPane.WARNING_MESSAGE);
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

      switch (buttonText) {
         case "ov kopen" -> {
            String name = getUserInput("Chip naam:", "Chip naam", false);
            double saldo = Double.parseDouble(getUserInput("Saldo:", "Saldo", true));
            Main.addChip(koopKaart(name, saldo));
         }
         case "ov opladen" -> {
            double saldo = Double.parseDouble(getUserInput("Hoeveelheid om op te laden:", "Opladen", true));
            opladen(Main.getGUI().getSelectedChip(), saldo);
         }
         case "saldo" -> {
            String saldo = checkSaldo(Main.getGUI().getSelectedChip());
            displayMessage(saldo, "Saldo", JOptionPane.INFORMATION_MESSAGE);
         }
         default -> displayMessage("Geen knop gevonden", "Waarschuwing", JOptionPane.WARNING_MESSAGE);
      }
   }

   /**
    * Gets user input using JOptionPane and retries if the input is nothing
    *
    * @param message message to show in joptionpane
    * @param title   title to show in joptionpane
    * @param isSaldo if the function should check if input is not number and not under 0
    * @return user input
    */
   private String getUserInput(String message, String title, boolean isSaldo) {
      String input;
      while (true) {
         try {
            input = JOptionPane.showInputDialog(Main.getGUI(), message, title, JOptionPane.QUESTION_MESSAGE);
            if (input.equals("")) {
               throw new NullPointerException("Field is required");
            }
            if (isSaldo) {
               double test = Double.parseDouble(input);
               if (test <= 0) {
                  throw new Exception("Saldo moet hoger zijn dan 0");
               }
            }
            break;
         } catch (NullPointerException exception) {
            displayMessage("Vul het veld eerst in", "Waarschuwing", JOptionPane.WARNING_MESSAGE);
         } catch (NumberFormatException exception) {
            displayMessage("Voer alleen maar nummers of decimalen(2.45) in", "Waarschuwing", JOptionPane.WARNING_MESSAGE);
         } catch (Exception exception) {
            displayMessage("Het saldo moet meer dan 0 zijn", "Waarschuwing", JOptionPane.WARNING_MESSAGE);
         }
      }
      return input;
   }

   /**
    * Shows a dialog with text
    *
    * @param message     message to show
    * @param title       title of the dialog
    * @param messageType type of icon next to message
    */
   private void displayMessage(String message, String title, int messageType) {
      JOptionPane.showMessageDialog(Main.getGUI(), message, title, messageType);
   }

}