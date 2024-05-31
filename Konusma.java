package NYP_final_odev;

import java.util.Date;

public class Konusma implements Comparable<Konusma> {
    private String arayanNumara;
    private String arananNumara;
    private int sure; // in seconds
    private Date tarih;

    // Default constructor
    public Konusma() {}

    // Parameterized constructor
    public Konusma(String arayanNumara, String arananNumara, int sure, Date tarih) {
        this.arayanNumara = arayanNumara;
        this.arananNumara = arananNumara;
        this.sure = sure;
        this.tarih = tarih;
    }

    // Getters
    public String getArayanNumara() {
        return arayanNumara;
    }

    public String getArananNumara() {
        return arananNumara;
    }

    public int getSure() {
        return sure;
    }

    public Date getTarih() {
        return tarih;
    }

    // toString method
    @Override
    public String toString() {
        return "Arayan: " + arayanNumara + ", Aranan: " + arananNumara + ", Süre: " + sure + " saniye, Tarih: " + tarih;
    }

    // compareTo method
    @Override
    public int compareTo(Konusma o) {
        return Integer.compare(this.sure, o.getSure());
    }
}
