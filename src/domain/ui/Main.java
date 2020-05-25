package domain.ui;

import domain.Aihelista;
import domain.Kirjoituskone;
import domain.Lista;
import java.util.Scanner;

public class Main {
    Scanner lukija = new Scanner(System.in);
    Kirjoituskone kirjoituskone = new Kirjoituskone();
    Lista kaikkiAiheet = new Lista();
    Aihelista aiheet = new Aihelista();

    private static final String menuteksti = "\n Anna vaihtoehto:\n"
            + "1 Lisää uusi aihe\n"
            + "2 Tulosta aiheet\n"
            + "3 Tarkastele yksittaista aihetta\n"
            + "4 Hae aihetta otsikolla\n"
            + "5 Poista aihe\n"
            + "6 Muokkaa aihetta\n"
            + "7 Lopeta";

    public void run() {
        aiheet.luoOliot();
        for (; ; ) {
            System.out.println(menuteksti);
            String vastaus = lukija.nextLine().trim();
            if ("1".equals(vastaus)) {
                aiheet.lisaaAiheenTiedot(lukija);
            } else if ("2".equals(vastaus)) {
                aiheet.tulostaKaikkiAiheet();
            } else if ("3".equals(vastaus)) {
                aiheet.haeYksittainenAihe(lukija);
            } else if ("4".equals(vastaus)) {
                aiheet.haeOtsikolla(lukija);
            } else if ("5".equals(vastaus)) {
                aiheet.poistaAihe(lukija);
            } else if ("6".equals(vastaus)) {
                aiheet.muokkaaAihetta(lukija);
            } else if ("7".equals(vastaus)) {
                break;
            } else {
                System.err.println(String.format("Tuntematon komento: '%s'", vastaus));
            }
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}

