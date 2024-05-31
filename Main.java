package NYP_final_odev;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Create a billed line
        FaturaliHat faturaliHat = new FaturaliHat("05551234567", 600, 50.0);
        faturaliHat.aramaYap("05559876543", 200);
        faturaliHat.aramaYap("05559876543", 500);
        faturaliHat.gelenArama("05557654321", 300);
        System.out.println("Faturali Hat Fatura: " + faturaliHat.faturaHesapla());
        System.out.println("En Uzun Konusma: " + faturaliHat.enUzunKonusma());

        // Create a prepaid line
        FaturasizHat faturasizHat = new FaturasizHat("05559876543", 100.0);
        faturasizHat.aramaYap("05551234567", 1500); // Exceed balance
        faturasizHat.gelenArama("05557654321", 100);
        faturasizHat.aramaYap("05013402071", 120);
        System.out.println("Faturasiz Hat Bakiye: " + faturasizHat.getBakiye());
        System.out.println("En uzun konusma : " + faturasizHat.enUzunKonusma());
       // System.out.println(faturaliHat.telefonNumarasi);
       System.out.println(faturaliHat.enUzunKonusma());
       //System.out.println("Arama sikligina gore sirala : " +faturasizHat.AramaSikliginaGoreSirala();
      

        // Call frequency sorting
        System.out.println("Aramaya gore siralama : " + faturaliHat.AramaSikliginaGoreSirala());
    }
}
