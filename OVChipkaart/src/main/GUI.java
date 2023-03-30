package main;

import resources.Constants;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame {

   private final JComboBox<String> chipSelect;
   private final JPanel paalPanel;
   private final JPanel nsPanel;

   public GUI() {
      chipSelect = new JComboBox<>();
      chipSelect.setPreferredSize(new Dimension(100, 40));
      chipSelect.setBackground(Constants.BUTTON_BACKGROUND_COLOR);
      chipSelect.setFocusable(false);

      nsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 15));
      nsPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
      nsPanel.setBackground(Constants.BACKGROUND_COLOR);
      nsPanel.setBounds(20, 15, 558, 68);
      nsPanel.setBorder(BorderFactory.createLineBorder(Constants.OV_COLOR, 1));


      paalPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
      paalPanel.setBackground(Constants.BACKGROUND_COLOR);
      paalPanel.setBounds(20, 115, 558, 288);
      paalPanel.setBorder(BorderFactory.createLineBorder(Constants.OV_COLOR, 1));

      // frame settings
      ImageIcon icon = new ImageIcon("OVChipkaart\\src\\resources\\OV logo.png");
      this.setIconImage(icon.getImage());

      int frameHeight = 469; // 430 actual height
      int frameWidth = 616; // 600 actual width
      this.setSize(frameWidth, frameHeight);
      this.setTitle("OV pro systeem");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.getContentPane().setBackground(Constants.BACKGROUND_COLOR);
      this.setLayout(null);
      this.setResizable(false);
      this.setLocationRelativeTo(null);
      this.setVisible(true);

      // adding components
      nsPanel.add(chipSelect);
      this.add(nsPanel);
      this.add(paalPanel);
   }

   /**
    * Adds a city panel to the paalPanel
    *
    * @param panel panel to add
    */
   public void addCityPanel(JPanel panel) {
      paalPanel.add(panel);
      this.setVisible(true);

   }

   /**
    * Adds a button to the nsPanel
    *
    * @param button button to add
    */
   public void addNSButton(JButton button) {
      nsPanel.add(button);
      this.setVisible(true);

   }


   /**
    * Adds a chip to the chip select combobox
    *
    * @param chip chip to add
    */
   public void addChipSelect(Chip chip) {
      chipSelect.addItem(chip.getName());
   }

   /**
    * Gets the selected chip
    *
    * @return chip returns selected chip
    */
   public Chip getSelectedChip() throws IndexOutOfBoundsException {
      return Main.getChipList().get(chipSelect.getSelectedIndex());
   }

   /**
    * Makes JLabel
    *
    * @param innerText       text to be added in label
    * @param backgroundColor background color
    * @param opaque          background color is visible
    * @return label           returns label
    */
   public JLabel labelFactory(String innerText, Color backgroundColor, boolean opaque) {
      JLabel label = new JLabel();
      label.setHorizontalAlignment(JLabel.CENTER);
      label.setVerticalAlignment(JLabel.CENTER);

      label.setText(innerText);
      label.setBackground(backgroundColor);
      label.setOpaque(opaque);
      return label;
   }

   /**
    * Makes JButton
    *
    * @param innerText text to be added in button
    * @return button returns button
    */
   public JButton buttonFactory(String innerText, ActionListener action, int width, int height, boolean showBackground) {
      JButton button = new JButton();
      button.setCursor(new Cursor(Cursor.HAND_CURSOR));
      button.setBorder(null);
      button.setFocusable(false);

      button.addActionListener(action);
      button.setPreferredSize(new Dimension(width, height));
      button.setText(innerText);
      button.setBackground(Constants.BUTTON_BACKGROUND_COLOR);
      button.setOpaque(showBackground);
      return button;
   }
}