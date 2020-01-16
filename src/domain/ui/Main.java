package domain.ui;
import domain.Topic;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.print("Syöte opiskellun aiheen otsikko: ");
        String aihe = lukija.nextLine();

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

        System.out.println(t1);

    }
}
