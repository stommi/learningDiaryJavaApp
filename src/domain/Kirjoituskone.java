package domain;

import java.io.FileWriter;
import java.util.ArrayList;

public class Kirjoituskone {

    public Kirjoituskone() {
    }

    public void kirjoita(Topic teksti) {
        try {
            FileWriter kirjoittaja = new FileWriter("paivakirja.txt", true);
            kirjoittaja.write(String.valueOf(teksti));
            kirjoittaja.close();
        } catch (Exception e) {
            System.err.println("Tapahtui virhe " + e.getMessage());
        }
    }

    public void poistaja(ArrayList<Topic> lista) {
        try {
        FileWriter tyhjentaja = new FileWriter("paivakirja.txt");
        tyhjentaja.write("");


            FileWriter kirjoittaja = new FileWriter("paivakirja.txt",true);
            for (Topic t : lista) {
                kirjoittaja.write(String.valueOf(t));
            }

            kirjoittaja.close();

        } catch (Exception e) {
            System.err.println("Tapahtui virhe " + e.getMessage());
        }
    }
}