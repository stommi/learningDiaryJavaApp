package domain;

import java.util.ArrayList;

public class Aihelista {
    private ArrayList<Topic> aiheet;

    public Aihelista() {
        this.aiheet = new ArrayList<>();
    }

    public void tulostaAiheet() {
        for (Topic aihe: aiheet) {
            System.out.println(aihe.getTitle());
        }
    }

    public void lisaaAihe(Topic aihe) {
        this.aiheet.add(aihe);
    }

    @Override
    public String toString() {
        return " " + aiheet;
    }
}
