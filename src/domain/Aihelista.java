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
    private Kirjoituskone kirjoituskone;


    public Aihelista() {
        this.aiheet = new ArrayList<>();
        this.kirjoituskone = new Kirjoituskone();
    }

    public void tulostaAiheet() {
        int i = 0;
        for (Topic aihe : aiheet) {
            System.out.println(aihe.getTitle() + " (" + i + ")");
            i++;
        }
    }

    public void haeOtsikolla(Scanner lukija) {
        System.out.print("Anna etsittävän aiheen otsikko: ");
        String otsikko = lukija.nextLine();
        int i = 0;

        for (Topic aihe : this.aiheet) {
            String etsittava = aihe.getTitle();
            if (otsikko.equals(etsittava)) {
                System.out.println("Löytyi!\n");
                System.out.println(aihe);
                i++;
                break;
            }
        }

        if (i==0) {
            System.out.println("Aihetta ei löytynyt.");
        }

    }

    public void tulostaKaikkiAiheet() {
        for (Topic aihe : aiheet) {
            System.out.println(aihe);
        }
    }

    public void poistaAihe(Scanner lukija) {
        int i = 0;
        for (Topic aihe : aiheet) {
            System.out.println(aihe.getTitle() + " (" + i + ")");
            i++;
        }

        int indeksi = Integer.parseInt(lukija.nextLine());
        aiheet.remove(indeksi);

        kirjoituskone.poistaja(aiheet);

    }

    public void muokkaaAihetta(Scanner lukija) {
        int i = 0;
        for (Topic aihe : aiheet) {
            System.out.println(aihe.getTitle() + " (" + i + ")");
            i++;
        }

        System.out.print("Mitä aihetta tahdot muokata, anna indeksi: ");
        int indeksi = Integer.parseInt(lukija.nextLine());

        System.out.println("Mitä ominaisuutta tahdot muokata? Anna indeksi:\n" +
                "1 Otsikko\n2 Kuvaus\n3 Mahdollinen lähde\n4 Onko aiheen opiskelu kesken\n5 Milloin aihe on opiskeltu");

        String valinta = lukija.nextLine().trim();

        if ("1".equals(valinta)) {
            System.out.print("Anna uusi otsikko: ");
            String kuvaus = lukija.nextLine();
            aiheet.get(indeksi).setTitle(kuvaus);
            kirjoituskone.poistaja(aiheet);
        }

        if ("2".equals(valinta)) {
            System.out.print("Anna uusi kuvaus: ");
            String kuvaus = lukija.nextLine();
            aiheet.get(indeksi).setDescription(kuvaus);
            kirjoituskone.poistaja(aiheet);
        }

        if ("3".equals(valinta)) {
            System.out.print("Anna uusi lähde: ");
            String kuvaus = lukija.nextLine();
            aiheet.get(indeksi).setAdditionalSource(kuvaus);
            kirjoituskone.poistaja(aiheet);
        }

        if ("4".equals(valinta)) {
            System.out.print("Onko aiheen opiskelu kesken, syötä uusi arvo: true|false: ");
            boolean kuvaus = Boolean.parseBoolean(lukija.nextLine());
            aiheet.get(indeksi).setComplete(kuvaus);
            kirjoituskone.poistaja(aiheet);
        }

        if ("5".equals(valinta)) {
            System.out.print("Syötä aiheen päivämäärä millon aihe on opiskelutu muodossa: year-month-day (esim. 2019-09-15) ");

            String uusipaivays = lukija.nextLine();
            LocalDate kuvaus = LocalDate.parse(uusipaivays, formatter);

            aiheet.get(indeksi).setCompletionDate(kuvaus);
            kirjoituskone.poistaja(aiheet);
        }  else {
            System.err.println(String.format("Tuntematon vaihtoehto: '%s'", valinta));
        }



    }

    public Topic getTopic(int indeksi) {
        return aiheet.get(indeksi);
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




