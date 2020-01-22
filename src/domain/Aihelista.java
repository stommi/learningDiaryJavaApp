package domain;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.UUID;

public class Aihelista {
    private ArrayList<Topic> aiheet;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public Aihelista() {
        this.aiheet = new ArrayList<>();
    }

    public void tulostaAiheet() {
        for (Topic aihe : aiheet) {
            System.out.println(aihe.getTitle());
        }
    }

    public void tulostaKaikkiAiheet() {
        for (Topic aihe : aiheet) {
            System.out.println(aihe);
        }
    }

    public void lisaaAihe(Topic aihe) {
        this.aiheet.add(aihe);
    }

    public void luoOliot() {
        String tiedosto = "paivakirja.txt";

        try (Scanner tiedostonLukija = new Scanner(new File(tiedosto))) {
            while (tiedostonLukija.hasNextLine()) {

                String[] id = tiedostonLukija.nextLine().split(": ");
                UUID idSyotto = UUID.fromString(id[1]);

                String[] title = tiedostonLukija.nextLine().split(": ");
                String titleSyotto = title[1];

                String[] description = tiedostonLukija.nextLine().split(": ");
                String descriptionSyotto = description[1];

                String[] additionalSource = tiedostonLukija.nextLine().split(": ");
                String additionalSourceSyotto = additionalSource[1];

                String[] complete = tiedostonLukija.nextLine().split(": ");
                boolean completeSyotto = Boolean.parseBoolean(complete[1]);

                formatter = formatter.withLocale(Locale.US);
                String[] creationDate = tiedostonLukija.nextLine().split(": ");
                LocalDate creationDateSyotto = LocalDate.parse(creationDate[1], formatter);

                String[] completionDate = tiedostonLukija.nextLine().split(": ");
                LocalDate completionDateSyotto = null;
                if (!completionDate[1].equals("null")) {
                    completionDateSyotto = LocalDate.parse(completionDate[1], formatter);
                }


                String tyhjaRivi = tiedostonLukija.nextLine();

                Topic t1 = new Topic(titleSyotto, idSyotto, descriptionSyotto, additionalSourceSyotto, completeSyotto, creationDateSyotto, completionDateSyotto);

                lisaaAihe(t1);
            }

        } catch (Exception e) {
            System.err.println("Tiedoston " + tiedosto + " lukeminen epäonnistui. " + e.getMessage());
        }

    }

    @Override
    public String toString() {
        return " " + aiheet;
    }

}




