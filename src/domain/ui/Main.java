package domain.ui;

import domain.Aihelista;
import domain.Kirjoituskone;
import domain.Lista;
import domain.Topic;

import java.util.Scanner;

public class Main {
    Scanner lukija = new Scanner(System.in);
    Kirjoituskone kirjoituskone = new Kirjoituskone();
    Lista kaikkiAiheet = new Lista();
    Aihelista aiheet = new Aihelista();

    private static final String menuteksti = "\n Anna vaihtoehto:\n"
            + "1 Lisää uusi aihe\n"
            + "2 Tulosta aiheet\n"
            + "3 Hae yksittainen aihe\n"
            + "4 Lopeta";

    public void run() {
        Scanner lukija = new Scanner(System.in);
        for (; ; ) {
            System.out.println(menuteksti);
            String vastaus = lukija.nextLine().trim();
            if ("1".equals(vastaus)) {
                lisaaAihe(lukija);
            } else if ("2".equals(vastaus)) {
                aiheet.luoOliot();
                aiheet.tulostaKaikkiAiheet();
            } else if ("3".equals(vastaus)) {
                aiheet.luoOliot();
                haeYksittainenAihe(lukija);
            }else if ("4".equals(vastaus)) {
                break;
            } else {
                System.err.println(String.format("Tuntematon vaihtoehto: '%s'", vastaus));
            }
        }
    }


    public static void main(String[] args) {
        new Main().run();
    }

    private void lisaaAihe(Scanner lukija) {
        System.out.print("Syötä opiskellun aiheen otsikko: ");
        String aihe = lukija.nextLine();

        Topic t1 = new Topic(aihe);

        System.out.print("Syötä kuvaus: ");
        String kuvaus = lukija.nextLine();
        t1.setDescription(kuvaus);

        System.out.print("Syötä mahdollinen lähde esim. web url tai kirja: ");
        String lahde = lukija.nextLine();
        t1.setAdditionalSource(lahde);

        System.out.print("Onko aiheen opiskelu kesken, syötä true tai false: ");
        boolean tila = Boolean.parseBoolean(lukija.nextLine());
        t1.setComplete(tila);

        kirjoituskone.kirjoita(t1);
    }

    private void haeYksittainenAihe(Scanner lukija) {
        System.out.println("Alla on kaikkien aiheiden otsitkot, anna indeksi tarkastellaksesi aihetta: ");
        aiheet.tulostaAiheet();
        int indeksi = Integer.valueOf(lukija.nextLine());
        System.out.println(aiheet.getTopic(indeksi));

    }

}

