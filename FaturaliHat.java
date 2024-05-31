package NYP_final_odev;

import java.util.Date;

public class FaturaliHat extends Hat {
    private int aylikUcretsizSure; // in seconds
    private double sabitFaturaTutari;
    private int kullanilanSure; // in seconds

    // Constructor
    public FaturaliHat(String telefonNumarasi, int aylikUcretsizSure, double sabitFaturaTutari) {
        this.telefonNumarasi = telefonNumarasi;
        this.aylikUcretsizSure = aylikUcretsizSure;
        this.sabitFaturaTutari = sabitFaturaTutari;
        this.kullanilanSure = 0;
    }

    // Make a call
    @Override
    public void AramaYap(String numara, int sure) {
        int kalanSure = aylikUcretsizSure - kullanilanSure;
        if (kalanSure >= sure) {
            kullanilanSure += sure;
        } else {
            kullanilanSure += sure;
            sabitFaturaTutari += 2 * ((sure - kalanSure + 59) / 60); // Adding 59 to handle partial minutes
        }
        yapilanAramalar.add(new Konusma(telefonNumarasi, numara, sure, new Date()));
    }

    // Receive a call
    @Override
    public void GelenArama(String numara, int sure) {
        gelenAramalar.add(new Konusma(numara, telefonNumarasi, sure, new Date()));
    }

    // Calculate bill
    public double faturaHesapla() {
        int kullanilanSure = 0; // in seconds
        for (Konusma k : getYapilanAramalar()) {
            kullanilanSure += k.getSure();
        }

        int bedavaSure = aylikUcretsizSure * 60; // convert free minutes to seconds
        double ekUcret = 0.0;

        if (kullanilanSure > bedavaSure) {
            int excessSeconds = kullanilanSure - bedavaSure;
            ekUcret = (excessSeconds / 60) * 2.0; // charge 2 TL for every excess minute
            if (excessSeconds % 60 != 0) {
                ekUcret += 2.0; // charge for any remaining seconds
            }
        }

        return sabitFaturaTutari + ekUcret;
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
