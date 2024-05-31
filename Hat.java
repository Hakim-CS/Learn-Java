package NYP_final_odev;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;



public abstract class Hat {
    protected String telefonNumarasi;
    protected ArrayList<Konusma> yapilanAramalar = new ArrayList<>();
    protected ArrayList<Konusma> gelenAramalar = new ArrayList<>();

    // Abstract methods
    public abstract void AramaYap(String numara, int sure);
    public abstract void GelenArama(String numara, int sure);

    // Getters
    public String getTelefonNumarasi() {
        return telefonNumarasi;
    }

    public ArrayList<Konusma> getYapilanAramalar() {
        return yapilanAramalar;
    }

    public ArrayList<Konusma> getGelenAramalar() {
        return gelenAramalar;
    }

    public void setTelefonNumarasi(String telefonNumarasi) {
        this.telefonNumarasi = telefonNumarasi;
    }

    public void setYapilanAramalar(ArrayList<Konusma> yapilanAramalar) {
        this.yapilanAramalar = yapilanAramalar;
    }

    public void setGelenAramalar(ArrayList<Konusma> gelenAramalar) {
        this.gelenAramalar = gelenAramalar;
    }

    public void aramaYap(String numara, int sure) {
        AramaYap(numara, sure);
    }

    public void gelenArama(String numara, int sure) {
        GelenArama(numara, sure);
    }

   //getYapilanAramalar
  
    // Find the longest call
    public Konusma EnUzunKonusma() {
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

    // Sort by call frequency
    public ArrayList<String> AramaSikliginaGoreSirala() {
        HashMap<String, Integer> aramaSikliklari = new HashMap<String, Integer>();

        for (Konusma k : yapilanAramalar) {
            aramaSikliklari.put(k.getArananNumara(), aramaSikliklari.getOrDefault(k.getArananNumara(), 0) + 1);
        }

        ArrayList<Map.Entry<String, Integer>> sortedList = new ArrayList<>(aramaSikliklari.entrySet());
        sortedList.sort((e1, e2) -> {
            int cmp = e2.getValue().compareTo(e1.getValue());
            if (cmp != 0) return cmp;
            return e2.getKey().compareTo(e1.getKey());
        });

        ArrayList<String> sortedNumbers = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedList) {
            sortedNumbers.add(entry.getKey());
        }

        return sortedNumbers;
    }
}
