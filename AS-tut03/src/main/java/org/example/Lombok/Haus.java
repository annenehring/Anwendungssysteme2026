package org.example.Lombok;

import lombok.*;

/*
TODO: Erstelle eine Klasse Haus in der du Lombok
 benutzt und damit automatisch eine toString Methode und Getter und Setter erstellst (Zusatz: Konstruktor)

 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Haus {

    private String name;
    private int etagen;

    public static void main(String[] args) {
        Haus h = new Haus("anne", 4);
        Haus h2 = new Haus();

        h.setName("blaues Haus");
        h.toString();
    }



}
