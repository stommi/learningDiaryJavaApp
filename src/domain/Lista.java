package domain;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Lista {
    private ArrayList<String> aiheet;

    public Lista() {
        this.aiheet = new ArrayList<>();
    }

    public void tulostaAiheet() {
        String tiedosto = "paivakirja.txt";

        try (Scanner tiedostonLukija = new Scanner(new File(tiedosto))) {
            while (tiedostonLukija.hasNextLine()) {
                aiheet.add(tiedostonLukija.nextLine());
            }
        } catch (Exception e) {
            System.err.println("Tiedoston " + tiedosto + " lukeminen epäonnistui.");
        }

        for (String rivi : aiheet) {
            System.out.println(rivi);
        }
    }



}
