package main;

public class Chip {
   private final String name;
   private double saldo;
   private boolean ingeCheckt = false;
   private final int[] cordsIngeCheckt = new int[2];

   public Chip(String name, double saldo) {
      this.name = name;
      this.saldo = saldo;
   }
   // getters

   /**
    * Get name
    *
    * @return name
    */
   public String getName() {
      return name;
   }

   /**
    * get saldo rounded to 2 decimals
    *
    * @return saldo rounded to 2 decimals
    */
   public double getSaldo() {
      return Math.round(saldo * 100) / 100.0;
   }

   /**
    * get ingecheckt
    *
    * @return ingecheckt
    */
   public boolean isIngeCheckt() {
      return ingeCheckt;
   }

   /**
    * get cordsIngeCheckt
    *
    * @param index 0 = x, 1 = y
    * @return cordsIngeCheckt
    */
   public int getCordsIngeCheckt(int index) {
      return cordsIngeCheckt[index];
   }

   // setters
   /**
    * verander saldo
    *
    * @param amount om toe te voegen
    */
   public void changeSaldo(double amount) {
      this.saldo += amount;
   }

   /**
    * check chip uit
    */
   public void checkUit(double cost) {
      ingeCheckt = false;
      changeSaldo(-cost);
   }

   /**
    * Slaat de coördinaten op waar er in is gecheckt en zet ingecheckt op true
    *
    * @param x coördinaat
    * @param y coördinaat
    */
   public void incheckPlaats(int x, int y) {
      cordsIngeCheckt[0] = x;
      cordsIngeCheckt[1] = y;
      ingeCheckt = true;
   }
}