package NYP_final_odev;

import java.util.Date;

public class FaturasizHat extends Hat {
    private double bakiye;

    // Constructor
    public FaturasizHat(String telefonNumarasi, double bakiye) {
        this.telefonNumarasi = telefonNumarasi;
        this.bakiye = bakiye;
    }

    // Load balance
    public void BakiyeYukle(double tutar) {
        bakiye += tutar;
    }

    // Make a call
    @Override
    public void AramaYap(String numara, int sure) {
        double ucret = sure * 0.05;
        if (bakiye >= ucret) {
            bakiye -= ucret;
            yapilanAramalar.add(new Konusma(telefonNumarasi, numara, sure, new Date()));
        } else {
            int yapilabilirSure = (int) (bakiye / 0.05);
            if (yapilabilirSure > 0) {
                bakiye = 0;
                yapilanAramalar.add(new Konusma(telefonNumarasi, numara, yapilabilirSure, new Date()));
            }
        }
    }

    // Receive a call
    @Override
    public void GelenArama(String numara, int sure) {
        gelenAramalar.add(new Konusma(numara, telefonNumarasi, sure, new Date()));
    }

    // Get balance
    public double getBakiye() {
        return bakiye;
    }


    // Find the longest call
    public Konusma enUzunKonusma() {
        Konusma longest = null;
        for (Konusma k : yapilanAramalar) {
            if (longest == null || k.getSure() > longest.getSure()) {
                longest = k;
            }
        }
        for (Konusma k : gelenAramalar) {
            if (longest == null || k.getSure() > longest.getSure()) {
                longest = k;
            }
        }
        return longest;
    }
}


