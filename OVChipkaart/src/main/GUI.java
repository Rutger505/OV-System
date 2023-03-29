package main;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class GUI extends JFrame {

   private final JComboBox<String> chipSelect;

   public GUI(ArrayList<OvPaal> paalList, NSMachine machine) {

      Color buttonBackground = new Color(242, 242, 242);

      JButton ovKopenB = buttonFactory("OV kopen", machine, 100, 40, buttonBackground);
      JButton ovOpladenB = buttonFactory("OV opladen", machine, 100, 40, buttonBackground);
      JButton saldoB = buttonFactory("Saldo", machine, 100, 40, buttonBackground);

      chipSelect = new JComboBox<>();
      chipSelect.setPreferredSize(new Dimension(100, 40));
      chipSelect.setBackground(buttonBackground);
      chipSelect.setFocusable(false);

      String buttonIncheckenText = "Inchecken";
      String buttonUitcheckenText = "Uitchecken";

      JButton paalMaastrichtIn = buttonFactory(buttonIncheckenText, paalList.get(0), 70, 20, buttonBackground);
      JButton paalMaastrichtUit = buttonFactory(buttonUitcheckenText, paalList.get(0), 70, 20, buttonBackground);

      JButton paalEindhovenIn = buttonFactory(buttonIncheckenText, paalList.get(1), 70, 20, buttonBackground);
      JButton paalEindhovenUit = buttonFactory(buttonUitcheckenText, paalList.get(1), 70, 20, buttonBackground);

      JButton paalSHertogenboschIn = buttonFactory(buttonIncheckenText, paalList.get(2), 70, 20, buttonBackground);
      JButton paalSHertogenboschUit = buttonFactory(buttonUitcheckenText, paalList.get(2), 70, 20, buttonBackground);

      JButton paalNijmegenIn = buttonFactory(buttonIncheckenText, paalList.get(3), 70, 20, buttonBackground);
      JButton paalNijmegenUit = buttonFactory(buttonUitcheckenText, paalList.get(3), 70, 20, buttonBackground);

      JButton paalRotterdamIn = buttonFactory(buttonIncheckenText, paalList.get(4), 70, 20, buttonBackground);
      JButton paalRotterdamUit = buttonFactory(buttonUitcheckenText, paalList.get(4), 70, 20, buttonBackground);

      JButton paalUtrechtIn = buttonFactory(buttonIncheckenText, paalList.get(5), 70, 20, buttonBackground);
      JButton paalUtrechtUit = buttonFactory(buttonUitcheckenText, paalList.get(5), 70, 20, buttonBackground);

      JButton paalAmesfoortIn = buttonFactory(buttonIncheckenText, paalList.get(6), 70, 20, buttonBackground);
      JButton paalAmesfoortUit = buttonFactory(buttonUitcheckenText, paalList.get(6), 70, 20, buttonBackground);

      JButton paalAmsterdamIn = buttonFactory(buttonIncheckenText, paalList.get(7), 70, 20, buttonBackground);
      JButton paalAmsterdamUit = buttonFactory(buttonUitcheckenText, paalList.get(7), 70, 20, buttonBackground);

      JButton paalHarlingenIn = buttonFactory(buttonIncheckenText, paalList.get(8), 70, 20, buttonBackground);
      JButton paalHarlingenUit = buttonFactory(buttonUitcheckenText, paalList.get(8), 70, 20, buttonBackground);

      JButton paalGroningenIn = buttonFactory(buttonIncheckenText, paalList.get(9), 70, 20, buttonBackground);
      JButton paalGroningenUit = buttonFactory(buttonUitcheckenText, paalList.get(9), 70, 20, buttonBackground);

      JPanel nsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 15));
      nsPanel.setBackground(Color.white);
      nsPanel.setBounds(20, 15, 558, 68);
      nsPanel.setBorder(BorderFactory.createLineBorder(new Color(230, 0, 126), 1));


      JPanel paalPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
      paalPanel.setBackground(Color.white);
      paalPanel.setBounds(20, 115, 558, 288);
      paalPanel.setBorder(BorderFactory.createLineBorder(new Color(230, 0, 126), 1));

      JPanel paalMaastricht = paalStadFactory("Maastricht", paalMaastrichtIn, paalMaastrichtUit);
      JPanel paalEindhoven = paalStadFactory("Eindhoven", paalEindhovenIn, paalEindhovenUit);
      JPanel paalSHertogenbosch = paalStadFactory("SHertogenbosch", paalSHertogenboschIn, paalSHertogenboschUit);
      JPanel paalNijmegen = paalStadFactory("Nijmegen", paalNijmegenIn, paalNijmegenUit);
      JPanel paalRotterdam = paalStadFactory("Rotterdam", paalRotterdamIn, paalRotterdamUit);
      JPanel paalUtrecht = paalStadFactory("Utrecht", paalUtrechtIn, paalUtrechtUit);
      JPanel paalAmesfoort = paalStadFactory("Amesfoort", paalAmesfoortIn, paalAmesfoortUit);
      JPanel paalAmsterdam = paalStadFactory("Amsterdam", paalAmsterdamIn, paalAmsterdamUit);
      JPanel paalHarlingen = paalStadFactory("Harlingen", paalHarlingenIn, paalHarlingenUit);
      JPanel paalGroningen = paalStadFactory("Groningen", paalGroningenIn, paalGroningenUit);

      // frame settings
      ImageIcon icon = new ImageIcon("OVChipkaart\\src\\resources\\OV logo.png");
      this.setIconImage(icon.getImage());


      int frameHeight = 469; // 430 actual height

      int frameWidth = 616; // 600 actual width
      this.setSize(frameWidth, frameHeight);
      this.setTitle("OV pro systeem");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.getContentPane().setBackground(Color.white);
      this.setLayout(null);
      this.setResizable(false);
      this.setLocationRelativeTo(null);
      this.setVisible(true);

      // adding comp
      nsPanel.add(ovKopenB);
      nsPanel.add(ovOpladenB);
      nsPanel.add(saldoB);
      nsPanel.add(chipSelect);
      this.add(nsPanel);

      paalPanel.add(paalMaastricht);
      paalPanel.add(paalEindhoven);
      paalPanel.add(paalSHertogenbosch);
      paalPanel.add(paalNijmegen);
      paalPanel.add(paalRotterdam);
      paalPanel.add(paalUtrecht);
      paalPanel.add(paalAmesfoort);
      paalPanel.add(paalAmsterdam);
      paalPanel.add(paalHarlingen);
      paalPanel.add(paalGroningen);
      this.add(paalPanel);
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
    * @return chip returns selected chip
    */
   public Chip getSelectedChip() {
      return Main.getChipList().get(chipSelect.getSelectedIndex());
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

      JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
      panel.setPreferredSize(new Dimension(paalStadWidth, paalStadHeight));
      panel.setBackground(Color.white);
      JLabel label = labelFactory("Station " + stadNaam, paalStadWidth, 20, null, false);

      panel.add(label);
      panel.add(buttonIn);
      panel.add(buttonUit);
      return panel;

   }

   /**
    * Makes JButton
    *
    * @param innerText       text to be added in button
    * @param width           width of button
    * @param height          height of button
    * @param backgroundColor background color
    * @return button returns button
    */
   private JButton buttonFactory(String innerText, ActionListener action, int width, int height, Color backgroundColor) {
      JButton button = new JButton();
      button.setCursor(new Cursor(Cursor.HAND_CURSOR));
      button.setBorder(null);
      button.setFocusable(false);
      button.setOpaque(true);

      button.addActionListener(action);
      button.setPreferredSize(new Dimension(width, height));
      button.setText(innerText);
      button.setBackground(backgroundColor);
      return button;
   }

   /**
    * Makes JLabel
    *
    * @param innerText       text to be added in label
    * @param width           width of label
    * @param height          height of label
    * @param backgroundColor background color
    * @param opaque          background color is visible
    * @return label           returns label
    */
   private JLabel labelFactory(String innerText, int width, int height, Color backgroundColor, boolean opaque) {
      JLabel label = new JLabel();
      label.setHorizontalAlignment(JLabel.CENTER);

      label.setPreferredSize(new Dimension(width, height));
      label.setText(innerText);
      label.setBackground(backgroundColor);
      label.setOpaque(opaque);
      return label;
   }
}