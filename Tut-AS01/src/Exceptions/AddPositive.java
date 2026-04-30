package Exceptions;

/*
TODO: Programmieren Sie eine Methode addPositive, die zwei positive Integer addieren soll.
 Wenn nicht positive Zahlen als Parameter übergeben werden, dann soll eine IllegalArgumentException(unchecked Exception)
  geworfen werden.
  Schreibe außerdem eine passende Main Methode, in der du deine Methode testest.
 */
public class AddPositive {

    public static int addPositive(int a, int b){
        if(a< 0|| b<0){
            throw new IllegalArgumentException("Nur positive Zahlen erlaubt");
        }
        return  a + b;
    }

    public static void main(String[] args) {


            System.out.println(addPositive(-3, 2));

    }




}
