package org.example.JUnit;

import java.util.ArrayList;
import java.util.List;

//TODO: Schreibe hierfür einen Test
public class Warenkorb {
    private List<String> items = new ArrayList<>();

    public void hinzufuegen(String item) {
        items.add(item);
    }

    public int anzahl() {
        return items.size();
    }

    public void leeren() {
        items.clear();
    }
}
