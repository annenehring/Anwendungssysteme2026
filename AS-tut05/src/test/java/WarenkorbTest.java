import org.example.JUnit.Warenkorb;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WarenkorbTest {

    private static Warenkorb w = new Warenkorb();

    @Test
    @Order(1)
    void testAnzahl(){
    assertEquals(0,w.anzahl());
    }

    @Order(2)
    @Test
    void testHinzufpgen(){
        w.hinzufuegen("Apfel");
        assertEquals(1, w.anzahl());
    }

    @Test
    @Order(3)
    void testLeeren(){
        w.leeren();
        assertEquals(0,w.anzahl());
    }



}
