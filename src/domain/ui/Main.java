package domain.ui;

import domain.Kirjoituskone;
import domain.Lista;
import domain.Topic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Kirjoituskone kirjoituskone = new Kirjoituskone();
        Lista kaikkiAiheet = new Lista();

        while (true) {
            System.out.print("Syötä opiskellun aiheen otsikko: ");
            String aihe = lukija.nextLine();
            if (aihe.equals("")) {
                break;
            }

            Topic t1 = new Topic(aihe);

            System.out.print("Syötä kuvaus: ");
            String kuvaus = lukija.nextLine();
            t1.setDescription(kuvaus);

            System.out.print("Syötä mahdollinen lähde esim. web url tai kirja: ");
            String lahde = lukija.nextLine();
            t1.setAdditionalSource(lahde);

            System.out.print("Onko aiheen opiskelu kesken, syötä true tai false: ");
            boolean tila = Boolean.valueOf(lukija.nextLine());
            t1.setComplete(tila);

            kirjoituskone.kirjoita(t1);
        }

        kaikkiAiheet.tulostaAiheet();

    }
}
