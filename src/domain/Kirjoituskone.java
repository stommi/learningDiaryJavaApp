package domain;

import java.io.FileWriter;

public class Kirjoituskone {

    public Kirjoituskone() {

    }

    public void kirjoita(Topic teksti) {
        try {
            FileWriter kirjoittaja = new FileWriter("paivakirja.txt",true);
            kirjoittaja.write(String.valueOf(teksti));
            kirjoittaja.close();
        } catch (Exception e) {
            System.err.println("Tapahtui virhe " + e.getMessage());
        }
    }
}